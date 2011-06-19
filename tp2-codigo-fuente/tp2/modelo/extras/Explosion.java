package tp2.modelo.extras;

import tp2.auxiliares.Point;
import tp2.modelo.Visible;
import tp2.vista.ventanas.Proyeccion;
import ar.uba.fi.algo3.titiritero.ObjetoVivo;

public class Explosion implements Visible, ObjetoVivo {
	
	private Point posicion;
	private double velocidad;
	private double tamanio;
	private Proyeccion proyeccion;

	public Explosion (Visible objeto, double velocidad, double tamanio) {
		
		this.posicion = objeto.getPosicion();
		this.velocidad = velocidad;
		this.tamanio = tamanio;
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
	public void vivir() {
		this.posicion = this.posicion.sumarCon(new Point(0, -velocidad * 0.02));
	}

	@Override
	public String getIdentificacion() {
		return "Explosion";
	}

	@Override
	public double getTamanio() {
		return this.tamanio;
	}

	@Override
	public Point getPosicion() {
		return this.posicion;
	}

}