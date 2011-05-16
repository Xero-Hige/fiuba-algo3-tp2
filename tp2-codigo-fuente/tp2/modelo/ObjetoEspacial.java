package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoEspacial {

	private Point posicion;
	private double tamano;
	private Escenario escenario;

	public ObjetoEspacial(Point posicion, double tamano, Escenario escenario) {
		// Inicializa el objeto con la posición, tamaño y escenario recibidos.
		// Lo agrega al escenario.
		this.posicion = posicion;
		this.tamano = tamano;
		this.escenario = escenario;
		// Falta agregarlo al escenario
	}

	public Point getPosicion() {
		return posicion;
	}

	public double getTamano() {
		return tamano;
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public boolean estaSuperpuesto(ObjetoEspacial objetoEspacial) {
		// Devuelve true si el objeto recibido está superpuesto con el receptor
		// del mensaje. Sino false.
		
		double distanciaMaxima, distancia;
		distanciaMaxima = this.getTamano() + objetoEspacial.getTamano();
		distancia = this.getPosicion().distance(objetoEspacial.getPosicion());
		return distancia < distanciaMaxima;
	}

}
