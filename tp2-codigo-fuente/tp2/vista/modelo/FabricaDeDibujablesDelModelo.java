package tp2.vista.modelo;

import tp2.vista.modelo.ImagenExplosion;
import ar.uba.fi.algo3.titiritero.Dibujable;

public class FabricaDeDibujablesDelModelo {
	
	public static void forzarCargaDeDibujos() {
		ImagenExplosion.nuevaImagen();
	}

	public static Dibujable nuevoDibujoDeExplosion() {
		return ImagenExplosion.nuevaImagen();
	}
	
}
