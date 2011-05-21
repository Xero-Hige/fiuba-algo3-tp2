package tp2.modelo;

import tp2.auxiliares.Point;

// Una nave civil es tal que al destruirse, disminuye la puntuación del escenario 
// según la penalización que tenga.
public class NaveCivil extends Nave {

	// Cuánto disminuye la puntuación del escenario al destruir la nave.
	private int penalizacion;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado y penalización nula, con la 
	// posición, tamaño, escenario, velocidad y energía recibidos. La agrega al 
	// escenario.
	public NaveCivil(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo específicado.
	public void actuarDurante(double unTiempo) {
		
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave civil, según su 
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Devuelve la penalización de puntos asociada a esta nave.
	public int getPenalizacion() {
		return this.penalizacion;
	}
	
	// Recibe la penalización por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepción).
	public void setPenalizacion(int unaPenalizacion) {
		
	}
}
