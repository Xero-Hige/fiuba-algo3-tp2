package tp2.control.menues.menuMision;

import java.awt.event.KeyEvent;

import tp2.control.ControladorDelJugador;
import tp2.modelo.NaveMilitarControlada;
import tp2.modelo.menues.menuMision.MenuMision;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuMision implements KeyPressedObservador {

	private ControladorDelJugador controladorDelJugador;

	public ControlKeyPressMenuMision(MenuMision menuMision) {
		NaveMilitarControlada naveDelJugador = menuMision.getVentanaPrincipal().getControladorJuego().getPartida().getMisionActual().getNaveDelJugador();
		this.controladorDelJugador = new ControladorDelJugador(naveDelJugador);
	}

	@Override
	public void keyPressed(KeyEvent event) {
		this.controladorDelJugador.recibirTeclaPresionada(event);
		switch(event.getKeyCode()) {
			case KeyEvent.VK_P:
				System.out.println("Se pone pausa");
		}
	}

	@Override
	public void keyRelease(KeyEvent event) {
		this.controladorDelJugador.recibirTeclaSoltada(event);
		switch(event.getKeyCode()) {
			
		}
	}

}
