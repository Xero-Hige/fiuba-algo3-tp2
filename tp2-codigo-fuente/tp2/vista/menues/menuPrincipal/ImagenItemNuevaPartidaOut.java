package tp2.vista.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class ImagenItemNuevaPartidaOut extends Imagen {
	
	public static ImagenItemNuevaPartidaOut imagenPrincipal; 

	private ImagenItemNuevaPartidaOut() {
		this.setNombreArchivoImagen("/tp2/vista/imagenes/menues/menu-principal-item-out-nueva-partida.png");
	}

	private ImagenItemNuevaPartidaOut(Imagen imagen) {
		super(imagen);
	}
	
	private static void crearImagenPrincipal(){
		imagenPrincipal = new ImagenItemNuevaPartidaOut();
	}
	
	public static ImagenItemNuevaPartidaOut nuevaImagen(){
		if(imagenPrincipal == null){
			crearImagenPrincipal();
		}
		return new ImagenItemNuevaPartidaOut(imagenPrincipal);
	}
}