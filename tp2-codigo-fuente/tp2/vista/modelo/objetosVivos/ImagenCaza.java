package tp2.vista.modelo.objetosVivos;

import java.awt.Image;

import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenCaza extends Imagen {
	
	public static Imagen imagenPrincipal;
	private static Imagen imagenEscalada; 
	private static double escalaActual;

	private ImagenCaza() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/aeronaves/Caza.png");
	}

	private ImagenCaza(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenCaza(){
		imagenPrincipal = new ImagenCaza();
		imagenEscalada = new Imagen(imagenPrincipal);
	}
	
	private static void escalarImagen(){
		int tamanioImagen = (int) (91.0 / 41 * 2 * ValoresDeNaves.cazaTamanio * ProyeccionSobreSuperficieDeDibujo.getEscalaX());
		Image imagen = imagenPrincipal.getImagen().getScaledInstance(tamanioImagen, tamanioImagen, Image.SCALE_SMOOTH);
		imagenEscalada.setImagen(imagen);
	}
	
	public static ImagenCaza nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenCaza();
		}
		if(ProyeccionSobreSuperficieDeDibujo.getEscalaX() != escalaActual){
			escalaActual = ProyeccionSobreSuperficieDeDibujo.getEscalaX();
			escalarImagen();
		}
		return new ImagenCaza(imagenEscalada);
	}

}