package tp2.persistencia;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ReconstructorDesdeXml {
	
	private static final String ATRIBUTO_CLASE = "Clase";
	private static final String ATRIBUTO_ES_NULL = "EsNull";
	private static final String ATRIBUTO_ID = "Id";
	private static final String ATRIBUTO_DEPENDS = "Depends";

	private static Map<Integer, Node> nodosPorId;
	private static Map<Integer, Object> objetosPorId;
	private static Document documento;

	private static void cargarElementosGuardables(Node nodo) {
		if(nodo.getAttributes() != null){
			if(nodo.getAttributes().getNamedItem(ATRIBUTO_ID) != null){
				@SuppressWarnings("unused")
				Map<Integer, Node> nodos = nodosPorId;
				nodosPorId.put(Integer.parseInt(nodo.getAttributes().getNamedItem(ATRIBUTO_ID).getNodeValue()), nodo);
			}
		}
		NodeList subElementos = nodo.getChildNodes();
		for(int i = 0; i < subElementos.getLength(); i++){
			subElementos.item(0).getAttributes();
			cargarElementosGuardables(subElementos.item(i));			
		}
	}

	public static Object generarObjeto(Node nodo) {
		NamedNodeMap atributos = nodo.getAttributes();
		if(atributos.getNamedItem(ATRIBUTO_ES_NULL) != null){
			return null;
		}
		Node atributo = atributos.getNamedItem(ATRIBUTO_DEPENDS);
		if(atributo != null){
			int id = Integer.parseInt(atributo.getNodeValue());
			if(objetosPorId.containsKey(id)){
				return objetosPorId.get(id);
			}
			return generarObjeto(nodosPorId.get(id));
		}
		return parsearNodo(nodo);
	}

	private static Object parsearNodo(Node nodo) {
		NamedNodeMap atributos = nodo.getAttributes();
		Node atributo = atributos.getNamedItem(ATRIBUTO_ID);
		if(atributo != null){
			return parsearGuardable(nodo, Integer.parseInt(atributo.getNodeValue()));
		}
		Class<?> clase;
		try {
			clase = Class.forName(nodo.getAttributes().getNamedItem(ATRIBUTO_CLASE).getNodeValue());
			return ParserElementoAObjeto.cargarObjeto(nodo, clase);
		} catch (DOMException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static Object parsearGuardable(Node nodo, int id) {
		if(objetosPorId.containsKey(id)){
			return objetosPorId.get(id);
		}
		NamedNodeMap atributos = nodo.getAttributes();
		Node atributo = atributos.getNamedItem(ATRIBUTO_CLASE);
		IGuardable unGuardable = null;
		String clase = atributo.getNodeValue();
		try {
			unGuardable = (IGuardable) (Class.forName(clase).newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		objetosPorId.put(id, unGuardable);
		Map<String, Node> nodosHijos = construirMapaDeHijos(nodo);
		return unGuardable.cargar(nodosHijos);
	}

	public static Map<String, Node> construirMapaDeHijos(Node nodo) {
		Map<String, Node> nodosHijos = new HashMap<String, Node>();
		NodeList subElementos = nodo.getChildNodes();
		for(int i = 0; i < subElementos.getLength(); i++){
			nodosHijos.put(subElementos.item(i).getNodeName(), subElementos.item(i));		
		}
		return nodosHijos;
	}

	public static IGuardable recuperarPersistenciaDe(Document documento){
		nodosPorId = new HashMap<Integer, Node>();
		objetosPorId = new HashMap<Integer, Object>();
		cargarElementosGuardables(documento.getDocumentElement());
		return (IGuardable) generarObjeto(documento.getDocumentElement());
	}
	
	public static Document cargar(String nombreDeArchivo) {
		return crearNuevoDocumento(nombreDeArchivo);
	}
	
	private static Document crearNuevoDocumento(String nombreDeArchivo) {
		try {
			documento = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(nombreDeArchivo));
			return documento;
		}  catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}