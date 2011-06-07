package tp2.modelo;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;
import tp2.auxiliares.Point;
import tp2.modelo.excepciones.*;

public abstract class ObjetoEspacial implements Posicionable, ObjetoVivo  {

	private Point posicion;
	private double tamanio;
	private Escenario escenario;
	private boolean destruido;
	private ChoqueDeObjetoEspacial comportamientoAlChocar;
	private String identificacion;

	// Constructor
	// Inicializa el objeto con la posición, tamaño y escenario recibidos.
	// Lo agrega al escenario.
	public ObjetoEspacial(Point posicion, double tamanio, Escenario escenario) {

		this.posicion = posicion;
		this.tamanio = tamanio;
		this.escenario = escenario;
		this.destruido = false;
		this.comportamientoAlChocar = new ChoqueDeObjetoEspacial(this);
		if (this.escenario != null){
			this.escenario.agregarObjeto(this);
		}
	}

	// Devuelve true si el objeto recibido está superpuesto con el receptor
	// del mensaje. Sino false.
	// Devuelve true si el objeto recibido está superpuesto con el receptor
	// del mensaje. Sino false.
	public boolean estaSuperpuestoCon(ObjetoEspacial objetoEspacial) {

		double distanciaMaxima, distancia;
		distanciaMaxima = this.getTamanio() + objetoEspacial.getTamanio();
		distancia = this.getPosicion().distance(objetoEspacial.getPosicion());
		return distancia < distanciaMaxima;
	}

	// Hace actuar al objeto especial durante el tiempo especificado (si es
	// negativo, se debe ignorar el mensaje). En la implementación, no se
	// debería permitir actuar a objetos que no tengan un escenario, y además,
	// si alguno está destruido, debería desaparecer de su escenario y no
	// realizar nada más.
	public abstract void actuarDurante(double unTiempo);
	
	@Override
	public void vivir() {
		this.actuarDurante(0.02);
	}	

	// Hace chocar al objeto recibido con el receptor del mensaje. Ambos sufren
	// el efecto del mismo según cómo esté definido su comportamiento ante el
	// mismo.
	public void chocarCon(ObjetoEspacial unObjetoEspacial) {

		this.responderChoqueDe(unObjetoEspacial);
		unObjetoEspacial.responderChoqueDe(this);
	}

	// Este método tiene carácter de 'protegido de clase' (sólo deben llamarlo
	// objetos de esta dentro de esta jerarquía). El objeto que recibe el
	// mensaje responde el choque y le hace sufrir al objeto recibido sus efectos, 
	// de acuerdo al comportamiento frente al choque que este último tenga.
	// El receptor le pide al objeto recibido que le diga cómo tiene que ser
	// afectado al chocar con los demás objetos existentes. Luego es el receptor
	// el que selecciona de entre todo el comportamiento el correspondiente a él
	// mismo.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		unObjetoEspacial.sufrirChoqueDeObjetoEspacial(this);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el bono
	// recibido.
	public void sufrirChoqueDeBono(Bono unBono) {
		this.comportamientoAlChocar.sufrirChoqueDeBono(unBono);
	}

	// Hace que el objeto receptor del mensaje sea afectado por la nave
	// recibida.
	public void sufrirChoqueDeNave(Nave unaNave) {
		this.comportamientoAlChocar.sufrirChoqueDeNave(unaNave);
	}

	// Hace que el objeto receptor del mensaje sea afectado por por la nave
	// civil recibida.
	public void sufrirChoqueDeNaveCivil(NaveCivil unaNaveCivil) {
		this.comportamientoAlChocar.sufrirChoqueDeNaveCivil(unaNaveCivil);
	}

	// Hace que el objeto receptor del mensaje sea afectado por la nave militar
	// recibida.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		this.comportamientoAlChocar.sufrirChoqueDeNaveMilitar(unaNaveMilitar);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el objeto
	// espacial recibido.
	public void sufrirChoqueDeObjetoEspacial(ObjetoEspacial unObjetoEspacial) {
		this.comportamientoAlChocar.sufrirChoqueDeObjetoEspacial(unObjetoEspacial);
	}

	// Hace que el objeto receptor del mensaje sea afectado por el proyectil
	// recibido.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		this.comportamientoAlChocar.sufrirChoqueDeProyectil(unProyectil);
	}

	// El objeto se borra del escenario. Si no pertenece a ninguno, se levanta
	// una excepción.
	public void desaparecerDelEscenario() {

		if (this.escenario == null) {
			throw new ComposicionIncompleta("El objeto no está en ningún escenario.");
		}

		this.escenario.borrarObjeto(this);
	}

	// Destruye al objeto y le impide realizar acciones en el futuro.
	public void destruir() {
		this.destruido = true;
	}

	public boolean estaDestruido() {
		return this.destruido;
	}

	public Point getPosicion() {
		return posicion;
	}

	public void setPosicion(Point posicion) {
		this.posicion = posicion;
	}
	
	public int getX() {
		// Falta hacer clase de proyección
		return (int) (this.posicion.getX() * (500 / 50));
	}

	public int getY() {
		// Falta hacer clase de proyección
		return 500 - (int) (this.posicion.getY() * (500 / 50));
	}

	public double getTamanio() {
		return this.tamanio;
	}

	public void setTamanio(double nuevoTamanio) {
		this.tamanio = nuevoTamanio;
	}

	public Escenario getEscenario() {
		return this.escenario;
	}

	public String getIdentificacion() {
		return this.identificacion;
	}
	
	// Asigna una identificación comparable al objeto. Si dos objetos tienen la misma 
	// identificación, son del mismo tipo.
	public void setIdentificacion(String nuevaIdentificacion) {
		this.identificacion = nuevaIdentificacion;
	}

	// Cambia el escenario en donde se encuentra el objeto y agrega al mismo
	// en el nuevo.
	public void setEscenario(Escenario nuevoEscenario) {
		this.escenario = nuevoEscenario;
		this.escenario.agregarObjeto(this);
	}

	public ChoqueDeObjetoEspacial getComportamiento() {
		return this.comportamientoAlChocar;
	}

	protected void setComportamiento(
			ChoqueDeObjetoEspacial comportamientoAlChocar) {
		this.comportamientoAlChocar = comportamientoAlChocar;
	}
}
