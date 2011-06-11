package tp2.control.menu;

import java.awt.event.KeyEvent;

import tp2.vista.menues.VistaMenuPrincipal;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuPrincipal implements KeyPressedObservador {

	private VistaMenuPrincipal vistaMenuPrincipal;
	
	public ControlKeyPressMenuPrincipal(VistaMenuPrincipal vistaMenuPrincipal) {
		this.vistaMenuPrincipal = vistaMenuPrincipal;
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			case KeyEvent.VK_DOWN:
				/* LINEA DE DEBUG */
				System.out.println("Abajo");
				/* ******************************************** */
				this.vistaMenuPrincipal.moverSeleccionParaAbajo();
				break;
				
			case KeyEvent.VK_UP:
				/* LINEA DE DEBUG */
				System.out.println("Arriba");
				/* ******************************************** */
				this.vistaMenuPrincipal.moverSeleccionParaArriba();
				break;
				
			case KeyEvent.VK_ENTER:
				/* LINEA DE DEBUG */
				System.out.println("Enter");
				/* ******************************************** */
				this.vistaMenuPrincipal.seleccionarItem();
				break;
		}	
	}
	
	public void keyRelease(KeyEvent event) {}
}
