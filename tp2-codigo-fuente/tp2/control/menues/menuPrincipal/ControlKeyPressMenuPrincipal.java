package tp2.control.menues.menuPrincipal;

import java.awt.event.KeyEvent;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuPrincipal implements KeyPressedObservador {

	private MenuPrincipal menuPrincipal;
	private int itemActivo;
	private int cantTotalDeItems;
	
	public ControlKeyPressMenuPrincipal(MenuPrincipal menuPrincipal) {
		this.menuPrincipal = menuPrincipal;
		this.itemActivo = 0;
		this.cantTotalDeItems = this.menuPrincipal.getListaDeItems().size();
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			// Se presiona flecha hacia abajo.
			case KeyEvent.VK_DOWN:
				this.menuPrincipal.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOut();
				this.itemActivo++;
				this.mantenerIndiceDentroDelRango();
				this.menuPrincipal.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOver();
				break;
				
			// Se presiona flecha hacia arriba.	
			case KeyEvent.VK_UP:
				this.menuPrincipal.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOut();
				this.itemActivo--;
				this.mantenerIndiceDentroDelRango();
				this.menuPrincipal.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOver();
				break;
				
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				this.menuPrincipal.getListaDeItems().get(this.itemActivo).seleccionar();
				((MenuPrincipal)(this.menuPrincipal)).getAudio().stop();
				this.menuPrincipal.ocultar();
				this.menuPrincipal.resetear();
				break;
		}	
	}
	
	// Método privado que mantiene al item activo dentro del rango de items existentes.
	private void mantenerIndiceDentroDelRango() {
		
		if (this.itemActivo < 0)
			this.itemActivo = this.cantTotalDeItems - 1;
		else if(this.itemActivo > (this.cantTotalDeItems - 1))
			this.itemActivo = 0;
	}
	
	public void keyRelease(KeyEvent event) {}
}
