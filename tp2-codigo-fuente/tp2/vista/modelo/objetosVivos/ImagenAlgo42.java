package tp2.vista.modelo.objetosVivos;

import java.awt.Image;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAlgo42 extends Imagen {
	
	private static Imagen imagenPrincipal;
	private static Imagen imagenEscalada;
	private static double escalaActual;

	private ImagenAlgo42() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/aeronaves/algo42.png");
	}

	private ImagenAlgo42(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAlgo42(){
		imagenPrincipal = new ImagenAlgo42();
		imagenEscalada = new Imagen(imagenPrincipal);
	}
	
	private static void escalarImagen(){
		int tamanioImagen = (int) (91.0 / 41 * 2 * ValoresDeNaves.algo42Tamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		Image imagen = imagenPrincipal.getImagen().getScaledInstance(tamanioImagen, tamanioImagen, Image.SCALE_SMOOTH);
		imagenEscalada.setImagen(imagen);
	}
	
	public static ImagenAlgo42 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAlgo42();
		}
		if(ProyeccionSobreSuperficieDeDibujo.getEscalaX() != escalaActual){
			escalaActual = ProyeccionSobreSuperficieDeDibujo.getEscalaX();
			escalarImagen();
		}
		return new ImagenAlgo42(imagenEscalada);
	}

}