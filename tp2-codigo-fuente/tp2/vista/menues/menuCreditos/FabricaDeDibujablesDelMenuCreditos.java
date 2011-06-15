package tp2.vista.menues.menuCreditos;

import ar.uba.fi.algo3.titiritero.Dibujable;

public class FabricaDeDibujablesDelMenuCreditos {
	
	private static boolean imagenesCargadas = false;
	
	private static void cargarImagenes() {
		ImagenFondoMenuCreditos.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoMenuCreditos() {
		comprobarCargaDeImagenes();
		return ImagenFondoMenuCreditos.nuevaImagen();
	}
}
