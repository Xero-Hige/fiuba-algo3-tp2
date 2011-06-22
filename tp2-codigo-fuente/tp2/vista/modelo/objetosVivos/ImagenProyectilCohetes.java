package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeArmas;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenProyectilCohetes extends Imagen {
	
	private static ImagenProyectilCohetes imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenProyectilCohetes() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_PROYECTIL_LASER);
	}

	private ImagenProyectilCohetes(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenProyectilCohetes(){
		imagenPrincipal = new ImagenProyectilCohetes();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenProyectilCohetes nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenProyectilCohetes();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_PROYECTIL_COHETES * 2 * ValoresDeArmas.lanzaCohetesProyectilTamanio * escala);
		return new ImagenProyectilCohetes(imagenEscalable.getImagenEscalada(tamanioImagen));
	}
}