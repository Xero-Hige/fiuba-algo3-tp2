package tp2.vista.ventanas;

import java.util.ArrayList;
import java.util.Iterator;

import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.MouseClickObservador;
import ar.uba.fi.algo3.titiritero.vista.Ventana;


public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
	private ControladorJuegoAlgo42 controladorJuego;
	private KeyPressedObservador controlKeyPressActivo;
	private MouseClickObservador controlMouseClickActivo;
		
	public VentanaPrincipal(ControladorJuegoAlgo42 unControladorJuego) {
		
		super(DimensionesDeVentana.ancho, DimensionesDeVentana.alto + DimensionesDeVentana.altoBarraDeVentana, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);
		this.controladorJuego = unControladorJuego;
		this.controlKeyPressActivo = null;
		this.controlMouseClickActivo = null;
		
		// Creación del menu principal a mostrar en el inicio.
		MenuPrincipal menuPrincipal = new MenuPrincipal(this);
		menuPrincipal.mostrar();
	}
		
	public ControladorJuegoAlgo42 getControladorJuego() {
		return this.controladorJuego;
	}
	
	public void setControlKeyPressActivo(KeyPressedObservador controlKeyPressActivo) {
		this.desactivarKeyPressObservador();
		this.controlKeyPressActivo = controlKeyPressActivo;	
		this.activarKeyPressObservador();
	}
	
	public void setMouseClickActivo(MouseClickObservador controlMouseClickActivo) {
		this.controlMouseClickActivo = controlMouseClickActivo;
	}
	
	public void agregarObjetoDibujable(Dibujable objetoDibujable) {
			this.controladorJuego.agregarDibujable(objetoDibujable);	
	}
	
	public void removerObjetoDibujable(Dibujable objetoDibujable) {
			this.controladorJuego.removerDibujable(objetoDibujable);
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