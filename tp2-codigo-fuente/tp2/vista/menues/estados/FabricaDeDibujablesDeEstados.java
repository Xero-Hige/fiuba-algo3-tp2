package tp2.vista.menues.estados;

import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDeEstados {

	private static boolean imagenesCargadas = false;
	
	
	private static void cargarImagenes() {
		ImagenFondoIniciandoNuevaPartida.nuevaImagen();
		ImagenFondoCargandoPartida.nuevaImagen();
		ImagenFondoGuardandoPartida.nuevaImagen();
		ImagenJuegoPausado.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoIniciandoNuevaPartida() {
		comprobarCargaDeImagenes();
		return ImagenFondoIniciandoNuevaPartida.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenFondoCargandoPartida() {
		comprobarCargaDeImagenes();
		return ImagenFondoCargandoPartida.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenFondoGuardandoPartida() {
		comprobarCargaDeImagenes();
		return ImagenFondoGuardandoPartida.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenJuegoPausado() {
		comprobarCargaDeImagenes();
		return ImagenJuegoPausado.nuevaImagen();
	}
}
