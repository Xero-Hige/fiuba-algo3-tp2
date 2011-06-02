package tp2.modelo;

import java.util.*;
import tp2.auxiliares.Point;

public class ArmaAdaptable extends Arma {

	private List<ArmaConProbabilidad> listaArmas;
	private Arma armaActual;
	private double tiempoRestanteCambioDeArma;
	private double frecuenciaDeCambioDeArma;
	private double pesoTotalDeProbabilidad;
	
	public ArmaAdaptable(Point posicion, Escenario escenario, int velocidad, double frecuencia, Point direccion, String id, double frecuenciaDeCambioDeArma) {
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
		
		// Listado de armas.
		this.listaArmas = new ArrayList<ArmaConProbabilidad>();
		// Frecuencia con la que se hace los cambios de arma.
		this.frecuenciaDeCambioDeArma = frecuenciaDeCambioDeArma;
		// Tiempo restante para el cambio de arma.
		this.tiempoRestanteCambioDeArma = 0;
		this.pesoTotalDeProbabilidad = 0;
	}

	public void agregarArma(ArmaConProbabilidad arma) {
		this.listaArmas.add(arma);
		this.pesoTotalDeProbabilidad += arma.getPesoProbabilidad();
	}

	public Arma getArmaActual() {
		return armaActual;
	}


	public double getTiempoRestanteCambioDeArma() {
		return tiempoRestanteCambioDeArma;
	}


	protected void setTiempoRestanteCambioDeArma(double tiempoRestanteCambioDeArma) {
		this.tiempoRestanteCambioDeArma = tiempoRestanteCambioDeArma;
	}


	public double getFrecuenciaDeCambioDeArma() {
		return frecuenciaDeCambioDeArma;
	}


	public void setFrecuenciaDeCambioDeArma(double frecuenciaDeCambioDeArma) {
		this.frecuenciaDeCambioDeArma = frecuenciaDeCambioDeArma;
	}
	
	
	

	
}
