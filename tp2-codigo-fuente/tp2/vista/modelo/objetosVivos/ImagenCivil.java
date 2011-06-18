package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenCivil extends Imagen {
	
	private static ImagenCivil imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenCivil() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_AVION_CIVIL);
	}

	private ImagenCivil(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenCivil(){
		imagenPrincipal = new ImagenCivil();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenCivil nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenCivil();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_AVION_CIVIL * 2 * ValoresDeNaves.avionCivilTamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		return new ImagenCivil(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}