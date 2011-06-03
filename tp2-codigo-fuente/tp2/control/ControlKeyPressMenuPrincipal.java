package tp2.control;

import java.awt.event.KeyEvent;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuPrincipal implements KeyPressedObservador {

	@SuppressWarnings("unused")
	private ControladorJuego controladorJuego;
	
	public ControlKeyPressMenuPrincipal(ControladorJuego unControladorJuego) {
		this.controladorJuego = unControladorJuego;
	}
	
	public void keyPressed(KeyEvent event) {
		if (event.getKeyCode()==KeyEvent.VK_ENTER) {
			
			/* LINEA DE DEBUG */
			System.out.println("Se inicia el juego...");
			/* ******************************************** */
			
			//this.controladorJuego.removerKeyPressObservador(this);
			//this.controladorJuego.agregarKeyPressObservador(new ControlKeyPressMenu1(this.controladorJuego));
		}	
	}
	
	public void keyRelease(KeyEvent event) {}
}
