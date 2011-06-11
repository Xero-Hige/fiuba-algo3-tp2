package tp2.vista.modelo;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemSalirOver extends Imagen {
	
	public static ImagenItemSalirOver imagenPrincipal; 

	private ImagenItemSalirOver() {
		this.setNombreArchivoImagen("../imagenes/menues/menu-principal-item-over-salir.png");
	}

	private ImagenItemSalirOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemSalirOver();
	}
	
	public static ImagenItemSalirOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemSalirOver(imagenPrincipal);
	}
}