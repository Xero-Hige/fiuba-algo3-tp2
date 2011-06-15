package tp2.vista.menues.estados;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenJuegoPausado extends Imagen {
	
	public static ImagenJuegoPausado imagenPrincipal; 

	private ImagenJuegoPausado() {
		this.setNombreArchivoImagen("../../imagenes/extras/juego-pausado.png");
	}

	private ImagenJuegoPausado(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenJuegoPausado(){
		imagenPrincipal = new ImagenJuegoPausado();
	}
	
	public static ImagenJuegoPausado nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenJuegoPausado();
		}
		return new ImagenJuegoPausado(imagenPrincipal);
	}

}