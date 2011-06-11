package tp2.vista.menues;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemCreditosOver extends Imagen {
	
	public static ImagenItemCreditosOver imagenPrincipal; 

	private ImagenItemCreditosOver() {
		this.setNombreArchivoImagen("../imagenes/menues/menu-principal-item-over-creditos.png");
	}

	private ImagenItemCreditosOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemCreditosOver();
	}
	
	public static ImagenItemCreditosOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemCreditosOver(imagenPrincipal);
	}
}