package tp2.modelo;

import tp2.auxiliares.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Clase abstracta. Define cómo debe comportarse un bono, pero esta clase no tiene 
// ningún método concreto (salvo getters y setters). Cada tipo de bono debe heredar 
// de esta clase y definir el comportamiento del bono al usarse.
public abstract class Bono extends ObjetoVolador {

	private NaveMilitar naveDuenia;
	
	// Constructor
	// Inicializa el bono con el tamaño recibido.
	public Bono(double tamanio) {
		super(null, tamanio, null, 0);
		naveDuenia = null;
		Vuelo vueloDelBono = new VueloEnLineaRecta(this,new Point (0,-1));
		this.setVuelo(vueloDelBono);
		this.setVelocidad(1);
		
	}
		
	public Bono() {
		super();
	}

	// Hace actuar al objeto volador en el escenario durante el tiempo específicado, 
	// haciendo que el mismo vuele durante ese tiempo. Si no tiene escenario o vuelo,
	// se levanta una excepción.
	public void actuarDurante(double tiempo) {
		if (this.estaDestruido()){
			this.desaparecerDelEscenario();
			return;
		}
		if (tiempo <= 0) return;
		Set<ObjetoEspacial> objetosChocados = this.getEscenario().getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> iterador = objetosChocados.iterator();
		while(iterador.hasNext()){
			this.chocarCon(iterador.next());
			}
		this.moverDurante(tiempo);
	}

	// En su implementación, el bono receptor debe darle a la nave la bonificación 
	// que tenga y luego autodestruirse (cada bono se usa una sola vez).
	public abstract void entregarBonoA(NaveMilitar unaNave);
	
	// Devuelve si el bono ya ha sido usado previamente.
	public boolean fueUsado() {
		return this.estaDestruido();
	}
	
	// Hace sufrir al objeto recibido los efectos de chocar un bono, según su 
	//comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeBono(this);
	}
	
	public NaveMilitar getNaveDuenia() {
		return naveDuenia;
	}
	
	// Asigna al bono la nave enemiga que es dueño del mismo.
	public void setNaveDuenia(NaveMilitar nuevaNaveDuenia) {
		naveDuenia = nuevaNaveDuenia;
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(naveDuenia, "naveDuenia"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.naveDuenia = (NaveMilitar) ReconstructorDesdeXml.generarObjeto(atributos.get("naveDuenia"));
		return this;
	}
}
