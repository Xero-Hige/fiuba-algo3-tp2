package tp2.modelo;

import java.util.*;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

// Es una nave militar que además, al ser destruída, aumenta la puntuación del 
// escenario y opcionalmente tira un bono en el mismo.
public class NaveEnemiga extends NaveMilitar {

	// La puntuación por destrucción de la nave.
	private double puntuacion;
	// El bono que brinda al ser destruída (si tiene).
	private Bono bono;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado, armas ni bono y puntuación nula, 
	// con la posición, tamaño, escenario, velocidad y energía recibidos. La agrega 
	// al escenario.
	public NaveEnemiga(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		bono = null;
		puntuacion = 0;
	}
	
	@Override
	// Ordena a la nave enemiga actuar en el escenario durante el tiempo 
	// específicado.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.getEscenario().modificarPuntuacionEn((int)puntuacion);
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
	
	// Destruye la nave y le impide realizar acciones en el futuro. Además, 
	// posiciona al bono en el escenario, en el lugar donde la nave acaba de ser 
	// destruída.
	public void destruir() {
		super.destruir();
		if (bono != null){
			bono.setPosicion(this.getPosicion());
			bono.setEscenario(this.getEscenario());
		}
	}
	
	// Cambia el bono de la nave.
	public void setBono(Bono unBono) {
		bono = unBono;
		bono.setNaveDuenia(this);
	}
	
	// Devuelve la puntuación por destrucción de esta nave.
	public double getPuntuacion() {
		return this.puntuacion;
	}
	
	// Recibe la penalización por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepción).
	public void setPuntuacion(double unaPuntuacion) {
		if (unaPuntuacion < 0){
			throw new ValorInvalido ("La puntuación no puede ser negativa");
		}
		puntuacion = unaPuntuacion;
	}
}
