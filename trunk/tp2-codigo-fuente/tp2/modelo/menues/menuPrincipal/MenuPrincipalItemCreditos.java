package tp2.modelo.menues.menuPrincipal;

import tp2.modelo.menues.MenuItemI;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuPrincipalItemCreditos implements MenuItemI, Posicionable {

	private int x;
	private int y;
	
	public MenuPrincipalItemCreditos() {
		this.x = ((500 / 2) - (234 / 2));
		this.y = 323;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void seleccionar() {
		// TODO Auto-generated method stub
	}
}
