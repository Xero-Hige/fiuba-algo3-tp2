package tp2.modelo.menues;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import tp2.vista.menues.VistaMenuI;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;

public abstract class Menu implements MenuI, Posicionable  {

	private VentanaPrincipal ventanaPrincipal;
	private MenuI menuPadre;
	private Map<String, MenuI> menuesHijos;
	
	private VistaMenuI vistaMenu;
	private ArrayList<MenuItem> listaDeItems;
	private KeyPressedObservador controlKeyPress;
	private MouseClickObservador controlMouseClick;
			
	
	
	public Menu(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		this.ventanaPrincipal = ventanaPrincipal;
		this.menuPadre = menuPadre;
		this.listaDeItems = new ArrayList<MenuItem>();
		this.menuesHijos = new HashMap<String, MenuI>();
	}
	
	@Override
	public int getX() {
		return DimensionesDeVentana.centroX;
	}

	@Override
	public int getY() {
		return DimensionesDeVentana.centroY;
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
	
	public void setMenuPadre(MenuI menuPadre) {
		this.menuPadre = menuPadre;
	}

	public Map<String, MenuI> getListaMenuesHijos() {
		return this.menuesHijos;
	}
	
	public void agregarMenuHijo(String nombreMenu, MenuI menuHijo) {
		this.menuesHijos.put(nombreMenu, menuHijo);
	}
	
	public void agregarItem(MenuItem unItem) {
		this.listaDeItems.add(unItem);
	}
	
	public void removerItem(MenuItem unItem) {
		this.listaDeItems.remove(unItem);
	}
	
	public ArrayList<MenuItem> getListaDeItems() {
		return listaDeItems;
	}

	public void mostrar() {
				
		this.ventanaPrincipal.agregarObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.agregarObjetosDibujables(this.vistaMenu.getObjetosDibujables());
		
		Iterator<MenuItem> i = this.listaDeItems.iterator();
		MenuItem itemTemp;
		
		while (i.hasNext()) {
			
			itemTemp = i.next();
			this.ventanaPrincipal.agregarObjetoDibujable(itemTemp.getVistaMenuItem());
		}
		
		this.activarControl();
		
		realizarAlMostrar();
	}

	public void ocultar() {
				
		this.ventanaPrincipal.removerObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.removerObjetosDibujables(this.vistaMenu.getObjetosDibujables());
		
		Iterator<MenuItem> i = this.listaDeItems.iterator();
		
		while (i.hasNext()) 
			this.ventanaPrincipal.removerObjetoDibujable(i.next().getVistaMenuItem());
		
		realizarAlOcultar();
	}
	
	@Override
	public abstract void realizarAlMostrar();
	
	@Override
	public abstract void activarControl();
		
	@Override
	public void desactivarControl() {
		this.ventanaPrincipal.desactivarKeyPressObservador();
		this.ventanaPrincipal.desactivarMouseClickObservador();
	}
}
