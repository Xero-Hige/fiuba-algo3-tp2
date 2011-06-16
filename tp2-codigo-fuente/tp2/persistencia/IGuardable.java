package tp2.persistencia;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

public interface IGuardable {

	public Element guardar (Element contenedor);
	
	public IGuardable cargar(Map<String, Node> atributos);

}
