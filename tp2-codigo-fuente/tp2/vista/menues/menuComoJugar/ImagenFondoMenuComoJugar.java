package tp2.vista.menues.menuComoJugar;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenFondoMenuComoJugar extends Imagen {
	
	public static ImagenFondoMenuComoJugar imagenPrincipal; 

	private ImagenFondoMenuComoJugar() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/como-jugar-fondo.jpg");
	}

	private ImagenFondoMenuComoJugar(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenFondoMenuComoJugar();
	}
	
	public static ImagenFondoMenuComoJugar nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenFondoMenuComoJugar(imagenPrincipal);
	}

}
