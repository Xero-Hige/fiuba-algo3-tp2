package tp2.modelo.extras;

import tp2.auxiliares.Point;
import tp2.modelo.Escenario;
import tp2.modelo.Visible;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;

public class Agua implements Visible {

	private Escenario escenario;
	private Point posicion;

	public Agua(Escenario escenario) {
		this.escenario = escenario;
		this.posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), this.escenario.getAreaDeCombate().getCenterY());
	}

	@Override
	public int getX() {
		return (int) ProyeccionSobreSuperficieDeDibujo.proyectarPunto(
				this.posicion).getX();
	}

	@Override
	public int getY() {
		return (int) ProyeccionSobreSuperficieDeDibujo.proyectarPunto(
				this.posicion).getY();
	}

	@Override
	public String getIdentificacion() {
		return "Agua";
	}

	@Override
	public double getTamanio() {
		return this.escenario.getAreaDeCombate().getWidth();
	}
}
