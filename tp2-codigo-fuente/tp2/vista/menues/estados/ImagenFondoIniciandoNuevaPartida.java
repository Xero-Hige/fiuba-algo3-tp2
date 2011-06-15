package tp2.vista.menues.estados;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenFondoIniciandoNuevaPartida extends Imagen {
	
	public static ImagenFondoIniciandoNuevaPartida imagenPrincipal; 

	private ImagenFondoIniciandoNuevaPartida() {
		this.setNombreArchivoImagen("../../imagenes/extras/iniciando-nueva-partida-fondo.jpg");
	}

	private ImagenFondoIniciandoNuevaPartida(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenFondoIniciandoNuevaPartida(){
		imagenPrincipal = new ImagenFondoIniciandoNuevaPartida();
	}
	
	public static ImagenFondoIniciandoNuevaPartida nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenFondoIniciandoNuevaPartida();
		}
		return new ImagenFondoIniciandoNuevaPartida(imagenPrincipal);
	}

}