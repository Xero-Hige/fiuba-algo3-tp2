package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAlgo42 extends Imagen {
	
	public static ImagenAlgo42 imagenPrincipal; 

	private ImagenAlgo42() {
		this.setNombreArchivoImagen("../../imagenes/modelo/aeronaves/algo42.png");
	}

	private ImagenAlgo42(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAlgo42(){
		imagenPrincipal = new ImagenAlgo42();
	}
	
	public static ImagenAlgo42 nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAlgo42();
		}
		return new ImagenAlgo42(imagenPrincipal);
	}

}