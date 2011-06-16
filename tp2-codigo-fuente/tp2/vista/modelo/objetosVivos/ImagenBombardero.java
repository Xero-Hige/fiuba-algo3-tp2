package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenBombardero extends Imagen {
	
	public static ImagenBombardero imagenPrincipal; 

	private ImagenBombardero() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/aeronaves/bombardero.png");
	}

	private ImagenBombardero(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenBombardero(){
		imagenPrincipal = new ImagenBombardero();
	}
	
	public static ImagenBombardero nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenBombardero();
		}
		return new ImagenBombardero(imagenPrincipal);
	}

}