package tp2.modelo.menues;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuPrincipal implements Posicionable  {

	private int alto;
	private int ancho;
	
	public MenuPrincipal(){
		this.alto = 500;
		this.ancho = 500;
	}
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}
	

}
