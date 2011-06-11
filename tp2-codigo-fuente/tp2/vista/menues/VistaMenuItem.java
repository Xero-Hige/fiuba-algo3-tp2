package tp2.vista.menues;

import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuItem extends Imagen {

	private Imagen imagenOut;
	private Imagen imagenOver;
	
	public VistaMenuItem(Imagen imagenOut, Imagen imagenOver) {
		this.imagenOut = imagenOut;
		this.imagenOver = imagenOver;
	}
	
	public VistaMenuItem(Imagen imagen) {
		this.imagenOut = imagen;
		this.imagenOver = imagen;
	}
	
	public void inicializarModelo () {
		
	}
	
	public void setItemOver() {
		
	}
	
	public void setItemOut() {
		
	}
	
}
