package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.VueloIniciado;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

public abstract class Vuelo implements IGuardable{

	private ObjetoVolador objetoVolador;
	private boolean iniciado;
	private Point origen;
	private double trayectoriaDeVuelo;

	// Inicializa un vuelo del objeto volador recibido.
	public Vuelo(ObjetoVolador objetoVolador) {
		super();
		this.objetoVolador = objetoVolador;
		this.iniciado = false;
		this.origen = null;
		this.trayectoriaDeVuelo = 0.0;
	}

	public ObjetoVolador getObjetoVolador() {
		return objetoVolador;
	}

	public boolean estaIniciado() {
		return iniciado;
	}

	public Point getOrigen() {
		return origen;
	}

	public double getTrayectoriaDeVuelo() {
		return trayectoriaDeVuelo;
	}

	protected void setTrayectoriaDeVuelo(double trayectoriaDeVuelo) {
		this.trayectoriaDeVuelo = trayectoriaDeVuelo;
	}

	// Inicia el vuelo con su origen en el lugar actual donde está posicionado
	// el objeto. Si el vuelo ya fue iniciado, se levanta una excepción.
	public void iniciar(){
		if (this.estaIniciado()) {
			throw new VueloIniciado("El vuelo ya fue iniciado anteriormente.");
		}
		this.origen = objetoVolador.getPosicion();
		this.iniciado = true;
	}

	// Avanza el vuelo según el tiempo recibido, calcula el desplazamiento de la
	// nave en dicho intervalo y devuelve el mismo. En cada reimplementación, si
	// el vuelo no ha iniciado, debe levantarse una excepción del tipo
	// VueloNoIniciado.
	public abstract Point avanzarDurante(double unTiempo);

	// Aumenta el valor de la trayectoria de vuelo de acuerdo al valor, que debe
	// ser mayor a cero, recibido.
	protected void aumentarTrayectoriaEn(double unaLongitud){
		this.trayectoriaDeVuelo = this.trayectoriaDeVuelo + unaLongitud;
	}

	@Override
	public Element guardar(Element contenedor) {
		contenedor.appendChild(GeneradorXml.generarElementoDe(objetoVolador, "objetoVolador"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(iniciado, "iniciado"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(origen, "origen"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(trayectoriaDeVuelo, "trayectoriaDeVuelo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.objetoVolador = (ObjetoVolador) ReconstructorDesdeXml.generarObjeto(atributos.get("objetoVolador"));
		this.iniciado = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("iniciado"));
		this.origen = (Point) ReconstructorDesdeXml.generarObjeto(atributos.get("origen"));
		this.trayectoriaDeVuelo = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("trayectoriaDeVuelo"));
		return this;
	}
}
