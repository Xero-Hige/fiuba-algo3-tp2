package tp2.vista.modelo.extras;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenNubeTipo2 extends Imagen {
	
	public static ImagenNubeTipo2 imagenPrincipal; 

	private ImagenNubeTipo2() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/nubes/nube2.png");
	}

	private ImagenNubeTipo2(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenNubeTipo2(){
		imagenPrincipal = new ImagenNubeTipo2();
	}
	
	public static ImagenNubeTipo2 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenNubeTipo2();
		}
		return new ImagenNubeTipo2(imagenPrincipal);
	}

}