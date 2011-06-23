package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemReanudarOver extends Imagen {
	
	public static ImagenItemReanudarOver imagenPrincipal; 

	private ImagenItemReanudarOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones-item-over-reanudar.png");
	}

	private ImagenItemReanudarOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenItemReanudarOver(){
		imagenPrincipal = new ImagenItemReanudarOver();
	}
	
	public static ImagenItemReanudarOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenItemReanudarOver();
		}
		return new ImagenItemReanudarOver(imagenPrincipal);
	}
}