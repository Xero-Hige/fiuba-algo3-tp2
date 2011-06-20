package tp2.control.menues.menuComoJugar;

import java.awt.event.KeyEvent;

import tp2.modelo.menues.menuComoJugar.MenuComoJugar;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuComoJugar implements KeyPressedObservador  {
	
	private MenuComoJugar menuComoJugar;
	
	public ControlKeyPressMenuComoJugar(MenuComoJugar menuComoJugar) {
		this.menuComoJugar = menuComoJugar;
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
						
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				this.menuComoJugar.getMenuPadre().mostrar();
				this.menuComoJugar.ocultar();				
				break;
		}	
	}

	@Override
	public void keyRelease(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
