package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenGameOverJuegoGanado extends Imagen {
	
	public static ImagenGameOverJuegoGanado imagenPrincipal; 

	private ImagenGameOverJuegoGanado() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-game-over-juego-ganado.jpg");
	}

	private ImagenGameOverJuegoGanado(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenGameOver(){
		imagenPrincipal = new ImagenGameOverJuegoGanado();
	}
	
	public static ImagenGameOverJuegoGanado nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenGameOver();
		}
		return new ImagenGameOverJuegoGanado(imagenPrincipal);
	}
}