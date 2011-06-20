package tp2.vista.modelo.mision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenBarraDeEstado extends Imagen {
	
	public static ImagenBarraDeEstado imagenPrincipal; 

	private ImagenBarraDeEstado() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/extras/barra-de-estado.png");
	}

	private ImagenBarraDeEstado(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenBarraDeEstado(){
		imagenPrincipal = new ImagenBarraDeEstado();
	}
	
	public static ImagenBarraDeEstado nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenBarraDeEstado();
		}
		return new ImagenBarraDeEstado(imagenPrincipal);
	}

}