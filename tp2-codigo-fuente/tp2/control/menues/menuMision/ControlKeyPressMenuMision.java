package tp2.control.menues.menuMision;

import java.awt.event.KeyEvent;

import tp2.control.ControladorDelJugador;
import tp2.modelo.NaveMilitarControlada;
import tp2.modelo.menues.menuMision.MenuMision;
import tp2.modelo.menues.menuMision.MenuMisionOpciones;
import tp2.modelo.menues.menuMision.MenuMisionPausa;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;


public class ControlKeyPressMenuMision implements KeyPressedObservador {

	private MenuMision menuMision;
	private ControladorDelJugador controladorDelJugador;

	public ControlKeyPressMenuMision(MenuMision menuMision) {
		this.menuMision = menuMision;
		NaveMilitarControlada naveDelJugador = menuMision.getVentanaPrincipal().getControladorJuego().getPartida().getMisionActual().getNaveDelJugador();
		this.controladorDelJugador = new ControladorDelJugador(naveDelJugador);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		
		this.controladorDelJugador.recibirTeclaPresionada(event);
		
		switch(event.getKeyCode()) {
		
			case KeyEvent.VK_ENTER:
				this.menuMision.getVentanaPrincipal().getControladorJuego().getPartida().detener();
				MenuMisionOpciones menuMisionOpciones = new MenuMisionOpciones(this.menuMision.getVentanaPrincipal(), this.menuMision);
				menuMisionOpciones.mostrar();
				break;
			
			case KeyEvent.VK_P:
				this.menuMision.getVentanaPrincipal().getControladorJuego().getPartida().detener();
				MenuMisionPausa menuMisionPausa = new MenuMisionPausa(this.menuMision.getVentanaPrincipal(), this.menuMision);
				menuMisionPausa.mostrar();
				break;
		}
	}

	@Override
	public void keyRelease(KeyEvent event) {
		this.controladorDelJugador.recibirTeclaSoltada(event);
		switch(event.getKeyCode()) {
			
		}
	}

}
