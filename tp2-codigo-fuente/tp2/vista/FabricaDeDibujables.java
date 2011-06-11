package tp2.vista;

import tp2.vista.extras.ImagenExplosion;
import ar.uba.fi.algo3.titiritero.Dibujable;

public class FabricaDeDibujables {
	
	private static boolean imagenesCargadas;
	
	private static void cargarImagenes() {
		ImagenExplosion.nuevaImagen();
	}

	public static Dibujable nuevoDibujoDeExplosion() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenExplosion.nuevaImagen();
	}
	
}
