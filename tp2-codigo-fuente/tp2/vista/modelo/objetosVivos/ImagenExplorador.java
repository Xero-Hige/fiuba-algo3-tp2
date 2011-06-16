package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class ImagenExplorador extends Imagen {
	
	public static ImagenExplorador imagenPrincipal; 

	private ImagenExplorador() {
		this.setNombreArchivoImagen("../../imagenes/modelo/aeronaves/explorador.png");
	}

	private ImagenExplorador(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenExplorador(){
		imagenPrincipal = new ImagenExplorador();
	}
	
	public static ImagenExplorador nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenExplorador();
		}
		return new ImagenExplorador(imagenPrincipal);
	}

}