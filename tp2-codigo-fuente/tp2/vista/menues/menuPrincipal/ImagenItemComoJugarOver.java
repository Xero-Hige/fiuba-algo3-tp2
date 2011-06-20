package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemComoJugarOver extends Imagen {
	
	public static ImagenItemComoJugarOver imagenPrincipal; 

	private ImagenItemComoJugarOver() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-item-over-como-jugar.png");
	}

	private ImagenItemComoJugarOver(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemComoJugarOver();
	}
	
	public static ImagenItemComoJugarOver nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemComoJugarOver(imagenPrincipal);
	}
}
