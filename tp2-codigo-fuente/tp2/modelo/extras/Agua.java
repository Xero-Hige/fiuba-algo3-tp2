package tp2.modelo.extras;

import tp2.auxiliares.Point;
import tp2.modelo.Escenario;
import tp2.modelo.Visible;
import tp2.vista.ventanas.Proyeccion;

public class Agua implements Visible {

	private Escenario escenario;
	private Point posicion;
	private Proyeccion proyeccion;

	public Agua(Escenario escenario) {
		this.escenario = escenario;
		this.posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), this.escenario.getAreaDeCombate().getCenterY());
	}

	@Override
	public int getX() {
		return (int) this.proyeccion.proyectarPunto(this.posicion).getX();
	}

	@Override
	public int getY() {
		return (int) this.proyeccion.proyectarPunto(this.posicion).getY();
	}
	
	@Override
	public void setProyeccion(Proyeccion proyeccion) {
		this.proyeccion = proyeccion;
	}

	@Override
	public String getIdentificacion() {
		return "Agua";
	}

	@Override
	public double getTamanio() {
		return this.escenario.getAreaDeCombate().getWidth();
	}

	@Override
	public Point getPosicion() {
		return this.posicion;
	}
	
}
