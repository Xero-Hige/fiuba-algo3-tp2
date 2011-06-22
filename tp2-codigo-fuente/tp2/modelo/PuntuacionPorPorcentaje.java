package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.persistencia.IGuardable;

public class PuntuacionPorPorcentaje implements Puntuacion, IGuardable {

	private Escenario escenario;
	private double porcentaje;
	
	public PuntuacionPorPorcentaje(Escenario escenario, double porcentaje) {
		super();
		this.escenario = escenario;
		this.porcentaje = porcentaje;
	}

	@Override
	public int getPuntuacion() {
		return (int)(this.escenario.getPuntuacion() * this.porcentaje);
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
