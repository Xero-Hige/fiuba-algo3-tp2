package tp2.modelo.menues.menuCreditos;

import tp2.control.menu.menuCreditos.ControlKeyPressMenuCreditos;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuCreditos.VistaMenuCreditos;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuCreditos extends Menu {
	
	public MenuCreditos(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		
		super(ventanaPrincipal, menuPadre);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuCreditos());
		this.getVistaMenu().setPosicionable(this);
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {

		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuCreditos(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}
