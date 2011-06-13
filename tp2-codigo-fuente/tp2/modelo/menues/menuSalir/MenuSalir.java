package tp2.modelo.menues.menuSalir;

import tp2.modelo.menues.Menu;


public class MenuSalir extends Menu {

	public MenuSalir() {
		super(null, null);
		System.exit(0);
	}
	
	@Override
	public void resetear() {}

	@Override
	public void activarControl() {}
}
