package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemComoJugarOut extends Imagen {
	
	public static ImagenItemComoJugarOut imagenPrincipal; 

	private ImagenItemComoJugarOut() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-item-out-como-jugar.png");
	}

	private ImagenItemComoJugarOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemComoJugarOut();
	}
	
	public static ImagenItemComoJugarOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemComoJugarOut(imagenPrincipal);
	}
}
