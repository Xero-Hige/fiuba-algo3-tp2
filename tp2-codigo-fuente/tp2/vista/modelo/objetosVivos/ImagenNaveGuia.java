package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenNaveGuia extends Imagen {
	
	private static ImagenNaveGuia imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenNaveGuia() {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_NAVE_GUIA);
	}

	private ImagenNaveGuia(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenNaveGuia(){
		imagenPrincipal = new ImagenNaveGuia();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenNaveGuia nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenNaveGuia();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_NAVE_GUIA * 2 * ValoresDeNaves.guiaEnemigoTamanio * escala);
		return new ImagenNaveGuia(imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}