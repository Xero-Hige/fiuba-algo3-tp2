package tp2.control.menu.menuCreditos;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuCreditos implements KeyPressedObservador  {

	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
						
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				break;
		}	
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
