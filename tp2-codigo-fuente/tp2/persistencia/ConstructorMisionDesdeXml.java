package tp2.persistencia;

import java.io.File;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;



/**
 * @author Hige: No me gusta el nombre porque no es claro pero es para ahora
 * */
public class ConstructorMisionDesdeXml {

	static String DIRECTORIO_MISIONES = "/Configuraciones";
	static String ARCHIVO_MISIONES = "/Misiones.setings";
	
	
	public static Object getMision(int numeroMision) throws Exception{
		String path = getPathConfiguracion();
		
//		Document documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(path));
		
		return null;
		
	}
	
	/**
	 *@author Hige: Hay que hacer una exepccion no controlada para que avise de esta situacion anomala*/
	private static String getPathConfiguracion() throws Exception{
		
		String directorioActual = null;

		try {
			File directorio = new File (".");
			directorioActual = directorio.getCanonicalPath();
			}
		catch(Exception e){
			//Exepccion que en ningun caso podria saltar a menos que algo este muy mal
			//El directorio actual siempre existe
			throw e;
		}
		
		String ArchivoDeMisiones = directorioActual+ DIRECTORIO_MISIONES + ARCHIVO_MISIONES;
		return ArchivoDeMisiones;	
	}
	
}
