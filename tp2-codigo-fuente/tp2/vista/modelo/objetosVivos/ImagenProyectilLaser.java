package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeArmas;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenProyectilLaser extends Imagen {
	
	private static ImagenProyectilLaser imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenProyectilLaser() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_PROYECTIL_LASER);
	}

	private ImagenProyectilLaser(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenProyectilLaser(){
		imagenPrincipal = new ImagenProyectilLaser();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenProyectilLaser nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenProyectilLaser();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_PROYECTIL_LASER * 2 * ValoresDeArmas.canionLaserProyectilTamanio * escala);
		return new ImagenProyectilLaser(imagenEscalable.getImagenEscalada(tamanioImagen));
	}
}