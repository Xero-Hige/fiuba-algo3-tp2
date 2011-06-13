package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuPrincipalItemSalir implements Posicionable {

	private int x;
	private int y;
	
	public MenuPrincipalItemSalir() {
		this.x = ((500 / 2) - (234 / 2));
		this.y = 363;
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
