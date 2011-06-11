package tp2.vista.menues;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemCreditosOut extends Imagen {
	
	public static ImagenItemCreditosOut imagenPrincipal; 

	private ImagenItemCreditosOut() {
		this.setNombreArchivoImagen("../imagenes/menues/menu-principal-item-out-creditos.png");
	}

	private ImagenItemCreditosOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemCreditosOut();
	}
	
	public static ImagenItemCreditosOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemCreditosOut(imagenPrincipal);
	}
}