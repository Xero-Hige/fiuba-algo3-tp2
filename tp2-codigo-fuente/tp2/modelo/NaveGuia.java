package tp2.modelo;

import java.util.*;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

// Es una nave guía que sabe controlar una flota, y comunicarse directamente con 
// ella.
public class NaveGuia extends NaveMilitar {
	
	// La flota controlada por la nave.
	private Flota flota;
	// Hacia dónde van a huir las naves de la flota cuando ésta sea destruída.
	private Point direccionDeRetirada;
	
	
	// Constructor
	// Inicializa la nave sin un vuelo asignado ni armas, con la posición, tamaño, 
	// escenario, velocidad, energía y equipo recibidos. La agrega al escenario y 
	// le asigna una nueva flota.
	public NaveGuia(Point posicion, double tamanio, Escenario escenario, double velocidad, double energia) {
		super(posicion, tamanio, escenario, velocidad, energia);
		equipo = "equipo";
		flota = new Flota(this);
		
	}
	
	@Override
	// Ordena a la nave civil actuar en el escenario durante el tiempo específicado.
	public void actuarDurante(double unTiempo) {
		if (this.estaDestruido()){
			List<Arma> armas =this.getArmas();
			Iterator<Arma> iterador = armas.iterator();
			while(iterador.hasNext()){
				iterador.next().desaparecerDelEscenario();
			}
			this.flota.iniciarRetiradaEnDireccion(direccionDeRetirada);
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
	
	public Point getDireccionDeRetirada() {
		return this.direccionDeRetirada;
	}
	
	// Cambia la dirección de retirada. La dirección debe ser no nula.
	public void setDireccionDeRetirada(Point nuevaDireccionDeRetirada) {
		if (nuevaDireccionDeRetirada.radio() == 0){
			throw new ValorInvalido("La dirección de retirada no puede ser nula");
		}
		direccionDeRetirada = nuevaDireccionDeRetirada;
	}
	
	public Flota getFlota() {
		return this.flota;
	}
	
	// Le asigna una flota a la nave.
	public void setFlota(Flota flota) {
		this.flota = flota; 
	}
}
