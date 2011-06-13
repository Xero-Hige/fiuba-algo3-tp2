package tp2.modelo.menues;

import java.util.ArrayList;
import tp2.vista.menues.VistaMenuI;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;

public class Menu {

	private VentanaPrincipal ventanaPrincipal;
	private MenuI menuPadre;
	private ArrayList<MenuI> listaMenuesHijos;
	
	private VistaMenuI vistaMenu;
	private KeyPressedObservador controlKeyPress;
	private MouseClickObservador controlMouseClick;
			
	
	
	public Menu(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		this.ventanaPrincipal = ventanaPrincipal;
		this.menuPadre = menuPadre;
	}
	
	public VentanaPrincipal getVentanaPrincipal() {
		return ventanaPrincipal;
	}
	
	public void setVentanaPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.ventanaPrincipal = ventanaPrincipal;
	}
	
	public void setVistaMenu(VistaMenuI vistaMenu) {
		this.vistaMenu = vistaMenu;
	}
	
	public VistaMenuI getVistaMenu() {
		return this.vistaMenu;
	}

	public void setControlKeyPress(KeyPressedObservador controlKeyPress) {
		this.controlKeyPress = controlKeyPress;
	}
	
	public KeyPressedObservador getControlKeyPress() {
		return this.controlKeyPress;
	}

	public void setControlMouseClick(MouseClickObservador controlMouseClick) {
		this.controlMouseClick = controlMouseClick;
	}
	
	public MouseClickObservador getControlMouseClick() {
		return this.controlMouseClick;
	}
	
	public MenuI getMenuPadre() {
		return this.menuPadre;
	}

	public ArrayList<MenuI> getListaMenuesHijos() {
		return this.listaMenuesHijos;
	}

	public void mostrar() {
		this.ventanaPrincipal.agregarObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.agregarObjetosDibujables(this.vistaMenu.getObjetosDibujables());
	}

	public void ocultar() {
		this.ventanaPrincipal.removerObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.removerObjetosDibujables(this.vistaMenu.getObjetosDibujables());
	}
}
