package tp2.modelo.menues.menuMision;

import tp2.vista.ventanas.DimensionesDeVentana;
import ar.uba.fi.algo3.titiritero.Posicionable;


public class BarraDeEstado implements Posicionable {

	private int x;
	private int y;
	
	public BarraDeEstado() {
		this.x = DimensionesDeVentana.centroX;
		this.y = 15;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}

