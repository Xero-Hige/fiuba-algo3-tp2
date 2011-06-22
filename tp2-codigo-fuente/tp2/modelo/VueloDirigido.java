package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ComposicionIncompleta;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Es un vuelo direccionable que persigue un objeto del espacio (incluso los 
// móviles).
public class VueloDirigido extends VueloDireccionable {

	// El objeto perseguido por el vuelo.
	private ObjetoEspacial objetivo;

	// Constructor
	// Inicializa un vuelo direccionable del objeto volador recibido, con el
	// objetivo de destino dado.
	public VueloDirigido(ObjetoVolador unObjetoVolador, ObjetoEspacial objetivo) {
		super(unObjetoVolador, objetivo.getPosicion());
		this.objetivo = objetivo;
	}
	
	public VueloDirigido() {
		super();
	}

	// Avanza el vuelo durante el tiempo indicado, dirigiéndose hacia la
	// posición del objetivo. Devuelve el desplazamiento del vuelo. Si el vuelo
	// no fue iniciado, o si no se conoce al objetivo, se levanta una excepción.
	public Point avanzarDurante(double unTiempo) {
		if (objetivo == null) {
			throw new ComposicionIncompleta(
					"No se conoce el objetivo del vuelo dirigido.");
		}
		Point posicionRelativa = objetivo.getPosicion().sumarCon(
				this.getObjetoVolador().getPosicion().getOpuesto());
		this.setDireccion(posicionRelativa);
		Point desplazamiento = super.avanzarDurante(unTiempo);
		if(posicionRelativa.radio() < desplazamiento.radio()){
			return posicionRelativa;
		}
		return desplazamiento;
	}

	public ObjetoEspacial getObjetivo() {
		return this.objetivo;
	}

	// Cambia el objetivo del vuelo para que se dirija al objeto recibido.
	public void setObjetivo(ObjetoEspacial objetivo) {
		this.objetivo = objetivo;
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(objetivo, "objetivo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.objetivo = (ObjetoEspacial) ReconstructorDesdeXml.generarObjeto(atributos.get("objetivo"));
		return this;
	}
}
