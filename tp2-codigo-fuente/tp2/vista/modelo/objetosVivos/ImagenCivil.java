package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenCivil extends Imagen {
	
	public static ImagenCivil imagenPrincipal; 

	private ImagenCivil() {
		this.setNombreArchivoImagen("../../imagenes/modelo/aeronaves/civil.png");
	}

	private ImagenCivil(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenCivil(){
		imagenPrincipal = new ImagenCivil();
	}
	
	public static ImagenCivil nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenCivil();
		}
		return new ImagenCivil(imagenPrincipal);
	}

}