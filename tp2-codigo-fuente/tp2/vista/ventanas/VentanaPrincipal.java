package tp2.vista.ventanas;

import java.util.ArrayList;
import java.util.Iterator;

import tp2.modelo.menues.MenuPrincipal;
import tp2.vista.menues.FabricaDeDibujablesDelMenu;
import tp2.vista.menues.VistaMenuPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.vista.Imagen;
import ar.uba.fi.algo3.titiritero.vista.Ventana;


public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
	private ControladorJuego controladorJuego;
	private KeyPressedObservador controlKeyPressActivo;
	private MouseClickObservador controlMouseClickActivo;
		
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		
		super(500,500, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);
		this.controladorJuego = unControladorJuego;
		this.controlKeyPressActivo = null;
		this.controlMouseClickActivo = null;
		this.inicializar();
	}
		
	/** Inicializa la ventana principal mostrando el menú principal del juego */
	private void inicializar() {
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal(this, (Imagen) FabricaDeDibujablesDelMenu.nuevaImagenFondoMenuPrincipal());
		vistaMenuPrincipal.setPosicionable(menuPrincipal);
		this.controladorJuego.agregarDibujable(vistaMenuPrincipal);	
		this.agregarObjetosDibujables(vistaMenuPrincipal.getObjetosDibujablesPropios());
	}
	
	public ControladorJuego getControladorJuego() {
		return this.controladorJuego;
	}
	
	public void setControlKeyPressActivo(KeyPressedObservador controlKeyPressActivo) {
		this.controlKeyPressActivo = controlKeyPressActivo;	
	}
	
	public void setMouseClickActivo(MouseClickObservador controlMouseClickActivo) {
		this.controlMouseClickActivo = controlMouseClickActivo;
	}
	
	public void agregarObjetosDibujables(ArrayList<Dibujable> objetosDibujables) {
		
		Iterator<Dibujable> iterador = objetosDibujables.iterator();
		while(iterador.hasNext()) {
			this.controladorJuego.agregarDibujable(iterador.next());
		}		
	}
	
	public void removerObjetosDibujables(ArrayList<Dibujable> objetosDibujables) {
		
		Iterator<Dibujable> iterador = objetosDibujables.iterator();
		while(iterador.hasNext()) {
			this.controladorJuego.removerDibujable(iterador.next());
		}		
	}
	
	/** Activa al observador del teclado */
	public void activarKeyPressObservador() {
		this.controladorJuego.agregarKeyPressObservador(this.controlKeyPressActivo);
	}
	
	/** Desactiva al observador del teclado */
	public void desactivarKeyPressObservador() {
		this.controladorJuego.removerKeyPressObservador(this.controlKeyPressActivo);
	}
	
	/** Activa al observador del Mouse */
	public void activarMouseClickObservador() {
		this.controladorJuego.agregarMouseClickObservador(this.controlMouseClickActivo);
	}
	
	/** Desactiva al observador del Mouse */
	public void desactivarMouseClickObservador() {
		this.controladorJuego.removerMouseClickObservador(this.controlMouseClickActivo);
	}
}