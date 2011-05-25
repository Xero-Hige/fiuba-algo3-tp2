package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

// Define un arma, la cual puede disparar proyectiles en el escenario en donde esté.
public class Arma extends Movil {

	private Nave naveDuenia;
	private Proyectil modeloDeProyectil;
	private int frecuenciaDeDisparo;
	private double tiempoRestante;
	private boolean disparando;
	private int velocidadDeDisparo;
	private Point direccionDeDisparo;	
	
	// Constructor
	// Inicializa el arma con la posición, escenario, velocidad de disparo, 
	// frecuencia de disparo, dirección de disparo y la identificación recibidos.
	public Arma(Point posicion, Escenario escenario, int velocidad, int frecuencia, Point direccion, String id) {	
		super(posicion, 0, escenario, velocidad);
		this.frecuenciaDeDisparo = frecuencia;
		this.direccionDeDisparo = direccion;
		this.setIdentificacion(id);
	}
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo específicado. Si no 
	// tiene, se levanta una excepción.
	public void actuarDurante(double unTiempo) {

		if (this.getEscenario() == null)
			throw new ComposicionIncompleta("No se ha definido un escenario al objeto.");
		
		if (! (unTiempo <= 0)) {
			this.moverDurante(unTiempo);
			this.tiempoRestante -= unTiempo;
			
			if (this.disparando && (this.tiempoRestante <= 0))
				this.disparar();
		}
	}
	
	// No hace nada. El arma tiene una carga infinita.
	public void cargarCon(int unaCarga) {}
	
	// Acciona el arma para que esta empiece a disparar.
	public void comenzarDisparos() {
		this.disparando = true;
	}
	
	// Dispara el arma en la dirección hacia la cual apunta, y agrega el proyectil 
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {
		
		Proyectil proyectilDisparado;
		Vuelo vuelo;

		proyectilDisparado = this.modeloDeProyectil.clone();
		proyectilDisparado.setPosicion(this.getPosicion());
		proyectilDisparado.setVelocidad(this.velocidadDeDisparo);
		
		vuelo = new VueloEnLineaRecta(proyectilDisparado, this.direccionDeDisparo);
		proyectilDisparado.setVuelo(vuelo);
		proyectilDisparado.setEscenario(this.getEscenario());
		this.tiempoRestante = 1 / this.frecuenciaDeDisparo;
				
		return proyectilDisparado;
	}
	
	public boolean estaDisparando() {
		return this.disparando;
	}
	
	// Acciona el arma para que esta empiece a disparar.
	public void frenarDisparos() {
		this.disparando = false;
	}
	
	// Mueve el arma dependiendo de la posición de la nave dueña, sin importar el 
	// tiempo que haya transcurrido. Si el arma no pertenece a ninguna nave, entonces 
	// se queda quieta.
	public void moverDurante(double unTiempo) {
		
		if (!(this.naveDuenia == null))
			this.setPosicion(this.naveDuenia.getPosicion());
	}
	
	// Cambia el equipo del arma.
	public void setEquipo(String nuevoEquipo) {

		super.setEquipo(nuevoEquipo);
		if (this.modeloDeProyectil != null)
			this.modeloDeProyectil.setEquipo(nuevoEquipo);
	}

	public Point getDireccionDeDisparo() {
		return this.direccionDeDisparo;
	}
	
	// Cambia la dirección de disparo, que no debe ser nula.
	public void setDireccionDeDisparo(Point nuevaDireccion) {
		
		if (nuevaDireccion.radio() == 0) 
			throw new ValorInvalido("La dirección de disparo no puede ser nula.");
		
		this.direccionDeDisparo = nuevaDireccion;
	}
	
	public int getFrecuenciaDeDisparo() {
		return this.frecuenciaDeDisparo;
	}
	
	// Cambia la frecuencia de disparo, que debe ser mayor a cero.
	public void setFrecuenciaDeDisparo(int nuevaFrecuencia) {
		
		if (nuevaFrecuencia <= 0) 
			throw new ValorInvalido("La frecuencia de disparo debe ser mayor a cero.");
		
		this.frecuenciaDeDisparo = nuevaFrecuencia;
	}
	
	public Proyectil getModeloDeProyectil() {
		return this.modeloDeProyectil;
	}
	
	// Asigna una copia del modelo de proyectil al arma. Dicho modelo no debe tener 
	// un vuelo asignado, o sino se levantará una excepción.
	public void setModeloDeProyectil(Proyectil unProyectil) {
		
		if (unProyectil.getVuelo() != null)
			throw new VueloAsignado("El modelo de proyectil no puede tener un vuelo asignado.");
		
		this.modeloDeProyectil = unProyectil.clone();
		this.modeloDeProyectil.setEquipo(this.getEquipo());
	}
	
	public Nave getNaveDuenia() {
		return this.naveDuenia;
	}
	
	// Asigna la nave dueña al arma. Cada vez que actúe, la misma será puesta en la 
	// posición de dicha nave.
	public void setNaveDuenia(Nave nuevaNaveDuenia) {
		this.naveDuenia = nuevaNaveDuenia;
	}
	
	public int getVelocidadDeDisparo() {
		return this.velocidadDeDisparo;
	}
	
	// Cambia la velocidad de disparo, que debe ser mayor a cero.
	public void setVelocidadDeDisparo(int nuevaVelocidad) {
		
		if (nuevaVelocidad <= 0) 
			throw new ValorInvalido("La velocidad de disparo debe ser mayor a cero.");
		
		this.velocidadDeDisparo = nuevaVelocidad;
	}
	
	public Number getCarga() {
		return Float.POSITIVE_INFINITY;
	}	
}
