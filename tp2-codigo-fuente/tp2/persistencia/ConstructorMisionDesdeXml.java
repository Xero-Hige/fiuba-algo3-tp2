package tp2.persistencia;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.persistencia.excepciones.*;



/**
 * @author Hige: No me gusta el nombre porque no es claro pero es para ahora
 * */
public class ConstructorMisionDesdeXml {

	static String DIRECTORIO_MISIONES = "/src/tp2/configuraciones";
	static String ARCHIVO_MISIONES = "/Misiones.settings";
	static String[] TIPOSDEAVIONES = {"Avioneta","Cazas","Bombardero","Explorador","AvionCivil","HelicopteroFederal"};
	
	
	private static Element getMision(String numeroMision){
		String path = getPathConfiguracion();
		
		Document doc = null;
		try {
			doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			throw new ArchivoConfiguracioneFaltanteError();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NodeList nodos = doc.getElementsByTagName("Mision"+numeroMision);		
		if (nodos.getLength()==0) return null;		
		return(Element)nodos.item(0);		
	}
	
	/**
	 *@author Hige: Hay que hacer una exepccion no controlada para que avise de esta situacion anomala*/
	private static String getPathConfiguracion(){
		
		String directorioActual = null;

		try {
			File directorio = new File (".");
			directorioActual = directorio.getCanonicalPath();
			}
		catch(Exception e){
			//Exepccion que en ningun caso podria saltar a menos que algo este muy mal
			//El directorio actual siempre existe
			throw new CriticalError();
		}
		
		String ArchivoDeMisiones = directorioActual+ DIRECTORIO_MISIONES + ARCHIVO_MISIONES;
		return ArchivoDeMisiones;	
	}
	
	public static Map<Double, Collection<ParCadenaPosicion>> datosMision(int numeroMision){
		String format = String.format("%%0%dd", 3);
		String sNumeroMision = String.format(format, numeroMision);
		
		Element mision = getMision(sNumeroMision);
		
		if (mision == null){
			throw new MisionNoExistenteError();
		}
		
		NodeList flotas = mision.getElementsByTagName("Flota");
		if (flotas.getLength() == 0){
			//Las misiones no puede no tener almenos una Flota
			throw new ArchivoMisionCorruptoError();
		}
		
		Map<Double, Collection<ParCadenaPosicion>> datos = new HashMap<Double, Collection<ParCadenaPosicion>>();
		
		int i=0;
		while (i<flotas.getLength()){
			Element flotaActual = (Element) flotas.item(i);
			Collection<ParCadenaPosicion> flota = getFlota(flotaActual);
			datos.put(Double.parseDouble(flotaActual.getAttribute("tiempo")), flota);
			i++;
		}
		
		return datos;
	}

	private static Collection<ParCadenaPosicion> getFlota(Element elementoFlota) {
		//Crea una coleccion de Pares cadena posicion
		
		ArrayList<Node> aviones = new ArrayList<Node>(); 
		
		int x=0;
		while (x < TIPOSDEAVIONES.length){
			NodeList avionesIntermedios = elementoFlota.getElementsByTagName("Avioneta");
			aviones = sumarNodeList(aviones,avionesIntermedios);
			x++;
		}
		
		if (aviones.isEmpty()){
			//Las flotas no pueden no tener aviones
			throw new ArchivoMisionCorruptoError();
		}
		
		Collection<ParCadenaPosicion> flota = new ArrayList<ParCadenaPosicion> ();
		
		Iterator<Node> iter = aviones.iterator();
		while (iter.hasNext()){
			Element avion = (Element)iter.next();
			flota.add(getAvion(avion));
		}
		
		return flota;
	}

	private static ArrayList<Node> sumarNodeList(ArrayList<Node> aviones,NodeList avionesIntermedios) {
		int i=0;
		
		
		while(i<avionesIntermedios.getLength()){
			aviones.add(avionesIntermedios.item(i));
			i++;
		}
		
		return aviones;
	}

	private static ParCadenaPosicion getAvion(Element avion) {
		//Crea un par cadena posicion desde un elemento que representa a un avion
		
		String posicionX;
		String posicionY;
		try{
			posicionX = avion.getElementsByTagName("X").item(0).getTextContent();
			posicionY = avion.getElementsByTagName("Y").item(0).getTextContent();
		}catch(Exception e){
			throw new ArchivoMisionCorruptoError();
		}
				
		Point posicion = new Point(Double.parseDouble(posicionX),Double.parseDouble(posicionY));
		return new ParCadenaPosicion(avion.getNodeName(),posicion);
	}
}
