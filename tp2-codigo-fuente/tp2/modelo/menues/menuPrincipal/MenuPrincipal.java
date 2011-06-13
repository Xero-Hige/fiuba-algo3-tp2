package tp2.modelo.menues.menuPrincipal;

import tp2.control.menu.menuPrincipal.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.Menu;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuPrincipal extends Menu  {
	
		
	public MenuPrincipal(VentanaPrincipal ventanaPrincipal){
		
		super(ventanaPrincipal, null);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);
		
		// Creamos los items de las opciones del menu principal
		this.agregarItem(new MenuPrincipalItemNuevaPartida(this.getVentanaPrincipal()));
		this.agregarItem(new MenuPrincipalItemCargarPartida(this.getVentanaPrincipal()));
		this.agregarItem(new MenuPrincipalItemCreditos(this.getVentanaPrincipal()));
		this.agregarItem(new MenuPrincipalItemSalir(this.getVentanaPrincipal()));
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuPrincipal(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
		this.getVentanaPrincipal().activarKeyPressObservador();
				
		// Creamos los los menues hijos del menu principal.
//		this.agregarMenuHijo("Nueva partida", (MenuI) new MenuNuevaPartida());
//		this.agregarMenuHijo("Cargar partida", (MenuI) new MenuCargarPartida());
//		this.agregarMenuHijo("Creditos", (MenuI) new MenuCreditos(this.getVentanaPrincipal()));
//		this.agregarMenuHijo("Salir", (MenuI) new MenuSalir());
	}
}
