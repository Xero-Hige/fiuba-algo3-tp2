package tp2.modelo;

import tp2.auxiliares.Point;

// Es una nave militar que además, al ser destruída, aumenta la puntuación del 
// escenario y opcionalmente tira un bono en el mismo.
public class NaveEnemiga extends NaveMilitar {

	// La puntuación por destrucción de la nave.
	private double puntuacion;
	// El bono que brinda al ser destruída (si tiene).
	private Bono bono;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado, armas ni bono y puntuación nula, 
	// con la posición, tamaño, escenario, velocidad y energía recibidos. La agrega 
	// al escenario.
	public NaveEnemiga(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	@Override
	// Ordena a la nave enemiga actuar en el escenario durante el tiempo 
	// específicado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	// Destruye la nave y le impide realizar acciones en el futuro. Además, 
	// posiciona al bono en el escenario, en el lugar donde la nave acaba de ser 
	// destruída.
	public void destruir() {

	}
	
	// Cambia el bono de la nave.
	public void setBono(Bono unBono) {
		
	}
	
	// Devuelve la puntuación por destrucción de esta nave.
	public double getPuntuacion() {
		return this.puntuacion;
	}
	
	// Recibe la penalización por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepción).
	public void setPuntuacion(double unaPuntuacion) {
		
	}
}
