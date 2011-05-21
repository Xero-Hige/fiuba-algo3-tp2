package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.VueloNoIniciado;

public class VueloEnLineaRecta extends Vuelo {

	private Point direccion;

	public VueloEnLineaRecta(ObjetoVolador objetoVolador, Point direccion) {
		super(objetoVolador);
		this.setDireccion(direccion);
	}

	public Point getDireccion() {
		return direccion;
	}

	protected void setDireccion(Point direccion) {
		if(direccion.norma() > 0){
			direccion = direccion.multiplicar(1 / direccion.norma());
		}
		this.direccion = direccion;
	}

	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del
	// mismo respecto al estado anterior. Si el vuelo no comenzó, se levanta una
	// excepción.
	@Override
	public Point avanzarDurante(double tiempo) {
		double velocidad;
		if(!this.estaIniciado()){
			throw new VueloNoIniciado("El vuelo no ha iniciado.");			
		}
		velocidad = this.getObjetoVolador().getVelocidad();
		this.aumentarTrayectoriaEn(tiempo * velocidad);
		return (this.getDireccion().multiplicar(tiempo * velocidad));
	}
}
