package tp2.vista.menues.menuCargarPartida;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenFondoCargarPartida extends Imagen {
	
	public static ImagenFondoCargarPartida imagenPrincipal; 

	private ImagenFondoCargarPartida() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-cargar-fondo.jpg");
	}

	private ImagenFondoCargarPartida(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenFondoCargarPartida();
	}
	
	public static ImagenFondoCargarPartida nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenFondoCargarPartida(imagenPrincipal);
	}
}
