package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

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
	
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		
		contenedor.appendChild(GeneradorXml.generarElementoDe(listaArmas, "listaArmas"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(armaActual, "armaActual"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tiempoRestanteCambioDeArma, "tiempoRestanteCambioDeArma"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(frecuenciaDeCambioDeArma, "frecuenciaDeCambioDeArma"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(pesoTotalDeProbabilidad, "pesoTotalDeProbabilidad"));
		
		return contenedor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		
		this.listaArmas = (List<ArmaConProbabilidad>) ReconstructorDesdeXml.generarObjeto(atributos.get("listaArmas"));
		this.armaActual = (Arma) ReconstructorDesdeXml.generarObjeto(atributos.get("armaActual"));
		this.tiempoRestanteCambioDeArma = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("tiempoRestanteCambioDeArma"));
		this.frecuenciaDeCambioDeArma = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("frecuenciaDeCambioDeArma"));
		this.pesoTotalDeProbabilidad = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("pesoTotalDeProbabilidad"));
		
		return this;
	}

	
}
