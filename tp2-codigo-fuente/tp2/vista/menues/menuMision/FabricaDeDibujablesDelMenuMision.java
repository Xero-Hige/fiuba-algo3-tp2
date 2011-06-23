package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDelMenuMision {
	
	private static boolean imagenesCargadas = false;
	
	private static void cargarImagenes() {
		ImagenFondoMenuMisionOpciones.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoMenuMisionOpciones() {
		comprobarCargaDeImagenes();
		return ImagenFondoMenuMisionOpciones.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemReanudarOut() {
		comprobarCargaDeImagenes();
		return ImagenItemReanudarOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemReanudarOver() {
		comprobarCargaDeImagenes();
		return ImagenItemReanudarOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemGuardarPartidaOut() {
		comprobarCargaDeImagenes();
		return ImagenItemGuardarPartidaOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemGuardarPartidaOver() {
		comprobarCargaDeImagenes();
		return ImagenItemGuardarPartidaOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemSalirOut() {
		comprobarCargaDeImagenes();
		return ImagenItemSalirOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemSalirOver() {
		comprobarCargaDeImagenes();
		return ImagenItemSalirOver.nuevaImagen();
	}
}