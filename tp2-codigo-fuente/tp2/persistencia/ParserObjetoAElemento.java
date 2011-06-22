package tp2.persistencia;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.w3c.dom.Element;

import tp2.auxiliares.Point;

public class ParserObjetoAElemento {

	@SuppressWarnings("rawtypes")
	public static void guardarObjeto(Object unObjeto, Element contenedor) {
		if ((unObjeto instanceof String) || (unObjeto instanceof Number)
				|| (unObjeto instanceof Boolean)) {
			contenedor.setTextContent(unObjeto.toString());
		}
		else if((unObjeto instanceof Collection)){
			for(Object objeto: (Collection)unObjeto){
				contenedor.appendChild(GeneradorXml.generarElementoDe(objeto, "elemento"));
			}
		}
		else if((unObjeto instanceof Map)){
			Map<Object, Object> map = (Map<Object, Object>)unObjeto;
			map.entrySet();
			for(Map.Entry<Object, Object> entry: map.entrySet()){
				contenedor.appendChild(GeneradorXml.generarElementoDe(entry, "elemento"));
			}
		}
		else if((unObjeto instanceof Map.Entry)){
			Map.Entry<Object, Object> entry = (Map.Entry<Object, Object>) unObjeto;
			contenedor.appendChild(GeneradorXml.generarElementoDe(entry.getKey(), "clave"));
			contenedor.appendChild(GeneradorXml.generarElementoDe(entry.getValue(), "valor"));
		}
		else if((unObjeto instanceof Rectangle)){
			Rectangle rectangle = (Rectangle)unObjeto;
			contenedor.appendChild(GeneradorXml.generarElementoDe(rectangle.getX(), "x"));
			contenedor.appendChild(GeneradorXml.generarElementoDe(rectangle.getY(), "y"));
			contenedor.appendChild(GeneradorXml.generarElementoDe(rectangle.getWidth(), "ancho"));
			contenedor.appendChild(GeneradorXml.generarElementoDe(rectangle.getHeight(), "alto"));
		}
		else if((unObjeto instanceof Point)){
			Point punto = (Point)unObjeto;
			contenedor.appendChild(GeneradorXml.generarElementoDe(punto.getX(), "x"));
			contenedor.appendChild(GeneradorXml.generarElementoDe(punto.getY(), "y"));
		}
	}
	
	

}
