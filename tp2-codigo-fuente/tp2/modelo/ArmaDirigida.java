package tp2.modelo;

import java.util.Iterator;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

/** Es un arma limitada, que puede configurarse para disparar contra una flota 
* enemiga. Al momento de disparar (si la flota enemiga está definida) se dispara 
* contra una nave al azar de dicha flota. Si no hay ninguna nave que atacar, el 
* proyectil sale en la dirección en la cual apunta el arma.*/
public class ArmaDirigida extends ArmaLimitada {

	private Flota flotaObjetivo;
	
	// Constructor
	// Inicializa el arma con la posición, escenario, velocidad de disparo, 
	// frecuencia de disparo, dirección de disparo y la identificación recibidos. La 
	// carga inicial es cero y no hay objetivo asignado
	public ArmaDirigida(Point posicion, Escenario escenario, int velocidad, double frecuencia, Point direccion, String id) {
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
		
		flotaObjetivo = null;
	}
	
	public ArmaDirigida() {
		super();
	}
	
	public Flota getFlotaObjetivo() {
		return this.flotaObjetivo;
	}
	
	// Cambia la flota objetivo a la que va a disparar el arma.
	public void setFlotaObjetivo(Flota nuevaFlotaObjetivo) {
		this.flotaObjetivo = nuevaFlotaObjetivo;
	}
	
	@Override
	// "Dispara el arma en la dirección hacia la cual apunta, o hacia alguna nave de
	// la flota objetivo (si es que queda alguna sin destruir) y agrega el proyectil
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {	
		
		Vuelo vuelo;
		Proyectil proyectilDisparado;
		NaveMilitar potencialObjetivo;
		
		proyectilDisparado = super.disparar();
		
		
		// Ahora tenemos un proyectil sin objetivo. Hay que ver si podemos 
		// encontrar alguna nave sin destruir en la flota y dirigirle el 
		// proyectil.
		
		if (this.flotaObjetivo != null) {
			
			Iterator<NaveMilitar> navesFlotaObjetivoIterator = this.flotaObjetivo.getNaves().iterator();
			
			while (navesFlotaObjetivoIterator.hasNext()) {
				
				potencialObjetivo = navesFlotaObjetivoIterator.next();
				
				if(! potencialObjetivo.estaDestruido()){
					vuelo = new VueloDirigido(proyectilDisparado, potencialObjetivo);
					proyectilDisparado.setVuelo(vuelo);
					return proyectilDisparado;
				}
			}
		}
		
		return proyectilDisparado;		
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(flotaObjetivo, "flotaObjetivo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.flotaObjetivo = (Flota) ReconstructorDesdeXml.generarObjeto(atributos.get("flotaObjetivo"));
		return this;
	}
}
