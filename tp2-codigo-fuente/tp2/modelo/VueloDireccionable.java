package tp2.modelo;

import tp2.auxiliares.Point;

// Es un vuelo que puede cambiar la dirección cuando se desee.
public class VueloDireccionable extends Vuelo {
	
	// La dirección actual de vuelo.
	private Point direccion;
	
	// Constructor
	// Inicializa un vuelo direccionable del objeto volador recibido, con la 
	// dirección dada.
	public VueloDireccionable(ObjetoVolador unObjetoVolador, Point direccion) {
		super(unObjetoVolador);
		this.direccion = direccion;
	}
	
	@Override
	// Avanza el vuelo durante el tiempo indicado. Si la dirección es la nula, 
	// entonces el vuelo permanece en el mismo lugar. Devuelve el desplazamiento
	// del vuelo. Si el vuelo no fue iniciado, se levanta.
	public Point avanzarDurante(double tiempo) {
		return null;
	}
	
	public Point getDireccion() {
		return this.direccion;
	}
	
	// Permite cambiar la dirección de vuelo. El vuelo reaccionará inmediamente 
	// a la nueva dirección la próxima vez que avance.
	public void setDireccion(Point nuevaDireccion) {
		
	}
}
