package tp2.modelo.menues.menuPrincipal;

import java.util.Iterator;

import tp2.control.menu.menuPrincipal.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuPrincipal extends Menu  {
	
		
	public MenuPrincipal(VentanaPrincipal ventanaPrincipal){
		
		super(ventanaPrincipal, null);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuPrincipal());
		this.getVistaMenu().setPosicionable(this);
		
		// Creamos los items de las opciones del menu principal
		this.agregarItem(new MenuPrincipalItemNuevaPartida(this.getVentanaPrincipal(), this));
		this.agregarItem(new MenuPrincipalItemCargarPartida(this.getVentanaPrincipal(), this));
		this.agregarItem(new MenuPrincipalItemCreditos(this.getVentanaPrincipal(), this));
		this.agregarItem(new MenuPrincipalItemSalir(this.getVentanaPrincipal(), this));
				
		// Creamos los los menues hijos del menu principal.
//		this.agregarMenuHijo("Nueva partida", (MenuI) new MenuNuevaPartida());
//		this.agregarMenuHijo("Cargar partida", (MenuI) new MenuCargarPartida());
//		this.agregarMenuHijo("Creditos", (MenuI) new MenuCreditos(this.getVentanaPrincipal()));
//		this.agregarMenuHijo("Salir", (MenuI) new MenuSalir());
	}
	
	public void resetear() {
		
		Iterator<MenuItem> i = this.getListaDeItems().iterator();
		boolean seleccionoPrimerItem = false;
		
		while (i.hasNext()) {
			
			if (!seleccionoPrimerItem)
			{
				i.next().getVistaMenuItem().itemOver();
				seleccionoPrimerItem = true;
				continue;
			}
			i.next().getVistaMenuItem().itemOut();
		}
	}
	
	@Override
	public void activarControl() {
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuPrincipal(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}
