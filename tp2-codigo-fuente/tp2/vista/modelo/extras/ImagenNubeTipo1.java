package tp2.vista.modelo.extras;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenNubeTipo1 extends Imagen {
	
	public static ImagenNubeTipo1 imagenPrincipal; 

	private ImagenNubeTipo1() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/nubes/nube1.png");
	}

	private ImagenNubeTipo1(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenNubeTipo1(){
		imagenPrincipal = new ImagenNubeTipo1();
	}
	
	public static ImagenNubeTipo1 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenNubeTipo1();
		}
		return new ImagenNubeTipo1(imagenPrincipal);
	}

}