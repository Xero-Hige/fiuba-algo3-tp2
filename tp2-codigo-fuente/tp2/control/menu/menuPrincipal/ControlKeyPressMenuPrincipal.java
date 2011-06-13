package tp2.control.menu.menuPrincipal;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import tp2.vista.menues.menuPrincipal.VistaMenuItem;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuPrincipal implements KeyPressedObservador {

	private MenuPrincipal menuPrincipal;
	private ArrayList<VistaMenuItem> listaDeVistasDeItems;
	private int itemActivo;
	private int cantTotalDeItems;
	
	public ControlKeyPressMenuPrincipal(MenuPrincipal menuPrincipal, ArrayList<VistaMenuItem> listaDeVistasDeItems) {
		this.menuPrincipal = menuPrincipal;
		this.listaDeVistasDeItems = listaDeVistasDeItems;
		this.itemActivo = 0;
		this.cantTotalDeItems = this.listaDeVistasDeItems.size();
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			// Se presiona flecha hacia abajo.
			case KeyEvent.VK_DOWN:
				this.listaDeVistasDeItems.get(this.itemActivo).itemOut();
				this.itemActivo++;
				this.mantenerIndiceDentroDelRango();
				this.listaDeVistasDeItems.get(this.itemActivo).itemOver();
				break;
				
			// Se presiona flecha hacia arriba.	
			case KeyEvent.VK_UP:
				this.listaDeVistasDeItems.get(this.itemActivo).itemOut();
				this.itemActivo--;
				this.mantenerIndiceDentroDelRango();
				this.listaDeVistasDeItems.get(this.itemActivo).itemOver();
				break;
				
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				this.menuPrincipal.ocultar();
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
