package tp2.persistencia;

import org.w3c.dom.DOMException;
import org.w3c.dom.Node;

public class ParserElementoAObjeto {

	public static Object cargarObjeto(Node nodo, Class<?> clase) {
		try {
			if(clase.equals(String.class)){
				return nodo.getTextContent();
			}
			if(clase.equals(Integer.class)){
				return Integer.parseInt(nodo.getTextContent());
			}
			if(clase.equals(Double.class)){
				return Double.parseDouble(nodo.getTextContent());
			}
			if(clase.equals(Boolean.class)){
				return Boolean.parseBoolean(nodo.getTextContent());
			}
		} catch (DOMException e) {
			e.printStackTrace();
		}
		// Acá saltaría error: falta agregar cómo parsear cierta clase.
		return null;
	}
		
}
