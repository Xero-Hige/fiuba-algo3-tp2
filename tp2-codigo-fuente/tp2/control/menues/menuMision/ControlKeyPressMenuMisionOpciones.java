package tp2.control.menues.menuMision;

import java.awt.event.KeyEvent;

import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

import tp2.modelo.menues.menuMision.MenuMisionOpciones;


public class ControlKeyPressMenuMisionOpciones implements KeyPressedObservador {

	private MenuMisionOpciones menuMisionOpciones;
	private int itemActivo;
	private int cantTotalDeItems;

	
	public ControlKeyPressMenuMisionOpciones(MenuMisionOpciones menuMisionOpciones) {
		this.menuMisionOpciones = menuMisionOpciones;
		this.itemActivo = 0;
		this.cantTotalDeItems = this.menuMisionOpciones.getListaDeItems().size();
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			// Se presiona flecha hacia abajo.
			case KeyEvent.VK_DOWN:
				this.menuMisionOpciones.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOut();
				this.itemActivo++;
				this.mantenerIndiceDentroDelRango();
				this.menuMisionOpciones.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOver();
				break;
				
			// Se presiona flecha hacia arriba.	
			case KeyEvent.VK_UP:
				this.menuMisionOpciones.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOut();
				this.itemActivo--;
				this.mantenerIndiceDentroDelRango();
				this.menuMisionOpciones.getListaDeItems().get(this.itemActivo).getVistaMenuItem().itemOver();
				break;
				
			// Se presiona enter, por lo que se selecciona la opción del item actual.	
			case KeyEvent.VK_ENTER:
				this.menuMisionOpciones.getListaDeItems().get(this.itemActivo).seleccionar();
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
