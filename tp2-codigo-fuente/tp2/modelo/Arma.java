package tp2.modelo;

import tp2.auxiliares.Point;

// Define un arma, la cual puede disparar proyectiles en el escenario en donde esté.
public class Arma extends Movil {

	private Nave naveDuenia;
	private Proyectil modeloDeProyectil;
	private int frecuenciaDeDisparo;
	private double tiempoRestante;
	private boolean disparando;
	private int velocidadDeDisparo;
	private Point direccionDeDisparo;
	private String identificacion;
	
	
	// Constructor
	// Inicializa el arma con la posición, escenario, velocidad de disparo, 
	// frecuencia de disparo, dirección de disparo y la identificación recibidos.
	public Arma(Point posicion, Escenario escenario, int velocidad, int frecuencia, Point direccion, String id) {	
		super(posicion, 0, escenario, velocidad);
		this.frecuenciaDeDisparo = frecuencia;
		this.direccionDeDisparo = direccion;
		this.identificacion = id;
	}
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo específicado. Si no 
	// tiene, se levanta una excepción.
	public void actuarDurante(double tiempo) {
		
	}
	
	// No hace nada. El arma tiene una carga infinita.
	public void cargarCon(int unaCarga) {
		
	}
	
	// Acciona el arma para que esta empiece a disparar.
	public void comenzarDisparos() {
		
	}
	
	// Dispara el arma en la dirección hacia la cual apunta, y agrega el proyectil 
	// al escenario en el cual se encuentra. Devuelve el proyectil disparado.
	public Proyectil disparar() {
		return null;
	}
	
	public boolean estaDisparando() {
		return this.disparando;
	}
	
	// Acciona el arma para que esta empiece a disparar.
	public void frenarDisparos() {
		
	}
	
	// Mueve el arma dependiendo de la posición de la nave dueña, sin importar el 
	// tiempo que haya transcurrido. Si el arma no pertenece a ninguna nave, entonces 
	// se queda quieta.
	public void moverDurante(double unTiempo) {
		
	}
	
	/*public float getCarga() {
		
	}*/
	
	// Cambia el equipo del arma.
	public void setEquipo(String nuevoEquipo) {
		
	}

	public Point getDireccionDeDisparo() {
		return this.direccionDeDisparo;
	}
	
	// Cambia la dirección de disparo, que no debe ser nula.
	public void setDireccionDeDisparo(Point nuevaDireccion) {
		
	}
	
	public int getFrecuenciaDeDisparo() {
		return this.frecuenciaDeDisparo;
	}
	
	// Cambia la frecuencia de disparo, que debe ser mayor a cero.
	public void setFrecuenciaDeDisparo(int nuevaFrecuencia) {
		
	}
	
	public String getIdentificacion() {
		return this.identificacion;
	}
	
	// Asigna una identificación comparable al arma. Si dos armas tienen la misma 
	// identificación, son del mismo tipo.
	public void setIdentificacion(String nuevaIdentificacion) {
		
	}
	
	public Proyectil getModeloDeProyectil() {
		return this.modeloDeProyectil;
	}
	
	// Asigna una copia del modelo de proyectil al arma. Dicho modelo no debe tener 
	// un vuelo asignado, o sino se levantará una excepción.
	public void setModeloDeProyectil(Proyectil unProyectil) {
		
	}
	
	public Nave getNaveDuenia() {
		return this.naveDuenia;
	}
	
	// Asigna la nave dueña al arma. Cada vez que actúe, la misma será puesta en la 
	// posición de dicha nave.
	public void setNaveDuenia(Nave nuevaNaveDuenia) {
		
	}
	
	public int getVelocidadDeDisparo() {
		return this.velocidadDeDisparo;
	}
	
	// Cambia la velocidad de disparo, que debe ser mayor a cero.
	public void setVelocidadDeDisparo(int nuevaVelocidad) {
		
	}	
}
