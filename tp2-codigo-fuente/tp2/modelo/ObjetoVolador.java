package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

public abstract class ObjetoVolador extends Movil {

	private Vuelo vuelo;

	// Constructor
	// Inicializa el objeto volador sin un vuelo asignado, con la posición,
	// tamaño, escenario y velocidad recibidos. Lo agrega al escenario.
	public ObjetoVolador(Point posicion, double tamanio, Escenario escenario,
			double velocidad) {
		super(posicion, tamanio, escenario, velocidad);
		this.vuelo = null;
	}

	public ObjetoVolador() {
		super();
	}

	@Override
	// Mueve al objeto volador de acuerdo al tiempo recibido y el vuelo que
	// tenga. Si no tiene un vuelo definido o un escenario asignado, se
	// levanta una excepción.
	public void moverDurante(double unTiempo) {

		if (vuelo == null)
			throw new ComposicionIncompleta(
					"No se ha definido un vuelo para el objeto.");

		if (this.getEscenario() == null)
			throw new ComposicionIncompleta(
					"No se ha asignado un escenario al objeto.");

		if (!this.vuelo.estaIniciado())
			this.vuelo.iniciar();

		this.desplazarEn(this.vuelo.avanzarDurante(unTiempo));
	}

	public Vuelo getVuelo() {
		return this.vuelo;
	}

	// Asigna un nuevo Vuelo al objeto volador. De ahora en más, el objeto va a
	// volar de acuerdo a dicho vuelo en cada acción que realice.
	public void setVuelo(Vuelo nuevoVuelo) {
		this.vuelo = nuevoVuelo;
	}

	@Override
	public Element guardar(Element contenedor) {
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(vuelo, "vuelo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		super.cargar(atributos);
		this.vuelo = (Vuelo) ReconstructorDesdeXml.generarObjeto(atributos.get("vuelo"));
		return this;
	}
	
}
