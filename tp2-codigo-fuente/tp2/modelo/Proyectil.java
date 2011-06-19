package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Un proyectil es capaz de dañar naves no aliadas al impactar con ellas en el escenario.
public class Proyectil extends ObjetoVolador implements Cloneable {

	// El daño por impacto del proyectil.
	private double danio;

	// Constructor
	// Inicializa el proyectil sin un vuelo asignado, con la posición, tamaño,
	// velocidad y daño recibidos.
	public Proyectil(Point posicion, double tamanio, double velocidad, double danio) {
		super(posicion, tamanio, null, velocidad);
		this.danio = danio;
		this.setComportamiento(new ChoqueDeProyectil(this));
	}

	@Override
	// Simple Cloning parcial del objeto. Genera una copia de un modelo de
	// proyectil (sin vuelo asignado).
	public Proyectil clone() {

		if (this.getVuelo() != null) {
			throw new VueloAsignado(
					"Sólo se pueden clonar proyectil que no tienen un vuelo definido.");
		}

		Proyectil clone = null;

		try {
			clone = (Proyectil) super.clone();
		} catch (CloneNotSupportedException e) {
		}

		clone.setComportamiento(new ChoqueDeProyectil(clone));

		return clone;
	}

	@Override
	// Hace actuar al objeto volador en el escenario durante el tiempo
	// específicado, haciendo que el mismo vuele durante ese tiempo. Si no tiene
	// escenario o vuelo, se levanta una excepción.
	public void actuarDurante(double unTiempo) {

		if (this.estaDestruido()) {
			this.desaparecerDelEscenario();
			return;
		}

		if (unTiempo <= 0)
			return;

		Set<ObjetoEspacial> objetosChocados;

		objetosChocados = (this.getEscenario()).getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> objetosChocadosIterator = objetosChocados
				.iterator();

		while (objetosChocadosIterator.hasNext())
			this.chocarCon(objetosChocadosIterator.next());

		this.moverDurante(unTiempo);
	}

	@Override
	// Hace sufrir al objeto recibido los efectos de chocar un proyectil, según
	// su comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {

		unObjetoEspacial.getComportamiento().sufrirChoqueDeProyectil(this);
	}

	public double getDanio() {
		return this.danio;
	}

	// Cambia el daño del proyectil a un nuevo valor mayor o igual a cero. Si se
	// recibe un daño negativo, entonces se levanta una excepción.
	public void setDanio(double nuevoDanio) {

		if (nuevoDanio < 0)
			throw new ValorInvalido("No se puede asignar un daño negativo.");

		this.danio = nuevoDanio;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(danio, "danio"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.danio = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("danio"));
		return this;
	}

}
