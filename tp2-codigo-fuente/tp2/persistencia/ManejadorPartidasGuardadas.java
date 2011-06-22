package tp2.persistencia;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import tp2.persistencia.excepciones.CriticalError;

public class ManejadorPartidasGuardadas {
	
	/**
	 * Metodo que devuelve un List con los nombres y fechas de modificaciones de las save
	 * @return List con Arrays de la forma:
	 * 	Primera posicion nombre de la save
	 * 	Segunda posicion fecha de ultima modificacion de la save*/
	public static List<String[]> getListaPartidasGuardadas(){
		
		String directorioActual;
		ArrayList<String[]> lista = new ArrayList<String[]>();
		
		directorioActual = BuscadorDeArchivos.getPathDirectoriActual();
		
		HashMap<String, String> archivosSave = BuscadorDeArchivos.getArchivos(directorioActual+"/Saves","save");
		
		Set<String> nombresArchivos = archivosSave.keySet();
		Iterator<String> iter = nombresArchivos.iterator();
		
		while (iter.hasNext()){
			String nombreArchivo = iter.next();
			String pathArchivo = archivosSave.get(nombreArchivo);
			String fechaDeModificacion = getFechaModificacion(pathArchivo);
			nombreArchivo = nombreArchivo.split("\\.")[0];
			String[] archivoYFecha = {nombreArchivo,fechaDeModificacion};
			lista.add(archivoYFecha);
		}
		
		return lista;
	}

	private static String getFechaModificacion(String pathArchivo) {
		File save = new File(pathArchivo);
		long milisegundos = save.lastModified();
		String fecha = milisegundosAFecha(milisegundos);
		return fecha;
	}
	
	private static String milisegundosAFecha(long milisegundos){
		 SimpleDateFormat formatDeFecha = new SimpleDateFormat("MMM dd,yyyy HH:mm");
		 Date fecha = new Date(milisegundos);
		 return formatDeFecha.format(fecha);
	}

	/**
	 * Metodo que devuelve el path de un archivo
	 * @param 
	 * nombreSave El nombre debe ser un nombre obtenido en el metodo getListaPartidasGuardadas
	 * */
	public static String getArchivoSave(String nombreSave){
		String directorioActual;
		
		try {
			File directorio = new File (".");
			directorioActual = directorio.getCanonicalPath();
			}
		catch(Exception e){
			//Exepccion que en ningun caso podria saltar a menos que algo este muy mal
			//El directorio actual siempre existe
			throw new CriticalError();
		}
		
		HashMap<String, String> archivosSave = BuscadorDeArchivos.getArchivos(directorioActual,"save");
		return archivosSave.get(nombreSave+".\\save");		
	}
}