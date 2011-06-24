package tp2.modelo.menues.menuMision;

import tp2.control.ControladorJuegoAlgo42;
import tp2.control.menues.menuMision.ControlKeyPressMenuMisionGameOver;
import tp2.modelo.menues.Menu;
import tp2.vista.menues.menuMision.VistaMenuMisionGameOverJuegoGanado;
import tp2.vista.menues.menuMision.VistaMenuMisionGameOverJuegoPerdido;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuMisionGameOver extends Menu {
	
	
	public MenuMisionGameOver(VentanaPrincipal ventanaPrincipal, ControladorJuegoAlgo42 controladorJuegoAlgo42, boolean juegoGanado){
		
		super(ventanaPrincipal, null);
		
		if (juegoGanado) {
			// Creamos la vista para el caso en que se gana el juego
			this.setVistaMenu(new VistaMenuMisionGameOverJuegoGanado());
			this.getVistaMenu().setPosicionable(this);
		}
		else {
			// Creamos la vista para el caso en que se pierde el juego
			this.setVistaMenu(new VistaMenuMisionGameOverJuegoPerdido());
			this.getVistaMenu().setPosicionable(this);
		}
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {
		
		this.setControlKeyPress(new ControlKeyPressMenuMisionGameOver(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());		
	}
	
	@Override
	public void realizarAlOcultar() {}

	@Override
	public void realizarAlMostrar() {}
}