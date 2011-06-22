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
				if(objeto instanceof IGuardable){
					contenedor.appendChild(GeneradorXml.generarElementoDe((IGuardable)objeto, "elemento"));
				} else {
					contenedor.appendChild(GeneradorXml.generarElementoDe(objeto, "elemento"));
				}
			}
		}
		else if((unObjeto instanceof Map)){
			Map map = (Map)unObjeto;
			for(Object key: map.keySet()){
				Object value = map.get(key);
				if(key instanceof IGuardable){
					contenedor.appendChild(GeneradorXml.generarElementoDe((IGuardable)key, "clave"));
				} else {
					contenedor.appendChild(GeneradorXml.generarElementoDe(key, "clave"));
				}
				if(value instanceof IGuardable){
					contenedor.appendChild(GeneradorXml.generarElementoDe((IGuardable)value, "valor"));
				} else {
					contenedor.appendChild(GeneradorXml.generarElementoDe(value, "valor"));
				}
			}
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
