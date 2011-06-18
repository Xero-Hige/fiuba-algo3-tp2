package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

// Clase que representa al jugador
@SuppressWarnings("unused")
public class Jugador implements IGuardable{

	@Override
	public Element guardar(Element contenedor) {		
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		return this;
	}
	
}
