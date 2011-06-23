package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenMenuPausa extends Imagen {
	
	public static ImagenMenuPausa imagenPrincipal; 

	private ImagenMenuPausa() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/extras/juego-pausado.png");
	}

	private ImagenMenuPausa(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenMenuPausa(){
		imagenPrincipal = new ImagenMenuPausa();
	}
	
	public static ImagenMenuPausa nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenMenuPausa();
		}
		return new ImagenMenuPausa(imagenPrincipal);
	}
}