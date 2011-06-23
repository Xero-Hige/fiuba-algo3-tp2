package tp2.vista.menues.menuMision;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemSalirOut extends Imagen {
	
	public static ImagenItemSalirOut imagenPrincipal; 

	private ImagenItemSalirOut() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-mision-opciones-item-out-salir.png");
	}

	private ImagenItemSalirOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemSalirOut();
	}
	
	public static ImagenItemSalirOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemSalirOut(imagenPrincipal);
	}
}