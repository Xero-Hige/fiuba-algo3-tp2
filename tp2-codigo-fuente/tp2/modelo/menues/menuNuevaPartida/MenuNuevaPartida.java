package tp2.modelo.menues.menuNuevaPartida;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuNuevaPartida implements Posicionable {

	private int x;
	private int y;
	
	public MenuNuevaPartida() {
		this.x = ((500 / 2) - (234 / 2));
		this.y = 243;
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
