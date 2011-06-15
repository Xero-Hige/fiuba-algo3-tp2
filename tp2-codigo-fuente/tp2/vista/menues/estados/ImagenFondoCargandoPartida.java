package tp2.vista.menues.estados;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenFondoCargandoPartida extends Imagen {
	
	public static ImagenFondoCargandoPartida imagenPrincipal; 

	private ImagenFondoCargandoPartida() {
		this.setNombreArchivoImagen("../../imagenes/extras/cargando-partida-fondo.jpg");
	}

	private ImagenFondoCargandoPartida(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenFondoCargandoPartida(){
		imagenPrincipal = new ImagenFondoCargandoPartida();
	}
	
	public static ImagenFondoCargandoPartida nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenFondoCargandoPartida();
		}
		return new ImagenFondoCargandoPartida(imagenPrincipal);
	}

}