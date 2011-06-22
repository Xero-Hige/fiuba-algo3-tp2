package tp2.modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Es una nave guía que sabe controlar una flota, y comunicarse directamente con 
// ella.
public class NaveGuia extends NaveMilitar {
	
	// La flota controlada por la nave.
	private Flota flota;
	private ComandoDeNaves comando;
	
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad, energía y equipo recibidos. La agrega al escenario y 
	// le asigna una nueva flota.
	public NaveGuia(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		this.setEquipo("");
		this.flota = new Flota(this);
	}
	
	public NaveGuia() {
		super();
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo específicado.
	public void actuarDurante(double unTiempo) {
		this.comando.comandarNaves();
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.desaparecerDelEscenario();
			return;
		}
		if (unTiempo <= 0) return;
		Set<ObjetoEspacial> objetosChocados = this.getEscenario().getObjetosEnColisionCon(this);
		Iterator<ObjetoEspacial> iterador = objetosChocados.iterator();
		while(iterador.hasNext()){
			this.chocarCon(iterador.next());
			}
		this.moverDurante(unTiempo);
	}
	
	public Flota getFlota() {
		return this.flota;
	}
	
	public void setComando(ComandoDeNaves comando) {
		this.comando = comando;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(flota, "flota"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(comando, "comando"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.flota = (Flota) ReconstructorDesdeXml.generarObjeto(atributos.get("flota"));
		this.comando = (ComandoDeNaves) ReconstructorDesdeXml.generarObjeto(atributos.get("comando"));
		return this;
	}

}
