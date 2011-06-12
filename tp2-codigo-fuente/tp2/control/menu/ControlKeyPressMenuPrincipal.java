package tp2.control.menu;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import tp2.vista.menues.VistaMenuItem;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuPrincipal implements KeyPressedObservador {

	private ArrayList<VistaMenuItem> listaDeVistasDeItems;
	private int itemActivo;
	private int cantTotalDeItems;
	
	public ControlKeyPressMenuPrincipal(ArrayList<VistaMenuItem> listaDeVistasDeItems) {
		this.listaDeVistasDeItems = listaDeVistasDeItems;
		this.itemActivo = 0;
		this.cantTotalDeItems = this.listaDeVistasDeItems.size();
	}
	
	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
		
			case KeyEvent.VK_DOWN:
				/* LINEA DE DEBUG */
				System.out.println("Abajo");
				/* ******************************************** */
				this.listaDeVistasDeItems.get(this.itemActivo).itemOut();
				this.itemActivo++;
				this.mantenerIndiceDentroDelRango();
				this.listaDeVistasDeItems.get(this.itemActivo).itemOver();
				break;
				
			case KeyEvent.VK_UP:
				/* LINEA DE DEBUG */
				System.out.println("Arriba");
				/* ******************************************** */
				this.listaDeVistasDeItems.get(this.itemActivo).itemOut();
				this.itemActivo--;
				this.mantenerIndiceDentroDelRango();
				this.listaDeVistasDeItems.get(this.itemActivo).itemOver();
				break;
				
			case KeyEvent.VK_ENTER:
				/* LINEA DE DEBUG */
				System.out.println("Enter");
				/* ******************************************** */
				break;
		}	
	}
	
	// Método privado que mantiene al item activo dentro del rango de items existentes.
	private void mantenerIndiceDentroDelRango() {
		
		if (this.itemActivo < 0)
			this.itemActivo = this.cantTotalDeItems;
		else if(this.itemActivo > this.cantTotalDeItems)
			this.itemActivo = 0;
	}
	
	public void keyRelease(KeyEvent event) {}
}
