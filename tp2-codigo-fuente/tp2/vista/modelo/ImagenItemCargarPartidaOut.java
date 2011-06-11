package tp2.vista.modelo;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemCargarPartidaOut extends Imagen {
	
	public static ImagenItemCargarPartidaOut imagenPrincipal; 

	private ImagenItemCargarPartidaOut() {
		this.setNombreArchivoImagen("../imagenes/menues/menu-principal-item-out-cargar-partida.png");
	}

	private ImagenItemCargarPartidaOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemCargarPartidaOut();
	}
	
	public static ImagenItemCargarPartidaOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemCargarPartidaOut(imagenPrincipal);
	}
}