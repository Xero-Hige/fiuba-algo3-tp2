package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Una nave militar es una nave que tiene un cierto número de armas (pero una sola 
// del mismo tipo).
public class NaveMilitar extends Nave {

	// las armas de la nave, la cual puede activarlas para que disparen o 
	// desactivarlas cuando desee.
	private List<Arma> armas;
	private boolean enCombate;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad y energía recibidos. La agrega al escenario.
	public NaveMilitar(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		this.armas = new ArrayList<Arma>();
		this.enCombate = true;
	}
	
	public NaveMilitar() {
		super();
	}

	@Override
	// Ordena a la nave Militar actuar en el escenario durante el tiempo específicado.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.desaparecerDelEscenario();
			return;
		}
		if(this.enCombate == false){
			if(this.getEscenario().getAreaDeCombate().contains(this.getPosicion())){
				this.desaparecerDelEscenario();
				return;
			}
		}
		if (unTiempo <= 0) return;
		Set<ObjetoEspacial> objetosChocados = this.getEscenario().getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> iterador = objetosChocados.iterator();
		while(iterador.hasNext()){
			this.chocarCon(iterador.next());
		}
		this.moverDurante(unTiempo);
	}
	
	// Agrega el arma a la nave. Si la misma ya tiene un arma del mismo tipo (igual 
	// identificación), solamente carga la ya existente con los proyectiles que la 
	// otra tenga. Si el arma no tiene identificación, entonces se levanta una 
	// excepción.
	public void agregarArma(Arma unArma) {
		String id = unArma.getIdentificacion(); 
		if (id == null){
			throw new ObjetoDesconocido("No se conoce el tipo del arma (no tiene identificación)");
		}
		Iterator<Arma> iter = this.armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next(); 
			if (arma.getIdentificacion() == id){
				if(!unArma.getCarga().toString().equals("Infinity")){
					arma.cargarCon(new Integer(unArma.getCarga().toString()));
				}
				return;
			}
		}
		unArma.setEquipo(this.getEquipo());
		unArma.setEscenario(this.getEscenario());
		this.armas.add(unArma);
		unArma.setPosicion(this.getPosicion());
		unArma.setNaveDuenia(this);
		
	}
	
	// La nave ordena a sus armas que frenen sus disparos.
	public void detenerFuego() {
		Iterator<Arma> iter = armas.iterator();
		while (iter.hasNext()){
			iter.next().frenarDisparos();
		}
	}
	
	// La nave acciona sus armas para que estas comiencen sus disparos.
	public void iniciarFuego() {
		Iterator<Arma> iter = armas.iterator();
		while (iter.hasNext()){
			iter.next().comenzarDisparos();
		}
	}
	
	// Devuelve un hash de las armas de la nave, con su identificación como clave 
	// y el arma en sí como valor.
	public List<Arma> getArmas() {
		return this.armas;
	}
	
	public boolean estaEnCombate(){
		return this.enCombate;
	}
	
	public void quitarDeCombate(){
		this.enCombate = false;
	}
	
	@Override
	// Hace sufrir al objeto recibido los efectos de chocar una nave militar, 
	// según su comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeNaveMilitar(this);
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(armas, "armas"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.armas = (List<Arma>) ReconstructorDesdeXml.generarObjeto(atributos.get("armas"));
		return this;
	}
}
