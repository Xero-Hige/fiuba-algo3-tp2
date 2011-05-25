package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ValorInvalido;
import tp2.modelo.excepciones.VueloIniciado;
import tp2.modelo.excepciones.VueloNoIniciado;

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
	public VueloEnZigZag(ObjetoVolador unObjetoVolador, double amplitud,
			Point direccion) {
		super(unObjetoVolador);
		this.setAmplitud(amplitud);
		this.setDireccion(direccion);
		this.proximoSegmentoEsPar = false;
		this.trayectoriaRestante = 0;
	}

	@Override
	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del
	// mismo respecto al estado anterior. Si el vuelo no comenzó, se levanta
	// una excepción.
	public Point avanzarDurante(double unTiempo) {
		if (!this.estaIniciado()) {
			throw new VueloNoIniciado("El vuelo no ha iniciado.");
		}
		// Primero necesitamos dibujar los segmentos de zig-zag suficientes para
		// avanzar el vuelo en el tiempo indicado.
		double cantSegmentosADibujar = this.getObjetoVolador().getVelocidad()
				* unTiempo
				- (int) (this.trayectoriaRestante - this.trayectoriaPorSegmento)
				+ 1;
		for (int i = 1; i < cantSegmentosADibujar; i++) {
			this.dibujarSegmentoDeLargo(this.trayectoriaPorSegmento);
		}
		this.trayectoriaRestante += cantSegmentosADibujar
				* this.trayectoriaPorSegmento
				- this.getObjetoVolador().getVelocidad() * unTiempo;
		return super.avanzarDurante(unTiempo);
	}

	@Override
	// Inicia el vuelo compuesto.
	public void iniciar() {
		if (this.estaIniciado()) {
			throw new VueloIniciado("El vuelo ya fue iniciado anteriormente.");
		}
		this.dibujarSegmentoDeLargo(this.trayectoriaPorSegmento / 2);
		this.trayectoriaRestante += this.trayectoriaPorSegmento / 2;
		super.iniciar();
	}

	// Dibuja un segmento del zig-zag, del largo recibido, dependiendo del
	// estado del atributo proximoSegmentoEsPar, que diferencia en cuál de las
	// dos direcciones del zig-zag va el segmento.
	public void dibujarSegmentoDeLargo(double unLargo) {
		Point direccionSegmento;
		if (this.proximoSegmentoEsPar) {
			direccionSegmento = this.direccion.rotarEn(-Math.PI / 4, new Point(
					0, 0));
		} else {
			direccionSegmento = this.direccion.rotarEn(Math.PI / 4, new Point(
					0, 0));
		}
		VueloEnLineaRecta segmentoVuelo = new VueloEnLineaRecta(
				this.getObjetoVolador(), direccionSegmento);
		proximoSegmentoEsPar = !proximoSegmentoEsPar;
		super.agregarVuelo(segmentoVuelo, unLargo);
	}

	public double getAmplitud() {
		return this.trayectoriaPorSegmento / 2 / Math.sqrt(2);
	}

	// Cambia la amplitud del zig-zag. La misma debe ser mayor a cero.
	public void setAmplitud(double amplitud) {
		if (amplitud <= 0) {
			throw new ValorInvalido(
					"La amplitud del vuelo debe ser mayor a cero.");
		}
		this.trayectoriaPorSegmento = amplitud * 2 * Math.sqrt(2);
	}

	public Point getDireccion() {
		return this.direccion;
	}

	// Permite cambiar la dirección de vuelo del zig-zag. La misma debe ser
	// distinta de (0,0).
	public void setDireccion(Point direccion) {
		if (direccion.radio() == 0) {
			throw new ValorInvalido("La dirección de vuelo no puede ser nula.");
		}
		this.direccion = direccion.normalizar();
	}

	@Override
	public void agregarVuelo(Vuelo vuelo, double longitudTrayectoria) {
		throw new UnsupportedOperationException("No se pueden agregar vuelos.");
	}

}
