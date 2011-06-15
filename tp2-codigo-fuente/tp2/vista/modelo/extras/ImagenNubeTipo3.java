package tp2.vista.modelo.extras;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenNubeTipo3 extends Imagen {
	
	public static ImagenNubeTipo3 imagenPrincipal; 

	private ImagenNubeTipo3() {
		this.setNombreArchivoImagen("../../imagenes/modelo/nubes/nube3.png");
	}

	private ImagenNubeTipo3(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenNubeTipo3(){
		imagenPrincipal = new ImagenNubeTipo3();
	}
	
	public static ImagenNubeTipo3 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenNubeTipo3();
		}
		return new ImagenNubeTipo3(imagenPrincipal);
	}

}