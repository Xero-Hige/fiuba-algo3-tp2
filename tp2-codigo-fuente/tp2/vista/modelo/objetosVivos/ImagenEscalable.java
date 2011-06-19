package tp2.vista.modelo.objetosVivos;

import java.awt.Image;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenEscalable extends Imagen {
	
	private Imagen imagenEscalada;
	private double tamanioActual;

	public ImagenEscalable(Imagen imagen) {
		super(imagen);
		imagenEscalada = new Imagen(this);
	}
	
	private void escalarImagen(int tamanioImagen){
		Image imagen = this.getImagen().getScaledInstance(tamanioImagen, tamanioImagen, Image.SCALE_SMOOTH);
		imagenEscalada.setImagen(imagen);
	}
	
	public Imagen getImagenEscalada(int tamanioImagen){
		if(tamanioActual != tamanioImagen){
			tamanioActual = tamanioImagen;
			this.escalarImagen(tamanioImagen);
		}
		return imagenEscalada;
	}

}