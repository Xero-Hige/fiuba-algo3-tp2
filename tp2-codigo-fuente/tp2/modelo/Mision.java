package tp2.modelo;

import java.util.*;

// Cada misión tendrá configurado las preferencias del nivel (aeronaves en sus
// respectivas flotas, el jugador, el escenario en donde interactuan). 	r
public class Mision {

	private Escenario escenario;
	private FabricaDeNaves fabricaJugador, fabricaEnemiga;
	private Flota flotaEnemiga, flotaAliada;
	private Jugador jugador;
	
	// Constructor
	public Mision() {
		
	}
	
	// Configura la misión de acuerdo a los datos pasados por parámetro.
	public void generar(Map<Flota, Nave> datos) {
		
	}
	
	// Hace avanzar el tiempo en el escenario del juego. Si se llegó a los 1000 puntos,
	// se avanza al siguiente nivel. Si se destruyó al guía enemigo, se inicia una nueva
	// ronda, mientras las naves de la flota anterior viajan abandonando el escenario.
	public void simularDurante(Integer unTiempo) {
		
	}
	
	public Escenario getEscenario() {
		return this.escenario;
	}
	
	protected void setEscenario(Escenario nuevoEscenario) {
		
	}
		
	public FabricaDeNaves getFabricaEnemiga() {
		return this.fabricaEnemiga;
	}
	
	public void setFabricaEnemiga(FabricaDeNaves nuevoFabricaEnemiga) {
		
	}
		
	public FabricaDeNaves getFabricaJugador() {
		return this.fabricaJugador;
	}
	
	public void setFabricaJugador(FabricaDeNaves nuevoFabricaJugador) {
		
	}
		
	public Flota getFlotaAliada() {
		return this.flotaAliada;
	}
	
	public void setFlotaAliada(Flota nuevaFlotaAliada) {
		
	}

	public Flota getFlotaEnemiga() {
		return this.flotaEnemiga;
	}
	
	public void setFlotaEnemiga(Flota nuevaFlotaEnemiga) {
		
	}
	
	public Jugador getJugador() {
		return this.jugador;
	}
	
	public void setJugador(Jugador nuevoJugador) {
		this.jugador = nuevoJugador;
	}
}
