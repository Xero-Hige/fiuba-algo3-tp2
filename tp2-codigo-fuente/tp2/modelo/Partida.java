package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Es la que permite generar un conjunto de misiones para ser jugadas.
// Al iniciarse una partida se van cargando misiones a medida que se superan estas
// y en caso de que el jugador pierda, la partida finaliza.
public class Partida implements IGuardable {

	Jugador jugador;
	Mision misonActual;
	int cantidadNiveles;
	int nivelActual;
	Boolean enCurso;
	
	
	//Constructor
	public Partida() {
		
	}
	
	// Inicia la partida para que pueda ser corrida.
	public void iniciar() {
		
	}
	
	// Detiene la partida para que ya no pueda ser corrida. De no haberse
	// iniciado lanza una excepción del tipo PartidaNoIniciada.
	public void detener() {
		
	}
	
	// Corre la partida.
	public void correr() {
		
	}
	
	// Devuelve si la partida se ha iniciado y esta en curso.
	public Boolean estaEnCurso() {
		return false;
	}
	
	// Genera una partida nueva.
	public void generarNueva() {
		
	}
	
	// Devuelve si la partida ha sido ganada (se deben haber superado todas las
	// misiones).
	public Boolean estaGanada() {
		return false;
	}

	@Override
	public Element guardar(Element contenedor) {		
		contenedor.appendChild(GeneradorXml.generarElementoDe(jugador, "jugador"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(misonActual, "misionActual"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(cantidadNiveles, "cantidadNiveles"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(nivelActual, "nivelActual"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.jugador = (Jugador) ReconstructorDesdeXml.generarObjeto(atributos.get("jugador"));
		this.misonActual = (Mision) ReconstructorDesdeXml.generarObjeto(atributos.get("misonActual"));
		this.cantidadNiveles =(Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("cantidadNiveles"));
		this.nivelActual = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("nivelActual"));
		this.enCurso = false;
		return this;
	}	
}
