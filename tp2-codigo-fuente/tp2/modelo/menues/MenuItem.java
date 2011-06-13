package tp2.modelo.menues;

import ar.uba.fi.algo3.titiritero.Posicionable;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.ventanas.VentanaPrincipal;

public abstract class MenuItem implements MenuItemI, Posicionable  {

	private VentanaPrincipal ventanaPrincipal;
	private MenuI menuDelItem;
	private VistaMenuItem vistaMenuItem;
	private int x;
	private int y;
	
	
	public MenuItem(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		this.ventanaPrincipal = ventanaPrincipal;
		this.menuDelItem = menuDelItem;
		this.x = 0;
		this.y = 0;
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	@Override
	public int getY() {
		return this.y;
	}
	
	public VistaMenuItem getVistaMenuItem() {
		return vistaMenuItem;
	}

	public void setVistaMenuItem(VistaMenuItem vistaMenuItem) {
		this.vistaMenuItem = vistaMenuItem;
	}

	public MenuI getMenuDelItem() {
		return menuDelItem;
	}

	public void setMenuDelItem(MenuI menuDelItem) {
		this.menuDelItem = menuDelItem;
	}
		
	public abstract void seleccionar();
}
