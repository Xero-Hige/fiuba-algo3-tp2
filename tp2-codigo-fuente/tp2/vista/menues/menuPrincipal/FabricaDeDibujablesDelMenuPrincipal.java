package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.Dibujable;


public class FabricaDeDibujablesDelMenuPrincipal {
	
	private static boolean imagenesCargadas = false;
	
	private static void cargarImagenes() {
		ImagenFondoMenuPrincipal.nuevaImagen();
		ImagenItemNuevaPartidaOut.nuevaImagen();
		ImagenItemNuevaPartidaOver.nuevaImagen();
		ImagenItemCargarPartidaOut.nuevaImagen();
		ImagenItemCargarPartidaOver.nuevaImagen();
		ImagenItemCreditosOut.nuevaImagen();
		ImagenItemCreditosOver.nuevaImagen();
		ImagenItemComoJugarOut.nuevaImagen();
		ImagenItemComoJugarOver.nuevaImagen();
		ImagenItemSalirOut.nuevaImagen();
		ImagenItemSalirOver.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoMenuPrincipal() {
		comprobarCargaDeImagenes();
		return ImagenFondoMenuPrincipal.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemNuevaPartidaOut() {
		comprobarCargaDeImagenes();
		return ImagenItemNuevaPartidaOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemNuevaPartidaOver() {
		comprobarCargaDeImagenes();
		return ImagenItemNuevaPartidaOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCargarPartidaOut() {
		comprobarCargaDeImagenes();
		return ImagenItemCargarPartidaOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCargarPartidaOver() {
		comprobarCargaDeImagenes();
		return ImagenItemCargarPartidaOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCreditosOut() {
		comprobarCargaDeImagenes();
		return ImagenItemCreditosOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCreditosOver() {
		comprobarCargaDeImagenes();
		return ImagenItemCreditosOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemComoJugarOut() {
		comprobarCargaDeImagenes();
		return ImagenItemComoJugarOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemComoJugarOver() {
		comprobarCargaDeImagenes();
		return ImagenItemComoJugarOver.nuevaImagen();
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
