package tp2.modelo.menues.menuNuevaPartida;

import ar.uba.fi.algo3.titiritero.Dibujable;
import tp2.control.menues.menuNuevaPartida.ControlKeyPressMenuNuevaPartida;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuNuevaPartida.VistaMenuNuevaPartida;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuNuevaPartida extends Menu {

	public MenuNuevaPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
		
		// Creamos y mostramos la vista de creación de partida en proceso.
		this.setVistaMenu(new VistaMenuNuevaPartida());
		this.getVistaMenu().setPosicionable(this);
	}

	@Override
	public void resetear() {
		// TODO Auto-generated method stub
	}

	@Override
	public void activarControl() {
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuNuevaPartida());
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
	
	@Override
	public void mostrar() {
		this.getVentanaPrincipal().agregarObjetoDibujable((Dibujable) this.getVistaMenu());
		this.getVentanaPrincipal().agregarObjetosDibujables(this.getVistaMenu().getObjetosDibujables());
	}
}
