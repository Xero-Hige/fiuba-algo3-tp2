package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenGameOverJuegoPerdido extends Imagen {
	
	public static ImagenGameOverJuegoPerdido imagenPrincipal; 

	private ImagenGameOverJuegoPerdido() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-game-over-juego-perdido.jpg");
	}

	private ImagenGameOverJuegoPerdido(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenGameOver(){
		imagenPrincipal = new ImagenGameOverJuegoPerdido();
	}
	
	public static ImagenGameOverJuegoPerdido nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenGameOver();
		}
		return new ImagenGameOverJuegoPerdido(imagenPrincipal);
	}
}