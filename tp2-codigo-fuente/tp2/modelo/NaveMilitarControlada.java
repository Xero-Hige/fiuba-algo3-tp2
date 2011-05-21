package tp2.modelo;

import tp2.auxiliares.Point;


// Es una nave militar la cual permite ser controlada externamente. Se le puede 
// ordenar que se empiece a mover en una dirección o que se detenga, que accione 
// un arma o detenga sus disparos.
public class NaveMilitarControlada extends NaveMilitar {

	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad y energía recibidos. La agrega al escenario.
	public NaveMilitarControlada(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
	}
	
	// Recibe la identificación del arma que se desea disparar. Si no existe dicha 
	// arma, se levanta una excepción.
	public void iniciarFuegoConArmaDeId(String unaIdentificacion) {
		
	}
	
	// Recibe la identificación del arma que se desea dejar de disparar. Si no 
	// existe dicha arma, se levanta una excepción.
	public void detenerFuegoConArmaDeId(String unaIdentificacion) {
		
	}
	
	// Cambia la dirección de la nave a la especificada. Si se desea que la nave se 
	// quede quieta, debe recibirse la dirección (0,0).
	public void setDireccionDeVuelo(Point nuevaDireccion) {
		
	}
	
	@Override
	// El vuelo de una nave controlada no puede cambiarse.
	public void setVuelo(Vuelo nuevoVuelo) {
		
	}
}
