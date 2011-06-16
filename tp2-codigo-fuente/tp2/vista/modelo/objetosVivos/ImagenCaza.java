package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenCaza extends Imagen {
	
	public static ImagenCaza imagenPrincipal; 

	private ImagenCaza() {
		this.setNombreArchivoImagen("../../imagenes/modelo/aeronaves/Caza.png");
	}

	private ImagenCaza(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenCaza(){
		imagenPrincipal = new ImagenCaza();
	}
	
	public static ImagenCaza nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenCaza();
		}
		return new ImagenCaza(imagenPrincipal);
	}

}