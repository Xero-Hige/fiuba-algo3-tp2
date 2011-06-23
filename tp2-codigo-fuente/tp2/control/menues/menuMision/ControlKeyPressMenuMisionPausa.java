package tp2.control.menues.menuMision;

import java.awt.event.KeyEvent;

import tp2.modelo.menues.menuMision.MenuMisionPausa;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuMisionPausa implements KeyPressedObservador {

	private MenuMisionPausa menuMisionPausa;

	
	public ControlKeyPressMenuMisionPausa(MenuMisionPausa menuMisionPausa) {
		this.menuMisionPausa = menuMisionPausa;
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			// Se presiona flecha hacia abajo.
			case KeyEvent.VK_P:
				this.menuMisionPausa.ocultar();
				this.menuMisionPausa.getVentanaPrincipal().getControladorJuego().getPartida().reanudar();
				this.menuMisionPausa.getMenuPadre().activarControl();
				break;
		}	
	}
	
	public void keyRelease(KeyEvent event) {}
}