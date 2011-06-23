package tp2.modelo.menues.menuMision;

import tp2.control.menues.menuMision.ControlKeyPressMenuMisionOpciones;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuMision.VistaMenuMisionOpciones;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuMisionOpciones extends Menu {
	
	public MenuMisionOpciones(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		
		super(ventanaPrincipal, menuPadre);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuMisionOpciones());
		this.getVistaMenu().setPosicionable(this);
		
		// Creamos los items de las opciones del menu principal
		this.agregarItem(new MenuMisionOpcionesItemReanudar(this.getVentanaPrincipal(), this));
		this.agregarItem(new MenuMisionOpcionesItemGuardarPartida(this.getVentanaPrincipal(), this));
		this.agregarItem(new MenuMisionOpcionesItemSalir(this.getVentanaPrincipal(), this));
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {

		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuMisionOpciones(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}