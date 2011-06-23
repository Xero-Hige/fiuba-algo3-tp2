package tp2.modelo;

import java.awt.Rectangle;
import java.util.*;
import java.util.Map.Entry;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.modelo.excepciones.ObjetoDesconocido;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

/** El escenario es el lugar en donde viven todos los objetos espaciales que 
* pueden actuar e interactuar entre sí. Un objeto de esta clase puede simular 
* la vida de dichos objetos a lo largo del tiempo, y ellos a la vez pueden 
* comunicarse con él.*/

public class Escenario implements IGuardable {

	// Es el área rectangular asignada de combate.
	private Rectangle areaDeCombate;
	// los objetos tienen un id para interactuar entre sí en un único sentido
	// (y que no existan colisiones dobles).
	private int proximoId;
	// Es un diccionario, que tiene como clave a los objetos y como valor el id
	// del mismo.
	private Map<ObjetoEspacial, Integer> objetos;
	// La puntuación lograda en dicho escenario.
	private int puntuacion;
	private double tiempo;

	private Collection<ObjetoEspacial> objetosCreados;
	private Collection<ObjetoEspacial> objetosMuertos;

	// Constructor
	// Crea un nuevo escenario cuya área de combate está definida por el
	// rectángulo recibido.
	public Escenario(Rectangle areaDeCombate){
		objetos = new HashMap<ObjetoEspacial, Integer>();
		this.proximoId = 1;
		this.puntuacion = 0;
		this.areaDeCombate = areaDeCombate;
		this.tiempo = 0;
		this.objetosCreados = new HashSet<ObjetoEspacial>();
		this.objetosMuertos = new HashSet<ObjetoEspacial>();
	}
	
	public Escenario() {
		super();
	}

	// Agrega un objeto al escenario, el cual ya tiene asignado dicho escenario.
	// El mismo debe estar preparado para actuar cuando sea necesario, de lo
	// contrario se corre el riesgo de que se levante una excepción en el
	// futuro. Si el objeto no tiene asignado este escenario, entonces se
	// levanta una excepción. Si el objeto ya estaba agregado al escenario, no
	// pasa nada.
	public void agregarObjeto(ObjetoEspacial unObjetoEspacial) {
		if (unObjetoEspacial.getEscenario() != this) {
			throw new ObjetoDesconocido(
					"El objeto no tiene asignado este escenario.");
		}
		if (objetos.containsKey(unObjetoEspacial)) {
			return;
		}
		objetos.put(unObjetoEspacial, proximoId);
		objetosCreados.add(unObjetoEspacial);
		proximoId++;
	}

	// Borra definitivamente al objeto del escenario. Si el objeto no tiene
	// asignado este escenario, entonces se levanta una excepción.
	public void borrarObjeto(ObjetoEspacial unObjetoEspacial) {
		if (objetos.containsKey(unObjetoEspacial)) {
			objetos.remove(unObjetoEspacial);
			objetosMuertos.add(unObjetoEspacial);
		} else {
			throw new ObjetoDesconocido(
					"El objeto no tiene asignado este escenario.");
		}
	}

	// Devuelve si el objeto recibido se encuentra en el escenario.
	public boolean contieneObjeto(ObjetoEspacial unObjetoEspacial) {
		return objetos.containsKey(unObjetoEspacial);
	}

	// Devuelve si el objeto se encuentra dentro del área de combate.
	public boolean tieneEnCombateA(ObjetoEspacial unObjetoEspacial) {
		return areaDeCombate.contains(unObjetoEspacial.getPosicion());
	}

	// Hace que avance el tiempo, y le ordena a todos los objetos
	// pertenecientes al escenarios que actúen durante dicho tiempo. En el caso
	// que algún objeto no tenga pueda actuar y tire una excepción, se levantará
	// la misma.
	public void avanzarTiempoEn(double unTiempo) {
		this.tiempo += unTiempo;
		Set<ObjetoEspacial> objetos = new HashSet<ObjetoEspacial>(
				this.objetos.keySet());
		for (ObjetoEspacial objeto : objetos) {
			objeto.actuarDurante(unTiempo);
		}
	}

	// Agrega o quita (si la diferencia es negativa) la cantidad de puntos
	// recibida a la puntuación actual del escenario. La puntuación se mantiene
	// mínimamente en cero.
	public void modificarPuntuacionEn(int unaDiferencia) {
		this.puntuacion += unaDiferencia;
		if (this.puntuacion < 0) {
			this.puntuacion = 0;
		}
	}

	public double getTiempo() {
		return tiempo;
	}

	public int getPuntuacion() {
		return puntuacion;
	}

	public Set<ObjetoEspacial> getObjetos() {
		return objetos.keySet();
	}

	// Recibe la referencia a un objeto del escenario. Devuelve una colección
	// de aquellos otros objetos que están colisionando con el mismo y que
	// fueron agregados al escenario después de este (es decir, detecta
	// colisiones en un solo sentido).
	public Set<ObjetoEspacial> getObjetosEnColisionCon(
			ObjetoEspacial unObjetoEspacial) {
		if (unObjetoEspacial.getEscenario() != this) {
			throw new ObjetoDesconocido(
					"El objeto no tiene asignado este escenario.");
		}
		int indiceDelObjeto = objetos.get(unObjetoEspacial);
		Set<ObjetoEspacial> objetosEnColision = new HashSet<ObjetoEspacial>();
		for (ObjetoEspacial objeto : objetos.keySet()) {
			if (objetos.get(objeto) > indiceDelObjeto) {
				if (unObjetoEspacial.estaSuperpuestoCon(objeto)) {
					objetosEnColision.add(objeto);
				}
			}
		}
		return objetosEnColision;
	}

	// Devuelve los objetos agregados al escenario después de la última consulta
	// a este método.
	public Collection<ObjetoEspacial> getObjetosCreados() {
		Collection<ObjetoEspacial> resultado = objetosCreados;
		objetosCreados = new HashSet<ObjetoEspacial>();
		return resultado;
	}

	// Devuelve los objetos borrados del escenario después de la última consulta
	// a este método.
	public Collection<ObjetoEspacial> getObjetosMuertos() {
		Collection<ObjetoEspacial> resultado = objetosMuertos;
		objetosMuertos = new HashSet<ObjetoEspacial>();
		return resultado;
	}

	public Rectangle getAreaDeCombate() {
		return areaDeCombate;
	}

	@Override
	public Element guardar(Element contenedor) {		
	
		contenedor.appendChild(GeneradorXml.generarElementoDe(objetos, "objetos"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(proximoId, "proximoId"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(puntuacion, "puntuacion"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(areaDeCombate, "areaDeCombate"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(tiempo, "tiempo"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(objetosCreados, "objetosCreados"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(objetosMuertos, "objetosMuertos"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		this.objetos = (Map<ObjetoEspacial, Integer>) ReconstructorDesdeXml.generarObjeto(atributos.get("objetos"));
		this.proximoId = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("proximoId"));
		this.puntuacion = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("puntuacion"));
		this.areaDeCombate = (Rectangle) ReconstructorDesdeXml.generarObjeto(atributos.get("areaDeCombate"));
		this.tiempo = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("tiempo"));
		this.objetosCreados = (Collection<ObjetoEspacial>) ReconstructorDesdeXml.generarObjeto(atributos.get("objetosCreados"));
		for(ObjetoEspacial objeto: objetos.keySet()){
			this.objetosCreados.add(objeto);
		}
		this.objetosMuertos = (Collection<ObjetoEspacial>) ReconstructorDesdeXml.generarObjeto(atributos.get("objetosMuertos"));
		
		return this;
	}	
}
