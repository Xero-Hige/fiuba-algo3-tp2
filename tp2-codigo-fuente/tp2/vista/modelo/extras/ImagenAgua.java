package tp2.vista.modelo.extras;

import ar.uba.fi.algo3.titiritero.vista.ImagenAnimada;

public class ImagenAgua extends ImagenAnimada {
	
	public static ImagenAgua imagenPrincipal; 

	private ImagenAgua() {
		super(true);
		this.setImagenes("../../imagenes/modelo/agua/agua", "png", 90);
	}

	private ImagenAgua(ImagenAnimada imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenAgua();
	}
	
	public static ImagenAgua nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenAgua(imagenPrincipal);
	}
}
