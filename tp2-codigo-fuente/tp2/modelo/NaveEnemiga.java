package tp2.modelo;

import java.util.*;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Es una nave militar que adem�s, al ser destru�da, aumenta la puntuaci�n del 
// escenario y opcionalmente tira un bono en el mismo.
public class NaveEnemiga extends NaveMilitar {

	// La puntuaci�n por destrucci�n de la nave.
	private int puntuacion;
	// El bono que brinda al ser destru�da (si tiene).
	private Bono bono;
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado, armas ni bono y puntuaci�n nula, 
	// con la posici�n, tama�o, escenario, velocidad y energ�a recibidos. La agrega 
	// al escenario.
	public NaveEnemiga(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		bono = null;
		puntuacion = 0;
	}
	
	public NaveEnemiga() {
		super();
	}
	
	@Override
	// Ordena a la nave enemiga actuar en el escenario durante el tiempo 
	// espec�ficado.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.getEscenario().modificarPuntuacionEn((int)puntuacion);
			this.desaparecerDelEscenario();
			return;
		}
		if(this.estaEnCombate() == false){
			if(!this.getEscenario().getAreaDeCombate().contains(this.getPosicion())){
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
	
	// Destruye la nave y le impide realizar acciones en el futuro. Adem�s, 
	// posiciona al bono en el escenario, en el lugar donde la nave acaba de ser 
	// destru�da.
	public void destruir() {
		super.destruir();
		if (bono != null){
			bono.setPosicion(this.getPosicion());
			bono.setEscenario(this.getEscenario());
		}
	}
	
	// Cambia el bono de la nave.
	public void setBono(Bono unBono) {
		bono = unBono;
		bono.setNaveDuenia(this);
	}
	
	// Devuelve la puntuaci�n por destrucci�n de esta nave.
	public int getPuntuacion() {
		return this.puntuacion;
	}
	
	// Recibe la penalizaci�n por destruir la nave, que debe ser mayor o igual a 
	// cero (sino se levanta una excepci�n).
	public void setPuntuacion(int unaPuntuacion) {
		if (unaPuntuacion < 0){
			throw new ValorInvalido ("La puntuaci�n no puede ser negativa");
		}
		puntuacion = unaPuntuacion;
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(puntuacion, "puntuacion"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(bono, "bono"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.puntuacion = (Integer) ReconstructorDesdeXml.generarObjeto(atributos.get("puntuacion"));
		this.bono = (Bono) ReconstructorDesdeXml.generarObjeto(atributos.get("bono"));
		return this;
	}
}
