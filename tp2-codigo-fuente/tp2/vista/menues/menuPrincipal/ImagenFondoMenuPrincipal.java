package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenFondoMenuPrincipal extends Imagen {
	
	public static ImagenFondoMenuPrincipal imagenPrincipal; 

	private ImagenFondoMenuPrincipal() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-fondo.jpg");
	}

	private ImagenFondoMenuPrincipal(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenFondoMenuPrincipal();
	}
	
	public static ImagenFondoMenuPrincipal nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenFondoMenuPrincipal(imagenPrincipal);
	}
}
