package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemReanudarOut extends Imagen {
	
	public static ImagenItemReanudarOut imagenPrincipal; 

	private ImagenItemReanudarOut() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones-item-out-reanudar.png");
	}

	private ImagenItemReanudarOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenItemReanudarOut(){
		imagenPrincipal = new ImagenItemReanudarOut();
	}
	
	public static ImagenItemReanudarOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenItemReanudarOut();
		}
		return new ImagenItemReanudarOut(imagenPrincipal);
	}
}