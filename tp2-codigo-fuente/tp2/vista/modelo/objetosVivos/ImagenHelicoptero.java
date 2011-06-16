package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenHelicoptero extends Imagen {
	
	public static ImagenHelicoptero imagenPrincipal; 

	private ImagenHelicoptero() {
		this.setNombreArchivoImagen("../../imagenes/modelo/aeronaves/helicoptero.png");
	}

	private ImagenHelicoptero(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenHelicoptero(){
		imagenPrincipal = new ImagenHelicoptero();
	}
	
	public static ImagenHelicoptero nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenHelicoptero();
		}
		return new ImagenHelicoptero(imagenPrincipal);
	}
}