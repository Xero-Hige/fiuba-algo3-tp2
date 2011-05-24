package tp2.modelo;

import java.util.*;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

// Una nave militar es una nave que tiene un cierto número de armas (pero una sola 
// del mismo tipo).
public class NaveMilitar extends Nave {

	// las armas de la nave, la cual puede activarlas para que disparen o 
	// desactivarlas cuando desee.
	protected List<Arma> armas;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad y energía recibidos. La agrega al escenario.
	public NaveMilitar(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		this.armas = new ArrayList<Arma>();
	}
	
	@Override
	// Ordena a la nave Militar actuar en el escenario durante el tiempo específicado.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.desaparecerDelEscenario();
			return;
		}
		if (unTiempo <= 0) return;
		Set<ObjetoEspacial> objetosChocados = this.getEscenario().getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> iterador = objetosChocados.iterator();
		while(iterador.hasNext()){
			this.chocarCon(iterador.next());
			}
		this.moverDurante(unTiempo);
	}
	
	// Agrega el arma a la nave. Si la misma ya tiene un arma del mismo tipo (igual 
	// identificación), solamente carga la ya existente con los proyectiles que la 
	// otra tenga. Si el arma no tiene identificación, entonces se levanta una 
	// excepción.
	public void agregarArma(Arma unArma) {
		String id = unArma.getIdentificacion(); 
		if (id == null){
			throw new ObjetoDesconocido("No se conoce el tipo del arma (no tiene identificación)");
		}
		Iterator<Arma> iter = this.armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next(); 
			if (arma.getIdentificacion() == id){
				arma.cargarCon(unArma.getCarga());
				return;
			}
		}
		unArma.setEquipo(this.getEquipo());
		unArma.setEscenario(this.getEscenario());
		this.armas.add(unArma);
		
	}
	
	// La nave ordena a sus armas que frenen sus disparos.
	public void detenerFuego() {
		Iterator<Arma> iter = armas.iterator();
		while (iter.hasNext()){
			iter.next().frenarDisparos();
		}
	}
	
	// La nave acciona sus armas para que estas comiencen sus disparos.
	public void iniciarFuego() {
		Iterator<Arma> iter = armas.iterator();
		while (iter.hasNext()){
			iter.next().comenzarDisparos();
		}
	}
	
	// Devuelve un hash de las armas de la nave, con su identificación como clave 
	// y el arma en sí como valor.
	public List<Arma> getArmas() {
		return this.armas;
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave militar, 
	// según su comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeNaveMilitar(this);
	}
}
