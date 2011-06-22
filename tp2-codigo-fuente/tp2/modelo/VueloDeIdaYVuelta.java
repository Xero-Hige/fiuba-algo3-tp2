package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ValorInvalido;
import tp2.modelo.excepciones.VueloIniciado;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

/** Es un tipo particular de vuelo compuesto, en el cual el objeto volador vuela
* en línea recta hacia un destino relativo a la posición inicial, y luego 
* vuelve en sentido opuesto.*/
public class VueloDeIdaYVuelta extends VueloCompuesto{

	// Hacia dónde vuela (relativamente) el objeto.
	private Point destino;

	// Constructor
	// Inicializa un vuelo de ida vuelta del objeto volador recibido con destino
	// relativo no nulo.
	public VueloDeIdaYVuelta(ObjetoVolador unObjetoVolador,
			Point destinoRelativo) {
		super(unObjetoVolador);
		this.destino = destinoRelativo;
	}
	
	public VueloDeIdaYVuelta() {
		super();
	}

	@Override
	// Iniciar el vuelo.
	public void iniciar() {
		if (this.estaIniciado()) {
			throw new VueloIniciado("El vuelo ya fue iniciado anteriormente.");
		}
		Vuelo ida = new VueloEnLineaRecta(this.getObjetoVolador(), this.destino);
		Vuelo vuelta = new VueloEnLineaRecta(this.getObjetoVolador(),
				this.destino.getOpuesto());
		super.agregarVuelo(ida, destino.radio());
		super.agregarVuelo(vuelta, destino.radio());
		super.iniciar();
	}

	public Point getDestino() {
		return this.destino;
	}

	// Cambia el destino a una nueva posición relativa al objeto. Si el vuelo
	// ya comenzó o la posición relativa es nula, se levanta una excepción.
	public void setDestino(Point posicionRelativa) {
		if (this.estaIniciado()) {
			throw new VueloIniciado(
					"No se puede cambiar el destino del vuelo porque ya ha comenzado");
		}
		if (posicionRelativa.radio() == 0) {
			throw new ValorInvalido(
					"El destino relativo de vuelo no puede ser el nulo.");
		}
		this.destino = posicionRelativa;
	}

	@Override
	public void agregarVuelo(Vuelo vuelo, double longitudTrayectoria) {
		throw new UnsupportedOperationException("No se pueden agregar vuelos.");
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(destino, "destino"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.destino = (Point) ReconstructorDesdeXml.generarObjeto(atributos.get("destino"));
		return this;
	}	
}
