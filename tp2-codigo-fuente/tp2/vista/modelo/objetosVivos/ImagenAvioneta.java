package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAvioneta extends Imagen {
	
	private static ImagenAvioneta imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenAvioneta() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_AVIONETA);
	}

	private ImagenAvioneta(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAvioneta(){
		imagenPrincipal = new ImagenAvioneta();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenAvioneta nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAvioneta();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_AVIONETA * 2 * ValoresDeNaves.avionetaTamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		return new ImagenAvioneta(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}