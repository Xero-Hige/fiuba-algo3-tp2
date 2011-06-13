package tp2.modelo.menues.menuPrincipal;

import tp2.control.menu.menuPrincipal.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuPrincipal extends Menu implements MenuI, Posicionable  {
	
		
	public MenuPrincipal(VentanaPrincipal ventanaPrincipal){
		
		super(ventanaPrincipal, null);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuPrincipal(this, this.getVistaMenu().getItemsDelMenu()));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
		this.getVentanaPrincipal().activarKeyPressObservador();
	}
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	
}
