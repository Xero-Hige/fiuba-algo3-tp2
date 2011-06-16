package tp2.vista.menues.menuCreditos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenFondoMenuCreditos extends Imagen {
	
	public static ImagenFondoMenuCreditos imagenPrincipal; 

	private ImagenFondoMenuCreditos() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/creditos-fondo.jpg");
	}

	private ImagenFondoMenuCreditos(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenFondoMenuCreditos();
	}
	
	public static ImagenFondoMenuCreditos nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenFondoMenuCreditos(imagenPrincipal);
	}

}
