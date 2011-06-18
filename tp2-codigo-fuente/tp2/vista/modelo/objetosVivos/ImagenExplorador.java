package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenExplorador extends Imagen {
	
	private static ImagenExplorador imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenExplorador() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_EXPLORADOR);
	}

	private ImagenExplorador(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenExplorador(){
		imagenPrincipal = new ImagenExplorador();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenExplorador nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenExplorador();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_EXPLORADOR * 2 * ValoresDeNaves.exploradorTamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		return new ImagenExplorador(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}