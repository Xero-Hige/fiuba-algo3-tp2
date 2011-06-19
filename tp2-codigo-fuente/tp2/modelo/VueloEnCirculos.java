package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ValorInvalido;
import tp2.modelo.excepciones.VueloIniciado;
import tp2.modelo.excepciones.VueloNoIniciado;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

public class VueloEnCirculos extends Vuelo {

	private double radio;
	private Boolean sentido;

	public VueloEnCirculos(ObjetoVolador objetoVolador, Point centroRelativo,
			Boolean sentido) {
		super(objetoVolador);
		this.configurarCon(centroRelativo, sentido);
	}

	// Recibe la posición relativa (distinta de la nula) al objeto sobre la cual
	// éste describirá el movimiento, y el sentido de giro, que es antihorario
	// si se recibe true, u horario si se recibe false. El vuelo no debe estar
	// iniciado: en este caso se levanta una excepcion AccionDeVueloInvalida.
	public void configurarCon(Point centroRelativo, Boolean sentido) {
		if (this.estaIniciado()) {
			throw new VueloIniciado(
					"No se puede configurar el vuelo porque ya ha sido iniciado.");
		}
		if (centroRelativo.radio() == 0) {
			throw new ValorInvalido("El centro relativo no debe ser el nulo.");
		}
		this.radio = centroRelativo.radio();
		this.sentido = sentido;
		// El ángulo del objeto respecto al centro determina la zona de la
		// circunsferencia donde empieza el vuelo, lo cual reflejamos en la
		// trayectoriaDeVuelo
		this.setTrayectoriaDeVuelo(centroRelativo.getOpuesto().argumento() * this.radio);
	}

	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del
	// mismo respecto al estado anterior. Si el vuelo no comenzó, se levanta una
	// excepción.
	@Override
	public Point avanzarDurante(double unTiempo) {
		if (!this.estaIniciado()) {
			throw new VueloNoIniciado("El vuelo no ha iniciado.");
		}
		double velocidadAngular = this.getObjetoVolador().getVelocidad()
				/ this.radio;
		double anguloActual = this.getTrayectoriaDeVuelo() / this.radio;
		if (sentido == false) {
			velocidadAngular *= -1;
		}
		Point desplazamiento = (new Point(this.radio, 0)).rotarEn(anguloActual
				+ velocidadAngular * unTiempo, new Point(0, 0));
		desplazamiento = desplazamiento.sumarCon((new Point(this.radio, 0))
				.rotarEn(anguloActual, new Point(0, 0)).getOpuesto());
		this.aumentarTrayectoriaEn(velocidadAngular * this.radio * unTiempo);
		return desplazamiento;
	}
	
	public double trayectoriaPorPeriodo(){
		return 2 * Math.PI * this.radio;
	}

	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		contenedor.appendChild(GeneradorXml.generarElementoDe(radio, "radio"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(sentido, "sentido"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		this.radio = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("radio"));
		this.sentido = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("sentido"));		
		return this;
	}

}
