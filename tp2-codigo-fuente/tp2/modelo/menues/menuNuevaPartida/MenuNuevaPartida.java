package tp2.modelo.menues.menuNuevaPartida;

import tp2.control.menues.menuNuevaPartida.ControlKeyPressMenuNuevaPartida;
import tp2.modelo.Partida;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.menuMision.MenuMision;
import tp2.vista.menues.menuNuevaPartida.VistaMenuNuevaPartida;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;


public class MenuNuevaPartida extends Menu {

	public MenuNuevaPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
		
		// Creamos y mostramos la vista de creación de partida en proceso.
		VistaMenuNuevaPartida vistaIniciandoPartida = new VistaMenuNuevaPartida();
		
		this.setVistaMenu(vistaIniciandoPartida);
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
		
		// Mostramos pantalla de cargando nueva partida
		this.getVentanaPrincipal().agregarObjetoDibujable((Dibujable) this.getVistaMenu());
		this.getVentanaPrincipal().agregarObjetosDibujables(this.getVistaMenu().getObjetosDibujables());

		// Cargamos la nueva partida
		this.iniciarNuevaPartida();
		
		// Removemos la pantalla de cargando nueva partida
		this.getVentanaPrincipal().removerObjetoDibujable((Dibujable) this.getVistaMenu());
		this.getVentanaPrincipal().removerObjetosDibujables(this.getVistaMenu().getObjetosDibujables());
		
		MenuMision menuMision = new MenuMision(this.getVentanaPrincipal(), this);
		menuMision.mostrar();
		menuMision.activarControl();
	}
	
	public void iniciarNuevaPartida() {
		
		Partida partida = new Partida(3, 3);
		partida.iniciar();
		this.getVentanaPrincipal().getControladorJuego().iniciarJuego(partida);

	}
}
