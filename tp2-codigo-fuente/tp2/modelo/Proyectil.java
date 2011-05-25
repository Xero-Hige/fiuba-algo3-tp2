package tp2.modelo;

import tp2.auxiliares.Point;


// Un proyectil es capaz de dañar naves no aliadas al impactar con ellas en el escenario.
public class Proyectil extends ObjetoVolador implements Cloneable {

	// El daño por impacto del proyectil.
	protected double danio;
	
	
	// Constructor
	// Inicializa el proyectil sin un vuelo asignado, con la posición, tamaño, 
	// velocidad y daño recibidos.
	public Proyectil(Point posicion, double tamanio, double velocidad, double danio) {
		super(posicion, tamanio, null, velocidad);
		this.danio = danio;
	}
	
	@Override
	// Simple Cloning del objeto.
	public Proyectil clone() {
		
		Proyectil clone = null;

		try {
	      clone = (Proyectil) super.clone();
	    }
	    catch(CloneNotSupportedException e) { }

		return clone;
	}
	
	@Override
	// Hace actuar al objeto volador en el escenario durante el tiempo específicado,
	// haciendo que el mismo vuele durante ese tiempo. Si no tiene escenario o 
	// vuelo, se levanta una excepción.
	public void actuarDurante(double unTiempo) {
		
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar un proyectil, según su 
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	public double getDanio() {
		return this.danio;
	}
	
	// Cambia el daño del proyectil a un nuevo valor mayor o igual a cero. Si se 
	// recibe un daño negativo, entonces se levanta una excepción.
	public void setDanio(double nuevoDanio) {
		
	}
	
}
