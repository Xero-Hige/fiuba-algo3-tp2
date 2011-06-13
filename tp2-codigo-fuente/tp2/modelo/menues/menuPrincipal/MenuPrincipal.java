package tp2.modelo.menues.menuPrincipal;

import java.util.ArrayList;
import tp2.control.menu.menuPrincipal.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.FabricaDeDibujablesDelMenu;
import tp2.vista.menues.VistaMenuI;
import tp2.vista.menues.menuPrincipal.VistaMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MenuPrincipal implements MenuI, Posicionable  {

	private int alto;
	private int ancho;
	
	private VistaMenuI vistaMenu;
	private KeyPressedObservador controlKeyPress;
	private MouseClickObservador controlMouseClick;
	
	private VentanaPrincipal ventanaPrincipal;
	private MenuI menuPadre;
	private ArrayList<MenuI> listaMenuesHijos;

	
	public MenuPrincipal(VentanaPrincipal ventanaPrincipal){
		this.ventanaPrincipal = ventanaPrincipal;
		this.alto = 500;
		this.ancho = 500;
		
		// Creamos la vista del menu principal
		this.vistaMenu = new VistaMenuPrincipal(this.ventanaPrincipal, (Imagen) FabricaDeDibujablesDelMenu.nuevaImagenFondoMenuPrincipal());
		this.vistaMenu.setPosicionable(this);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.controlKeyPress = new ControlKeyPressMenuPrincipal(this.vistaMenu.getItemsDelMenu());
		this.ventanaPrincipal.setControlKeyPressActivo(this.controlKeyPress);
		this.ventanaPrincipal.activarKeyPressObservador();
	}
	
	@Override
	public int getX() {
		return 0;
	}

	@Override
	public int getY() {
		return 0;
	}
	
	public int getAlto() {
		return alto;
	}

	public void setAlto(int alto) {
		this.alto = alto;
	}

	public int getAncho() {
		return ancho;
	}

	public void setAncho(int ancho) {
		this.ancho = ancho;
	}

	@Override
	public VistaMenuI getVistaMenu() {
		return this.vistaMenu;
	}

	@Override
	public KeyPressedObservador getControlKeyPress() {
		return this.controlKeyPress;
	}

	@Override
	public MouseClickObservador getControlMouseClick() {
		return this.controlMouseClick;
	}

	@Override
	public MenuI getMenuPadre() {
		return this.menuPadre;
	}

	@Override
	public ArrayList<MenuI> getListaMenuesHijos() {
		return this.listaMenuesHijos;
	}

	@Override
	public void mostrar() {
		this.ventanaPrincipal.agregarObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.agregarObjetosDibujables(this.vistaMenu.getObjetosDibujables());
	}

	@Override
	public void ocultar() {
		this.ventanaPrincipal.removerObjetoDibujable((Dibujable) this.vistaMenu);
		this.ventanaPrincipal.removerObjetosDibujables(this.vistaMenu.getObjetosDibujables());
	}
}
