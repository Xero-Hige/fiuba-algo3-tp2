package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Cada misión tendrá configurado las preferencias del nivel (aeronaves en sus
// respectivas flotas, el jugador, el escenario en donde interactuan). 	r
public class Mision implements IGuardable {

	private Escenario escenario;
	private NaveMilitarControlada naveDelJugador;
	private FabricaDeNaves fabricaJugador, fabricaEnemiga;
	private Flota flotaEnemiga, flotaAliada;
	private Jugador jugador;
	private Map<Double, Collection<ParCadenaPosicion>> navesPorTiempoDeSpawn;
	private PriorityQueue<Double> tiemposDeSpawn;
	private double tiempoActual;

	
	// Constructor
	public Mision(Escenario escenario) {
		
		this.escenario = escenario;
		this.fabricaEnemiga = new FabricaDeNaves(this.escenario,
				"EquipoEnemigo", null);
		this.flotaEnemiga = this.nuevaFlotaEnemiga();
		this.fabricaJugador = new FabricaDeNaves(this.escenario,
				"EquipoJugador", flotaEnemiga);
		this.naveDelJugador = this.nuevaNaveDelJugador();
		this.flotaAliada = new Flota(this.naveDelJugador);
		this.fabricaEnemiga.setFlotaEnemiga(this.flotaAliada);
		this.getEscenario().agregarObjeto(this.flotaEnemiga.getNaveGuia());
		this.tiempoActual = 0;
	}
	
	public Mision() {
		super();
	}

	private NaveMilitarControlada nuevaNaveDelJugador() {
		
		Point posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), ValoresDeNaves.algo42Tamanio * 2);
		
		NaveMilitarControlada naveDelJugador = this.fabricaJugador
				.crearAlgo42En(posicion);
		
		return naveDelJugador;
	}

	private Flota nuevaFlotaEnemiga() {
		
		Point posicion = new Point(this.escenario.getAreaDeCombate()
				.getCenterX(), this.escenario.getAreaDeCombate().getHeight()
				+ ValoresDeNaves.guiaEnemigoVueloLineaRectaLongitudTrayectoria
				- ValoresDeNaves.guiaEnemigoTamanio * 3);
		
		NaveGuia naveGuia = this.fabricaEnemiga.crearGuiaEnemigoEn(posicion);
		
		return naveGuia.getFlota();
	}

	// Genera una misión a partir de la colección de datos recibida. La clave es
	// el tiempo en que se pretende crear una nave, y el valor es una colección
	// de pares cadena-posición, cuya cadena indica cuál es la nave a ser creada
	public void generar(Map<Double, Collection<ParCadenaPosicion>> datos) {
		
		this.navesPorTiempoDeSpawn = datos;
		this.tiemposDeSpawn = new PriorityQueue<Double>(datos.keySet());
	}

	// Hace avanzar el tiempo en el escenario del juego. Si se llegó a los 1000
	// puntos, se avanza al siguiente nivel. Si se destruyó al guía enemigo, se
	// inicia una nueva ronda, mientras las naves de la flota anterior viajan
	// abandonando elescenario.
	public void simularDurante(double unTiempo) {
		if(this.flotaEnemiga.getNaveGuia().estaDestruido()){
			this.flotaEnemiga = this.nuevaFlotaEnemiga();
			this.tiempoActual = 0;
			this.generar(this.navesPorTiempoDeSpawn);
		}
		this.hacerAparecerNaves();
		this.tiempoActual += unTiempo;
		this.escenario.avanzarTiempoEn(unTiempo);
	}

	private void hacerAparecerNaves() {
		Double proximoTiempoDeSpawn = this.tiemposDeSpawn.peek();
		
		while((proximoTiempoDeSpawn != null) && (this.tiempoActual >= proximoTiempoDeSpawn)){
			
			double tiempo = this.tiemposDeSpawn.poll();
			for(ParCadenaPosicion datoDeNaves: navesPorTiempoDeSpawn.get(tiempo)){
				Collection<Nave> naves = ParserDeNaves.fabricarNave(datoDeNaves, fabricaEnemiga, flotaEnemiga);
				for(Nave nave: naves){
					this.escenario.agregarObjeto(nave);
				}
			}
			proximoTiempoDeSpawn = this.tiemposDeSpawn.peek();
		}
	}

	public Escenario getEscenario() {
		return escenario;
	}

	public Jugador getJugador() {
		return this.jugador;
	}

	public void setJugador(Jugador nuevoJugador) {
		this.jugador = nuevoJugador;
	}

	public NaveMilitarControlada getNaveDelJugador() {
		return naveDelJugador;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		contenedor.appendChild(GeneradorXml.generarElementoDe(escenario,"escenario"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(naveDelJugador,"naveDelJugador"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(flotaEnemiga,"flotaEnemiga"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(flotaAliada,"flotaAliada"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(jugador,"jugador"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(navesPorTiempoDeSpawn,"navesPorTiempoDeSpawn"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tiemposDeSpawn,"tiemposDeSpawn"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tiempoActual,"tiempoActual"));
		
		return contenedor;
	}

	@SuppressWarnings("unchecked")
	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		this.jugador = (Jugador) ReconstructorDesdeXml.generarObjeto(atributos.get("jugador"));
		this.naveDelJugador = (NaveMilitarControlada) ReconstructorDesdeXml.generarObjeto(atributos.get("naveDelJugador"));
		this.flotaEnemiga = (Flota) ReconstructorDesdeXml.generarObjeto(atributos.get("flotaEnemiga"));
		this.flotaAliada = (Flota) ReconstructorDesdeXml.generarObjeto(atributos.get("flotaAliada"));
		this.escenario = (Escenario) ReconstructorDesdeXml.generarObjeto(atributos.get("escenario"));
		this.navesPorTiempoDeSpawn = (Map<Double, Collection<ParCadenaPosicion>>) ReconstructorDesdeXml.generarObjeto(atributos.get("navesPorTiempoDeSpawn"));
		this.tiemposDeSpawn = (PriorityQueue<Double>) ReconstructorDesdeXml.generarObjeto(atributos.get("tiemposDeSpawn"));
		this.tiempoActual = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("tiempoActual"));
		this.fabricaJugador = new FabricaDeNaves(this.escenario, "EquipoJugador", null);
		this.fabricaEnemiga = new FabricaDeNaves(this.escenario, "EquipoEnemigo", this.flotaAliada);
		
		return this;
	}
}
