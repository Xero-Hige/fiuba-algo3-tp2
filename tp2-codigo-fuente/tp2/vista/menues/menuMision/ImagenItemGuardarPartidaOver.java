package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemGuardarPartidaOver extends Imagen {
	
	public static ImagenItemGuardarPartidaOver imagenPrincipal; 

	private ImagenItemGuardarPartidaOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones-item-over-guardar-partida.png");
	}

	private ImagenItemGuardarPartidaOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenItemGuardarPartidaOver(){
		imagenPrincipal = new ImagenItemGuardarPartidaOver();
	}
	
	public static ImagenItemGuardarPartidaOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenItemGuardarPartidaOver();
		}
		return new ImagenItemGuardarPartidaOver(imagenPrincipal);
	}
}