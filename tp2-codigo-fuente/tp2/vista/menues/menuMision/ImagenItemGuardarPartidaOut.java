package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemGuardarPartidaOut extends Imagen {
	
	public static ImagenItemGuardarPartidaOut imagenPrincipal; 

	private ImagenItemGuardarPartidaOut() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones-item-out-guardar-partida.png");
	}

	private ImagenItemGuardarPartidaOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenItemGuardarPartidaOut(){
		imagenPrincipal = new ImagenItemGuardarPartidaOut();
	}
	
	public static ImagenItemGuardarPartidaOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenItemGuardarPartidaOut();
		}
		return new ImagenItemGuardarPartidaOut(imagenPrincipal);
	}
}