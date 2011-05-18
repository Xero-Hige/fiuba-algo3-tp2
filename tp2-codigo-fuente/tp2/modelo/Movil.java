package tp2.modelo;

import tp2.auxiliares.Point;

public abstract class Movil extends ObjetoEspacial {

	private double velocidad;
	private String equipo;

	public Movil(Point posicion, double tamano, Escenario escenario,
			double velocidad) {
		super(posicion, tamano, escenario);
		// Inicializa el móvil con la posición, tamaño, escenario y velocidad
		// recibidos. Lo agrega al escenario.
		this.velocidad = velocidad;
		this.equipo = null;
	}

	public double getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public Boolean esAliadoDe(Movil movil) {
		// Devuelve si el móvil pertenece al mismo equipo del recibido.
		if (this.getEquipo() == null)
			return false;
		return this.getEquipo() == movil.getEquipo();
	}

	// Mueve al móvil de acuerdo al tiempo recibido.
	public abstract void moverDurante(double tiempo);

	public void desplazarEn(Point desplazamiento) {
		// Recibe el desplazamiento y mueve al móvil de acuerdo al mismo,
		// respecto a su posición actual.
		this.setPosicion(this.getPosicion().sumar(desplazamiento));
	}

}
