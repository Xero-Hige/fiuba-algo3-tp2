package tp2.modelo.menues.menuCreditos;

import tp2.control.menu.menuCreditos.ControlKeyPressMenuCreditos;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class MenuCreditos extends Menu implements MenuI, Posicionable {
	
	public MenuCreditos(VentanaPrincipal ventanaPrincipal){
		
		super(ventanaPrincipal, null);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuCreditos());
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
