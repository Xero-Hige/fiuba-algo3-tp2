package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenFondoMenuMisionOpciones extends Imagen {
	
	public static ImagenFondoMenuMisionOpciones imagenPrincipal; 

	private ImagenFondoMenuMisionOpciones() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones.png");
	}

	private ImagenFondoMenuMisionOpciones(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenFondoMenuMisionOpciones(){
		imagenPrincipal = new ImagenFondoMenuMisionOpciones();
	}
	
	public static ImagenFondoMenuMisionOpciones nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenFondoMenuMisionOpciones();
		}
		return new ImagenFondoMenuMisionOpciones(imagenPrincipal);
	}

}