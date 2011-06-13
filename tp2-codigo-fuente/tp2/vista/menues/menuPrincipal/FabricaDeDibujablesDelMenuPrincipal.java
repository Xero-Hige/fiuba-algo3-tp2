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
		ImagenItemSalirOut.nuevaImagen();
		ImagenItemSalirOver.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static Dibujable nuevaImagenFondoMenuPrincipal() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenFondoMenuPrincipal.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemNuevaPartidaOut() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemNuevaPartidaOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemNuevaPartidaOver() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemNuevaPartidaOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCargarPartidaOut() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemCargarPartidaOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCargarPartidaOver() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemCargarPartidaOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCreditosOut() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemCreditosOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemCreditosOver() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemCreditosOver.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemSalirOut() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemSalirOut.nuevaImagen();
	}
	
	public static Dibujable nuevaImagenItemSalirOver() {
		if(!imagenesCargadas){
			cargarImagenes();
		}
		return ImagenItemSalirOver.nuevaImagen();
	}
}
