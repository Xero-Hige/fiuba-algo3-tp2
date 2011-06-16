package tp2.vista.modelo;

import tp2.vista.modelo.extras.*;
import tp2.vista.modelo.objetosVivos.*;
import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDelModelo {
	
	private static boolean imagenesCargadas = false;
	
	
	private static void cargarImagenes() {
		
		// Imagenes extras
		ImagenAgua.nuevaImagen();
		ImagenExplosion.nuevaImagen();
		ImagenNubeTipo1.nuevaImagen();
		ImagenNubeTipo2.nuevaImagen();
		ImagenNubeTipo3.nuevaImagen();
		
		// Imagenes de aeronaves
		ImagenAlgo42.nuevaImagen();
		
		
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	
	////////////////////////////////////////////////////////////
	// Imagenes extras
	////////////////////////////////////////////////////////////
	
	public static Dibujable nuevaImagenAgua() {
		comprobarCargaDeImagenes();
		return ImagenAgua.nuevaImagen();
	}	
	
	public static Dibujable nuevaImagenExplosion() {
		comprobarCargaDeImagenes();
		return ImagenExplosion.nuevaImagen();
	}	
	
	public static Dibujable nuevaImagenNubeTipo1() {
		comprobarCargaDeImagenes();
		return ImagenNubeTipo1.nuevaImagen();
	}	
	
	public static Dibujable nuevaImagenNubeTipo2() {
		comprobarCargaDeImagenes();
		return ImagenNubeTipo2.nuevaImagen();
	}	
	
	public static Dibujable nuevaImagenNubeTipo3() {
		comprobarCargaDeImagenes();
		return ImagenNubeTipo3.nuevaImagen();
	}
	
	
	////////////////////////////////////////////////////////////
	// Imagenes de aeronaves
	////////////////////////////////////////////////////////////
	
	public static Dibujable nuevaImagenAlgo42() {
		comprobarCargaDeImagenes();
		return ImagenAlgo42.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenAvioneta() {
		comprobarCargaDeImagenes();
		return ImagenAvioneta.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenBombardero() {
		comprobarCargaDeImagenes();
		return ImagenBombardero.nuevaImagen();
	}

	public static Dibujable nuevaImagenCaza() {
		comprobarCargaDeImagenes();
		return ImagenCaza.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenCivil() {
		comprobarCargaDeImagenes();
		return ImagenCivil.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenExplorador() {
		comprobarCargaDeImagenes();
		return ImagenExplorador.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenHelicoptero() {
		comprobarCargaDeImagenes();
		return ImagenHelicoptero.nuevaImagen();
	}
}
