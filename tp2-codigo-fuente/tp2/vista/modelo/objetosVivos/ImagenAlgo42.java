package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAlgo42 extends Imagen {
	
	private static ImagenAlgo42 imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenAlgo42() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_ALGO42);
	}

	private ImagenAlgo42(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAlgo42(){
		imagenPrincipal = new ImagenAlgo42();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenAlgo42 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAlgo42();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_ALGO42 * 2 * ValoresDeNaves.algo42Tamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		return new ImagenAlgo42(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}