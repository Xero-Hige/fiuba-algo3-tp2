package tp2.vista.modelo;

import tp2.vista.modelo.ImagenExplosion;
import ar.uba.fi.algo3.titiritero.Dibujable;

public class FabricaDeDibujablesDelModelo {
	
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
