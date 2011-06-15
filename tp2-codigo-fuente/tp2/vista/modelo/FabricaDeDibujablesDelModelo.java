package tp2.vista.modelo;

import tp2.vista.modelo.extras.*;
import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDelModelo {
	
	private static boolean imagenesCargadas = false;
	
	
	private static void cargarImagenes() {
		ImagenExplosion.nuevaImagen();
		ImagenNubeTipo1.nuevaImagen();
		ImagenNubeTipo2.nuevaImagen();
		ImagenNubeTipo3.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
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
}
