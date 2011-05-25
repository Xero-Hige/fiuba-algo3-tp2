package tp2.modelo;

import tp2.auxiliares.Point;

// Es un arma, con la diferencia que tiene una carga limitada. Cuando se le acaba, 
// el arma se desactiva automáticamente y deja de disparar.
public class ArmaLimitada extends Arma {

	private int carga;
	
	// Constructor
	// Inicializa el arma con la posición, escenario, velocidad de disparo, 
	// frecuencia de disparo, dirección de disparo y la identificación recibidos. 
	// La carga inicial es cero.
	public ArmaLimitada (Point posicion, Escenario escenario, int velocidad, double frecuencia, Point direccion, String id) {
		
		super(posicion, escenario, velocidad, frecuencia, direccion, id);
		carga = 0;
	}
	
	@Override
	// Ordena al arma actuar en el escenario durante el tiempo específicado. Si no  
	// tiene, se levanta una excepción.
	public void actuarDurante(double unTiempo) {

		if (this.getCarga() == (Number) 0)
			this.frenarDisparos();
		
		super.actuarDurante(unTiempo);
	}
	
	// Recibe el número de proyectiles con los cuales se va a cargar el arma, y se 
	// los suma al número actual.
	public void cargarCon(int unaCarga) {
		this.carga += unaCarga; 
	}
	
	// Recibe el número de proyectiles que se van a descargar del arma, y se los  
	// resta al número actual.
	public void descargarEn(int unaCarga) {
		this.carga -= unaCarga;
	}
	
	// "Dispara el arma en la dirección hacia la cual apunta, y agrega el proyectil
	// al escenario en el cual se encuentra. La carga disminuye en una unidad.
	// Se supone que este método protegido no se llama si la carga es cero.
	public Proyectil disparar() {
		this.descargarEn(1);
		return super.disparar();
	}

	@Override
	public Number getCarga() {
		return this.carga;
	}
}
