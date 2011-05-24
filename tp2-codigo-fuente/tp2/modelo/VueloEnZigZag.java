package tp2.modelo;

import tp2.auxiliares.Point;

// Define un vuelo en zig zag de 45º, de una amplitud dada.
public class VueloEnZigZag extends VueloCompuesto {

	// La dirección media que sigue el vuelo.
	private Point direccion;
	// Se usa para calcular qué parte del zig zag es el siguiente.
	private boolean proximoSegmentoEsPar;
	// La longitud de cada segmento del zig zag (definida por la amplitud).
	private double trayectoriaPorSegmento;
	// Calcula cuándo recorrido del zig zag está definido por delante de la 
	// posición del vuelo.
	private double trayectoriaRestante;
	
	
	// Constructor
	// Inicializa un vuelo en zig zag del objeto volador recibido, con la 
	// amplitud y dirección dadas.
	public VueloEnZigZag(ObjetoVolador unObjetoVolador, double amplitud, Point direccion) {
		super(unObjetoVolador);		
	}
	
	@Override
	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del 
	// mismo respecto al estado anterior. Si el vuelo no comenzó, se levanta 
	// una excepción.
	public Point avanzarDurante(double unTiempo) {
		return null;
	}
	
	@Override
	// Inicia el vuelo compuesto.
	public void iniciar() {
		
	}
	
	@Override
	// No se puede agregar un vuelo (desde afuera) a un objeto de esta clase.
	public void agregarVuelo(Vuelo vuelo, double longitudTrayectoria) {
		
	}
	
	// Dibuja un segmento del zig-zag, del largo recibido, dependiendo del 
	// estado del atributo proximoSegmentoEsPar, que diferencia en cuál de las 
	// dos direcciones del zig-zag va el segmento.
	public void dibujarSegmentoDeLargo(double unLargo) {
		
	}
	
	public double getAmplitud() {
		return 0;
	}
	
	// Cambia la amplitud del zig-zag. La misma debe ser mayor a cero.
	public void setAmplitud(double nuevaAmplitud) {
		
	}
	
	public Point getDireccion() {
		return this.direccion;
	}
	
	// Permite cambiar la dirección de vuelo del zig-zag. La misma debe ser 
	// distinta de (0,0).
	public void setDireccion() {
		
	}
	
}
