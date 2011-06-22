package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.persistencia.IGuardable;

public class PuntuacionFija implements Puntuacion, IGuardable {
	
	private int puntuacion;

	public PuntuacionFija(int puntuacion) {
		super();
		this.puntuacion = puntuacion;
	}

	@Override
	public int getPuntuacion() {
		return this.puntuacion;
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
