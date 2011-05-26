package tp2.modelo;

import java.util.*;

// Es la que permite generar un conjunto de misiones para ser jugadas.
// Al iniciarse una partida se van cargando misiones a medida que se superan estas
// y en caso de que el jugador pierda, la partida finaliza.
public class Partida {

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
	
	// Carga una partida ya existente a partir de un hash de datos.
	public void cargar(Map<Flota, Nave> datos) {
		
	}
	
	// Genera una partida nueva.
	public void generarNueva() {
		
	}
	
	// Devuelve si la partida ha sido ganada (se deben haber superado todas las
	// misiones).
	public Boolean estaGanada() {
		return false;
	}
	
}
