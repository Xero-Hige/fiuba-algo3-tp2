package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemCargarPartidaOver extends Imagen {
	
	public static ImagenItemCargarPartidaOver imagenPrincipal; 

	private ImagenItemCargarPartidaOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-item-over-cargar-partida.png");
	}

	private ImagenItemCargarPartidaOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemCargarPartidaOver();
	}
	
	public static ImagenItemCargarPartidaOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemCargarPartidaOver(imagenPrincipal);
	}
}