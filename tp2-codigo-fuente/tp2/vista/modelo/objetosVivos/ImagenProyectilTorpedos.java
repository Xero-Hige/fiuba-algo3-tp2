package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeArmas;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenProyectilTorpedos extends Imagen {
	
	private static ImagenProyectilTorpedos imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenProyectilTorpedos() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_PROYECTIL_TORPEDOS);
	}

	private ImagenProyectilTorpedos(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenProyectilTorpedos(){
		imagenPrincipal = new ImagenProyectilTorpedos();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenProyectilTorpedos nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenProyectilTorpedos();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_PROYECTIL_TORPEDOS * 2 * ValoresDeArmas.lanzaTorpedosProyectilTamanio * escala);
		return new ImagenProyectilTorpedos(imagenEscalable.getImagenEscalada(tamanioImagen));
	}
}