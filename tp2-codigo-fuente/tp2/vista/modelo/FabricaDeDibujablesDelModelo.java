package tp2.vista.modelo;

import tp2.vista.modelo.extras.*;
import tp2.vista.modelo.mision.ImagenBarraDeEstado;
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
		ImagenAlgo42.nuevaImagen(1);
		
		
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
	// Imagenes de mision
	////////////////////////////////////////////////////////////
	
	public static Dibujable nuevaImagenBarraDeEstado() {
		comprobarCargaDeImagenes();
		return ImagenBarraDeEstado.nuevaImagen();
	}
	
	
	////////////////////////////////////////////////////////////
	// Imagenes de aeronaves
	////////////////////////////////////////////////////////////
	
	public static Dibujable nuevaImagenAlgo42(double escala) {
		comprobarCargaDeImagenes();
		return ImagenAlgo42.nuevaImagen(escala);
	}
	
	public static Dibujable nuevaImagenAvioneta(double escala) {
		comprobarCargaDeImagenes();
		return ImagenAvioneta.nuevaImagen(escala);
	}
	
	public static Dibujable nuevaImagenBombardero(double escala) {
		comprobarCargaDeImagenes();
		return ImagenBombardero.nuevaImagen(escala);
	}

	public static Dibujable nuevaImagenCaza(double escala) {
		comprobarCargaDeImagenes();
		return ImagenCaza.nuevaImagen(escala);
	}
	
	public static Dibujable nuevaImagenCivil(double escala) {
		comprobarCargaDeImagenes();
		return ImagenCivil.nuevaImagen(escala);
	}
	
	public static Dibujable nuevaImagenExplorador(double escala) {
		comprobarCargaDeImagenes();
		return ImagenExplorador.nuevaImagen(escala);
	}
	
	public static Dibujable nuevaImagenHelicoptero(double escala) {
		comprobarCargaDeImagenes();
		return ImagenHelicoptero.nuevaImagen(escala);
	}
}
