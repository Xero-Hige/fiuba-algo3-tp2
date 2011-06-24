package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenGameOver extends Imagen {
	
	public static ImagenGameOver imagenPrincipal; 

	private ImagenGameOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-game-over-juego-perdido.jpg");
	}

	private ImagenGameOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenGameOver(){
		imagenPrincipal = new ImagenGameOver();
	}
	
	public static ImagenGameOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenGameOver();
		}
		return new ImagenGameOver(imagenPrincipal);
	}
}