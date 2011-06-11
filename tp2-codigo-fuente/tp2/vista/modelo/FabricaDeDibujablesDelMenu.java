package tp2.vista.modelo;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class FabricaDeDibujablesDelMenu {
	
	private static boolean imagenesCargadas;
	
	private static void cargarImagenes() {
		ImagenFondoMenuPrincipal.nuevaImagen();
	}
	
	public static Imagen nuevaImagenFondoMenuPrincipal() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenFondoMenuPrincipal.nuevaImagen();
	}
}
