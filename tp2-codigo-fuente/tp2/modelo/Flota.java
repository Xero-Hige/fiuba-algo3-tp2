package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

// Una flota es un grupo de naves militares. La misma puede dar órdenes a todos 
// sus miembros cuando sea necesario.
public class Flota implements IGuardable {

	private NaveMilitar naveGuia;
	private List<NaveMilitar> navesMilitares;
	private Point direccionDeRetirada;
	private boolean navesEnRetirada;
	private boolean navesDisparando;

	// Constructor
	// Inicializa una flota con la nave guía recibida.
	public Flota(NaveMilitar naveGuia) {
		if (naveGuia != null) {
			if (naveGuia.getEquipo() == null) {
				throw new NaveEnemigaALaFlota(
						"La nave guía debe pertenecer a un equipo");
			}
		}
		navesMilitares = new ArrayList<NaveMilitar>();
		this.setNaveGuia(naveGuia);
		this.agregarNave(naveGuia);
	}

	// Agrega la nave a la flota (si ya se encontraba, se ignora el mensaje). Si
	// la nave no pertencece al mismo equipo que la guía, se levanta una
	// excepción.
	public void agregarNave(NaveMilitar unaNaveMilitar) {
		if (unaNaveMilitar.getEquipo() != naveGuia.getEquipo()) {
			throw new NaveEnemigaALaFlota(
					"La flota no puede tener naves de distinto equipo");
		}
		if (navesMilitares.indexOf(navesMilitares) == -1) {
			navesMilitares.add(unaNaveMilitar);
		}
		if(unaNaveMilitar != this.naveGuia){
			this.DarOrdenesALaNave(unaNaveMilitar);
		}
	}

	protected void DarOrdenesALaNave(NaveMilitar unaNaveMilitar) {
		if(this.navesEnRetirada){
			this.darOrdenDeRetirada(unaNaveMilitar, this.direccionDeRetirada);
		}
		if(this.navesDisparando){
			this.iniciarFuegoDeLaNave(unaNaveMilitar);
		} else {
			this.detenerFuegoDeLaNave(unaNaveMilitar);
		}
	}
	
	protected void darOrdenDeRetirada(NaveMilitar nave, Point direccion) {
		VueloEnLineaRecta vuelo = new VueloEnLineaRecta(nave, direccion);
		nave.setVuelo(vuelo);
		nave.detenerFuego();
		if(!nave.getEscenario().getAreaDeCombate().contains(nave.getPosicion())){
			if(!nave.estaDestruido()){
				nave.desaparecerDelEscenario();
			}
		}
	}
	
	public void iniciarFuego(){
		this.navesDisparando = true;
		Iterator<NaveMilitar> iter = navesMilitares.iterator();
		while (iter.hasNext()) {
			NaveMilitar nave = iter.next();
			nave.iniciarFuego();
		}
	}
	
	public void iniciarFuegoDeLaNave(NaveMilitar nave){
		if(!this.navesMilitares.contains(nave)){
			throw new ObjetoDesconocido("La nave no pertenece a la flota.");
		}
		nave.iniciarFuego();
	}
	
	public void detenerFuego() {
		this.navesDisparando = false;
		Iterator<NaveMilitar> iter = navesMilitares.iterator();
		while (iter.hasNext()) {
			NaveMilitar nave = iter.next();
			nave.detenerFuego();
		}
	}
	
	public void detenerFuegoDeLaNave(NaveMilitar nave){
		if(!this.navesMilitares.contains(nave)){
			throw new ObjetoDesconocido("La nave no pertenece a la flota.");
		}
		nave.detenerFuego();
	}

	// Ordena a los aviones de la flota detener sus disparos y huir en la
	// direccion recibida.
	public void iniciarRetiradaEnDireccion(Point unaDireccion) {
		this.direccionDeRetirada = unaDireccion;
		this.navesEnRetirada = true;
		Iterator<NaveMilitar> iter = navesMilitares.iterator();
		while (iter.hasNext()) {
			NaveMilitar nave = iter.next();
			this.darOrdenDeRetirada(nave, this.direccionDeRetirada);
		}
	}

	private void setNaveGuia(NaveMilitar naveGuia) {
		this.naveGuia = naveGuia;
	}

	public NaveGuia getNaveGuia() {
		return (NaveGuia) this.naveGuia;
	}

	public List<NaveMilitar> getNaves() {
		return this.navesMilitares;
	}

	@Override
	public Element guardar(Element contenedor) {

		contenedor.appendChild(GeneradorXml.generarElementoDe(naveGuia,
				"naveGuia"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(navesMilitares,
				"navesMilitares"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {

		this.naveGuia = (NaveMilitar) ReconstructorDesdeXml
				.generarObjeto(atributos.get("naveGuia"));
		this.navesMilitares = (List<NaveMilitar>) ReconstructorDesdeXml
				.generarObjeto(atributos.get("navesMilitares"));
		return this;
	}

}
