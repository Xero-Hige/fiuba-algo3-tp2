package tp2.vista.modelo.extras;

import ar.uba.fi.algo3.titiritero.vista.ImagenAnimada;

public class ImagenExplosion extends ImagenAnimada {
	
	public static ImagenExplosion imagenPrincipal; 

	private ImagenExplosion() {
		super(false);
		this.setImagenes("../../imagenes/modelo/explosion/explosion", "png", 17);
	}

	private ImagenExplosion(ImagenAnimada imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenExplosion();
	}
	
	public static ImagenExplosion nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenExplosion(imagenPrincipal);
	}
}
