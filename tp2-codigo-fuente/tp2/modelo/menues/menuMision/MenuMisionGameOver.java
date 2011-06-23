package tp2.modelo.menues.menuMision;

import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuMision.VistaMenuMisionGameOver;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuMisionGameOver extends Menu {
	
	public MenuMisionGameOver(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		
		super(ventanaPrincipal, menuPadre);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuMisionGameOver());
		this.getVistaMenu().setPosicionable(this);
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {}
}