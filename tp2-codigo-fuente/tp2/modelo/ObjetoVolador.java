package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class ObjetoVolador extends Movil {

	public ObjetoVolador(Point posicion, double tamano, Escenario escenario,
			double velocidad) {
		super(posicion, tamano, escenario, velocidad);
		// Inicializa el objeto volador sin un vuelo asignado, con la posición,
		// tamaño, escenario y velocidad recibidos. Lo agrega al escenario.
	}

	@Override
	public void moverDurante(double tiempo) {
		// Mueve al objeto volador de acuerdo al tiempo recibido y el vuelo que
		// tenga. Si no tiene un vuelo definido o un escenario asignado, se
		// levanta una excepción.

	}

}
