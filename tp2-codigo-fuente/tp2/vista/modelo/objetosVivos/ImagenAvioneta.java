package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenAvioneta extends Imagen {
	
	public static ImagenAvioneta imagenPrincipal; 

	private ImagenAvioneta() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/modelo/aeronaves/avioneta.png");
	}

	private ImagenAvioneta(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenAvioneta(){
		imagenPrincipal = new ImagenAvioneta();
	}
	
	public static ImagenAvioneta nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenAvioneta();
		}
		return new ImagenAvioneta(imagenPrincipal);
	}

}