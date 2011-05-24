package tp2.modelo;

import java.util.Iterator;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;


// Es una nave militar la cual permite ser controlada externamente. Se le puede 
// ordenar que se empiece a mover en una dirección o que se detenga, que accione 
// un arma o detenga sus disparos.
public class NaveMilitarControlada extends NaveMilitar {

	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad y energía recibidos. La agrega al escenario.
	public NaveMilitarControlada(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		Vuelo vueloControlado = new VueloDireccionable(this,new Point(0,0));
		vuelo = vueloControlado;
		comportamientoAlChocar = new ChoqueDeNaveMilitarControlada(this);
	}
	
	// Recibe la identificación del arma que se desea disparar. Si no existe dicha 
	// arma, se levanta una excepción.
	public void iniciarFuegoConArmaDeId(String unaIdentificacion) {
		
		Iterator<Arma> iter = this.armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next(); 
			if (arma.getIdentificacion() == unaIdentificacion){
				arma.comenzarDisparos();
				return;
			}
		}
		throw new ObjetoDesconocido("No se conoce el tipo del arma (no tiene identificación)");
	}
	
	// Recibe la identificación del arma que se desea dejar de disparar. Si no 
	// existe dicha arma, se levanta una excepción.
	public void detenerFuegoConArmaDeId(String unaIdentificacion) {
		
		Iterator<Arma> iter = this.armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next(); 
			if (arma.getIdentificacion() == unaIdentificacion){
				arma.frenarDisparos();
				return;
			}
		}
		throw new ObjetoDesconocido("No se conoce el tipo del arma (no tiene identificación)");
	}
	
	// Cambia la dirección de la nave a la especificada. Si se desea que la nave se 
	// quede quieta, debe recibirse la dirección (0,0).
	public void setDireccionDeVuelo(Point nuevaDireccion) {
		
	}
	
	@Override
	// El vuelo de una nave controlada no puede cambiarse.
	public void setVuelo(Vuelo nuevoVuelo) {
		return;
	}
}
