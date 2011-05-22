package tp2.modelo;

import tp2.auxiliares.Point;

// Es un vuelo direccionable que persigue un objeto del espacio (incluso los 
// móviles).
public class VueloDirigido extends VueloDireccionable{

	// El objeto perseguido por el vuelo.
	private ObjetoEspacial objetivo;
	
	// Constructor
	// Inicializa un vuelo direccionable del objeto volador recibido, con el 
	// objetivo de destino dado.
	public VueloDirigido(ObjetoVolador unObjetoVolador, ObjetoEspacial objetivo) {
		super(unObjetoVolador, objetivo.getPosicion());
		this.objetivo = objetivo;
	}
	
	// Avanza el vuelo durante el tiempo indicado, dirigiéndose hacia la 
	// posición del objetivo. Devuelve el desplazamiento del vuelo. Si el vuelo
	// no fue iniciado, o si no se conoce al objetivo, se levanta una excepción.
	public Point avanzarDurante(double tiempo) {
		return null;
	}
	
	public ObjetoEspacial getObjetivo() {
		return this.objetivo;
	}
	
	// Cambia el objetivo del vuelo para que se dirija al objeto recibido.
	public void setObjetivo(ObjetoEspacial unObjetoEspacial) {
		
	}
	
}
