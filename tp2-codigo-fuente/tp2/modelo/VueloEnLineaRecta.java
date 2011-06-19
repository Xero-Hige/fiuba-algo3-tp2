package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;


import tp2.auxiliares.Point;
import tp2.modelo.excepciones.VueloNoIniciado;
import tp2.persistencia.IGuardable;

public class VueloEnLineaRecta extends Vuelo {

	private Point direccion;

	public VueloEnLineaRecta(ObjetoVolador objetoVolador, Point direccion) {
		super(objetoVolador);
		this.setDireccion(direccion);
	}

	public Point getDireccion() {
		return direccion;
	}

	protected void setDireccion(Point direccion) {
		if(direccion.radio() > 0){
			direccion = direccion.multiplicar(1 / direccion.radio());
		}
		this.direccion = direccion;
	}

	// Avanza el vuelo en el tiempo recibido, y devuelve el desplazamiento del
	// mismo respecto al estado anterior. Si el vuelo no comenzó, se levanta una
	// excepción.
	@Override
	public Point avanzarDurante(double unTiempo) {
		double velocidad;
		if(!this.estaIniciado()){
			throw new VueloNoIniciado("El vuelo no ha iniciado.");			
		}
		velocidad = this.getObjetoVolador().getVelocidad();
		this.aumentarTrayectoriaEn(unTiempo * velocidad);
		return (this.getDireccion().multiplicar(unTiempo * velocidad));
	}

	@Override
	public Element guardar(Element contenedor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
