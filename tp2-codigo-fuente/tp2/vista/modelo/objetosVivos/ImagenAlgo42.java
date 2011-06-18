package tp2.vista.modelo.objetosVivos;

import java.awt.Image;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAlgo42 extends Imagen {
	
	public static ImagenAlgo42 imagenPrincipal;
	public static ImagenAlgo42 imagenEscalada;

	private ImagenAlgo42() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/aeronaves/algo42.png");
	}

	private ImagenAlgo42(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAlgo42(){
		imagenPrincipal = new ImagenAlgo42();
		imagenEscalada = new ImagenAlgo42(imagenPrincipal);
	}
	
	public static ImagenAlgo42 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAlgo42();
		}
		int tamanioImagen = (int) (91.0 / 41 * ValoresDeNaves.algo42Tamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		Image imagen = imagenPrincipal.getImagen().getScaledInstance(tamanioImagen, tamanioImagen, Image.SCALE_SMOOTH);
		imagenEscalada.setImagen(imagen);
		return new ImagenAlgo42(imagenEscalada);
	}

}