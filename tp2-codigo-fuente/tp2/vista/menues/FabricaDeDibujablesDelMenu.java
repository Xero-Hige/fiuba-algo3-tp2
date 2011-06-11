package tp2.vista.menues;

import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDelMenu {
	
	public static void forzarCargaDeDibujos() {
		ImagenFondoMenuPrincipal.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenFondoMenuPrincipal() {
		return ImagenFondoMenuPrincipal.nuevaImagen();
	}
}
