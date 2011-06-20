package tp2.vista.modelo.mision;

import java.util.ArrayList;

import tp2.modelo.menues.menuMision.BarraDeEstado;
import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaBarraDeEstado extends Imagen {

	public ArrayList<Dibujable> objetosDibujablesDeLaVista;
	public VistaTextoPuntuacion vistaTextoPuntacion;
	public VistaTextoVidas vistaTextoVidas;
	public VistaBarraDeEnergiaBase vistaBarraDeEnergiaBase; 
	
	
	public VistaBarraDeEstado() {

		// Cargamos la imagen de la barra de fondo
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenBarraDeEstado());
		this.setPosicionable(new BarraDeEstado());
		
		// Creamos la lista de dibujables
		this.objetosDibujablesDeLaVista = new ArrayList<Dibujable>();
		
		// Creamos los textos de puntuacion, cantidad de vidas y barra de energia
		this.vistaTextoPuntacion = new VistaTextoPuntuacion();
		this.agregarObjetoDibujableDeLaVista(vistaTextoPuntacion);
		
		this.vistaTextoVidas = new VistaTextoVidas();
		this.agregarObjetoDibujableDeLaVista(vistaTextoVidas);	
		
		this.vistaBarraDeEnergiaBase = new VistaBarraDeEnergiaBase();
		this.agregarObjetoDibujableDeLaVista(vistaBarraDeEnergiaBase);
	}
	
	public void setPuntaje(int nuevoPuntaje) {
		this.vistaTextoPuntacion.setPuntaje(nuevoPuntaje);
	}
	
	public void setVidas(int cantidadVidas) {
		this.vistaTextoVidas.setVidas(cantidadVidas);
	}
	
	public void agregarObjetoDibujableDeLaVista(Dibujable unDibujable) {
		this.objetosDibujablesDeLaVista.add(unDibujable);
	}
	
	public void removerObjetoDibujableDeLaVista(Dibujable unDibujable) {
		this.objetosDibujablesDeLaVista.remove(unDibujable);
	}
	
	public ArrayList<Dibujable> getObjetosDibujablesDeLaVista() {
		return this.objetosDibujablesDeLaVista;
	}
}
