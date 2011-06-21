package tp2.vista.modelo.objetosVivos;

import tp2.modelo.especificaciones.ValoresDeBonos;
import tp2.vista.modelo.ArchivosDeImagenes;
import tp2.vista.modelo.FactoresDeImagenes;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenBonoDeEnergia extends Imagen {
	
	private static ImagenBonoDeEnergia imagenPrincipal;
	private static ImagenEscalable imagenEscalable;

	private ImagenBonoDeEnergia () {
		this.setNombreArchivoImagen(ArchivosDeImagenes.IMAGEN_BONO_ENERGIA);
	}

	private ImagenBonoDeEnergia (Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenBonoDeEnergia(){
		imagenPrincipal = new ImagenBonoDeEnergia ();
		imagenEscalable = new ImagenEscalable(imagenPrincipal);
	}
	
	public static ImagenBonoDeEnergia  nuevaImagen(double escala){
		if(imagenPrincipal == null){
			crearImagenBonoDeEnergia();
		}
		int tamanioImagen = (int) (FactoresDeImagenes.FACTOR_BONO_ENERGIA * 2 * ValoresDeBonos.bonoDeEnergiaTamanio * escala);
		return new ImagenBonoDeEnergia (imagenEscalable.getImagenEscalada(tamanioImagen));
	}

}