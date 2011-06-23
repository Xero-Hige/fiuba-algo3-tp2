package tp2.modelo.menues.menuMision;

import tp2.control.menues.menuMision.ControlKeyPressMenuMisionPausa;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuMision.VistaMenuMisionPausa;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuMisionPausa extends Menu {
	
	public MenuMisionPausa(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		
		super(ventanaPrincipal, menuPadre);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuMisionPausa());
		this.getVistaMenu().setPosicionable(this);
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {

		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuMisionPausa(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}