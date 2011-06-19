package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenCaza extends Imagen {
	
	private static ImagenCaza imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenCaza() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_CAZA);
	}

	private ImagenCaza(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenCaza(){
		imagenPrincipal = new ImagenCaza();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenCaza nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenCaza();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_CAZA * 2 * ValoresDeNaves.cazaTamanio * escala);
		return new ImagenCaza(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}