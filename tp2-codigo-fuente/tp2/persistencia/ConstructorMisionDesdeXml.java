package tp2.persistencia;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import tp2.auxiliares.ParCadenaPosicion;



/**
 * @author Hige: No me gusta el nombre porque no es claro pero es para ahora
 * */
public class ConstructorMisionDesdeXml {

	static String DIRECTORIO_MISIONES = "/src/tp2/configuraciones";
	static String ARCHIVO_MISIONES = "/Misiones.settings";
	
	
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
			throw new ArchivoMisionCorruptoError();
		}
		
		return null;
	}
}
