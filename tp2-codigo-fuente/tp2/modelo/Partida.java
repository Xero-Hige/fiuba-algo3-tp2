package tp2.modelo;

import java.awt.Rectangle;
import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.persistencia.ConstructorMisionDesdeXml;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Es la que permite generar un conjunto de misiones para ser jugadas.
// Al iniciarse una partida se van cargando misiones a medida que se superan estas
// y en caso de que el jugador pierda, la partida finaliza.
public class Partida implements IGuardable {

	private static final int TAMANO_DEL_ESCENARIO = 140;
	private Jugador jugador;
	private Mision misionActual;
	private int cantidadNiveles;
	private int nivelActual;
	private int vidas;

	private Boolean enCurso;
	
	
	//Constructor
	public Partida(int cantidadNiveles, int vidas) {
		this.cantidadNiveles = cantidadNiveles;
		this.nivelActual = 1;
		this.misionActual = this.generarMision();
		this.enCurso = false;
		this.vidas = vidas;
	}
	
	public Partida() {
		super();
	}
	
	// Inicia la partida para que pueda ser corrida.
	public void iniciar() {
		this.enCurso = true;
	}
	
	public void reanudar() {
		this.enCurso = true;
	}
	
	// Detiene la partida para que ya no pueda ser corrida. De no haberse
	// iniciado lanza una excepción del tipo PartidaNoIniciada.
	public void detener() {
		this.enCurso = false;
	}
	
	// Devuelve si la partida se ha iniciado y esta en curso.
	public Boolean estaEnCurso() {
		return this.enCurso;
	}
	
	// Devuelve si la partida ha sido ganada (se deben haber superado todas las
	// misiones).
	public Boolean estaGanada() {
		return this.nivelActual > this.cantidadNiveles;
	}
	
	public void avanzarNivel(){
		this.nivelActual++;
		if(!this.estaGanada()){
			this.misionActual = this.generarMision();
		} else {
			this.detener();
		}
	}

	private Mision generarMision() {
		Map<Double, Collection<ParCadenaPosicion>> datos = ConstructorMisionDesdeXml.datosMision(this.nivelActual);
		Mision mision = new Mision(new Escenario(new Rectangle(TAMANO_DEL_ESCENARIO, TAMANO_DEL_ESCENARIO)));
		mision.generar(datos);
		return mision;
	}

	public Mision getMisionActual() {
		return misionActual;
	}
	
	public int getNivelActual() {
		return nivelActual;
	}

	public int getVidas() {
		return vidas;
	}

	@Override
	public Element guardar(Element contenedor) {		
		contenedor.appendChild(GeneradorXml.generarElementoDe(jugador, "jugador"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(misionActual, "misionActual"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(cantidadNiveles, "cantidadNiveles"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(nivelActual, "nivelActual"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(vidas, "vidas"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(enCurso, "enCurso"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.jugador = (Jugador) ReconstructorDesdeXml.generarObjeto(atributos.get("jugador"));
		this.misionActual = (Mision) ReconstructorDesdeXml.generarObjeto(atributos.get("misionActual"));
		this.cantidadNiveles =(Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("cantidadNiveles"));
		this.nivelActual = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("nivelActual"));
		this.vidas = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("vidas"));
		this.enCurso = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("enCurso"));
		return this;
	}

	public void perderVida() {
		if(this.vidas > 0){
			this.vidas -= 1;
		}
		this.misionActual = this.generarMision();
	}
	
}
