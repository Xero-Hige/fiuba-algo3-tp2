package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeBonos;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenBonoDeArmas extends Imagen {
	
	private static ImagenBonoDeArmas imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenBonoDeArmas() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_BONO_ARMAS);
	}

	private ImagenBonoDeArmas(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenBonoDeArmas(){
		imagenPrincipal = new ImagenBonoDeArmas();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenBonoDeArmas nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenBonoDeArmas();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_BONO_ARMAS * 2 * ValoresDeBonos.bonoDeArmasTamanio * escala);
		return new ImagenBonoDeArmas(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}
