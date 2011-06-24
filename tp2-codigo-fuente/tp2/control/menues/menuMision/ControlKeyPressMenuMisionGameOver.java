package tp2.control.menues.menuMision;

import java.awt.event.KeyEvent;
import tp2.modelo.menues.menuMision.MenuMisionGameOver;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuMisionGameOver implements KeyPressedObservador  {
	
	private MenuMisionGameOver menuMisionGameOver;
	
	public ControlKeyPressMenuMisionGameOver(MenuMisionGameOver menuMisionGameOver) {
		this.menuMisionGameOver = menuMisionGameOver;
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
						
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				MenuPrincipal menuPrincipal = new MenuPrincipal(this.menuMisionGameOver.getVentanaPrincipal());
				menuPrincipal.mostrar();
				menuPrincipal.activarControl();
				menuPrincipal.getAudio().play();
				this.menuMisionGameOver.ocultar();				
				break;
		}	
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
