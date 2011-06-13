package tp2.modelo.menues.menuCreditos;

import tp2.control.menu.menuCreditos.ControlKeyPressMenuCreditos;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuCreditos.VistaMenuCreditos;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuCreditos extends Menu implements MenuI{
	
	public MenuCreditos(VentanaPrincipal ventanaPrincipal){
		
		super(ventanaPrincipal, null);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuCreditos());
		this.getVistaMenu().setPosicionable(this);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuCreditos());
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
		this.getVentanaPrincipal().activarKeyPressObservador();
	}
}
