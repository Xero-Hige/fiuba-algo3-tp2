package tp2.vista.menues.estados;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenFondoGuardandoPartida extends Imagen {
	
	public static ImagenFondoGuardandoPartida imagenPrincipal; 

	private ImagenFondoGuardandoPartida() {
		this.setNombreArchivoImagen("../../imagenes/extras/guardando-partida-fondo.jpg");
	}

	private ImagenFondoGuardandoPartida(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenFondoGuardandoPartida(){
		imagenPrincipal = new ImagenFondoGuardandoPartida();
	}
	
	public static ImagenFondoGuardandoPartida nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenFondoGuardandoPartida();
		}
		return new ImagenFondoGuardandoPartida(imagenPrincipal);
	}

}