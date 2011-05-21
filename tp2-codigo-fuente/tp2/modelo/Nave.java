package tp2.modelo;

import tp2.auxiliares.Point;

public class Nave extends ObjetoVolador {

	private double energia;

	// Inicializa la nave sin un vuelo asignado, con la posición, tamaño,
	// escenario, velocidad y energía recibidos. La agrega al escenario.
	public Nave(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad);
		this.energia = energia;
	}

	@Override
	// Ordena a la nave actuar durante el tiempo específicado. La nave debe
	// tener un vuelo y un escenario especificados, o de lo contrario se
	// levanta una excepción.
	public void actuarDurante(double unTiempo) {
		
	}

	// Disminuye la energía de la nave según el daño recibido. Si la energía llega a cero, la nave se destruye.
	public void recibirDanio(double unDanio) {
		this.energia -= unDanio;
		if(this.energia <= 0){
			this.destruir();
		}
	}
	
	// Aumenta la energia de la nave en la cantidad recibida (limitándola por 
	// la máxima energía que tiene). Dicha cantidad debe ser mayor a cero.
	public void recuperarEnergiaEn(double unTiempo) {
		
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave, según su 
	// comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	public double getEnergia() {
		return 0;
	}
	
	// Cambia el valor de la energía y máxima energía de la nave al valor 
	// recibido. La energía debe ser mayor a cero.
	public void setEnergia(double nuevaEnergia) {
		
	}
	
	public double getMaxEnergia() {
		return 0;
	}
}
