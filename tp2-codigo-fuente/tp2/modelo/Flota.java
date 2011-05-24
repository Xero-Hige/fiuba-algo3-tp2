package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

import java.util.*;

// Una flota es un grupo de naves militares. La misma puede dar órdenes a todos 
// sus miembros cuando sea necesario.
public class Flota {

	private NaveGuia naveGuia;
	private List<NaveMilitar> navesMilitares;
	
	// Constructor
	// Inicializa una flota con la nave guía recibida.
	public Flota(NaveMilitar naveGuia){
		if (naveGuia != null){
			if (naveGuia.getEquipo() == null){
				throw new NaveEnemigaALaFlota("La nave guía debe pertenecer a un equipo");
			}
		}
		navesMilitares = new ArrayList<NaveMilitar>();
		this.setNaveGuia(naveGuia);
		this.agregarNave(naveGuia);
	}
		
	// Agrega la nave a la flota (si ya se encontraba, se ignora el mensaje). Si la 
	// nave no pertencece al mismo equipo que la guía, se levanta una excepción.
	public void agregarNave(NaveMilitar unaNaveMilitar){
		if(unaNaveMilitar.getEquipo() != naveGuia.getEquipo()){
			throw new NaveEnemigaALaFlota ("La flota no puede tener naves de distinto equipo");
			}
		if (navesMilitares.indexOf(navesMilitares) == -1){
			navesMilitares.add(unaNaveMilitar);
		}
	}
	
	// Ordena a los aviones de la flota detener sus disparos y huir en la direccion 
	// recibida.
	public void iniciarRetiradaEnDireccion(Point unaDireccion){
		Iterator<NaveMilitar> iter= navesMilitares.iterator();
		while (iter.hasNext()){
			NaveMilitar nave = iter.next();
			VueloEnLineaRecta vuelo = new VueloEnLineaRecta(nave,unaDireccion);
			nave.setVuelo(vuelo);
			nave.detenerFuego();
		}
	}
	
	private void setNaveGuia(NaveMilitar naveGuia){
		this.naveGuia = (NaveGuia) naveGuia;
	}
	
	public NaveGuia getNaveGuia(){
		return this.naveGuia;
	}
	
	public List<NaveMilitar> getNaves(){
		return this.navesMilitares;
	}
	
}
