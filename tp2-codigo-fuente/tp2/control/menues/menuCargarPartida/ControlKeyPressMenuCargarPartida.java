package tp2.control.menues.menuCargarPartida;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuCargarPartida implements KeyPressedObservador {

//	private MenuCargarPartida menuCargarPartida;
//	
//	public ControlKeyPressMenuCargarPartida(MenuCargarPartida menuCargarPartida) {
//		this.menuCargarPartida = menuCargarPartida;
//	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
						
			// Se presiona backspace, por lo que se vuelve al menu padre.	
			case KeyEvent.VK_BACK_SPACE:
//				this.menuCargarPartida.getMenuPadre().mostrar();
//				this.menuCargarPartida.ocultar();				
				break;
				
			case KeyEvent.VK_DOWN:
//				this.menuCargarPartida.BAJARFOCUSENLATABLA();
				
				break;
				
			// Se presiona flecha hacia arriba.	
			case KeyEvent.VK_UP:
//				this.menuPrincipal.SUBIRFOCUSENLATABLA();
				
				break;
				
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
//				ELEMENTO PATHdelSAVE = this.menuPrincipal.GETELEMENTOFOCUSENTABLA();
//				VENTANAPARTIDA = CARGAR(PATHdelSAVE);
//				this.menuCargarPartida.PARTIDA(VENTANAPARTIDA).mostrar();
//				this.menuCargarPartida.ocultar();
				break;
		}	
	}

	@Override
	public void keyRelease(KeyEvent arg0) {		
	}

}
