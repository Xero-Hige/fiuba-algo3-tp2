package tp2.vista.menues.menuComoJugar;

import ar.uba.fi.algo3.titiritero.Dibujable;

public class FabricaDeDibujablesDelMenuComoJugar {
	
	private static boolean imagenesCargadas = false;
	
	private static void cargarImagenes() {
		ImagenFondoMenuComoJugar.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoMenuComoJugar() {
		comprobarCargaDeImagenes();
		return ImagenFondoMenuComoJugar.nuevaImagen();
	}
}
