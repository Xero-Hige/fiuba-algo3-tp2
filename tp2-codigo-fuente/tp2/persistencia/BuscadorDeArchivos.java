package tp2.persistencia;
import java.io.File;
import java.io.FilenameFilter;
import java.util.HashMap;

import tp2.persistencia.excepciones.CarpetaNoEncontradaError;

/**
 * Objeto para buscar archivos con una determinada extension
 *  */

public class BuscadorDeArchivos{
	
	/**
	 * Busca todos los archivos en el directorio seleccionado con la extension declarada*/
	public static HashMap<String, String> getArchivos(final String nombreDirectorio,final String extension){
		
		// Creo un filtro para los archivos
		final FilenameFilter filtro = new FilenameFilter(){
			//Redefino el metodo accept de el filtro
			public boolean accept(File directorio, String nombre) {
				return nombre.endsWith("."+extension);
			}
		};
		
		HashMap<String,String> diccionario = new HashMap<String,String>();
	
		File directorio = new File(nombreDirectorio);
		
		String[] directorios = directorio.list(filtro);
		
		if (directorios == null) {
			//Si el directorio no existe, el parametro no es un directorio o no hay archivos
			throw new CarpetaNoEncontradaError();
		}
		
		for (int i=0; i<directorios.length; i++) {
	        //Obtengo el nombre de los archivos 
	        String nombreArchivo = directorios[i];
	        diccionario.put(nombreArchivo, nombreDirectorio+"/"+nombreArchivo);
	    }
		
		return diccionario;
	};
}