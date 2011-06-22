package tp2.persistencia;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorXml {

	private static final String ATRIBUTO_CLASE = "Clase";
	private static final String ATRIBUTO_ES_NULL = "EsNull";
	private static final String ATRIBUTO_ID = "Id";
	private static final String ATRIBUTO_DEPENDS = "Depends";
	private static Map<IGuardable, Integer> idsPorObjeto;
	private static Map<Integer, Element> elementosPorId;
	private static int proximoId;
	private static Document documento;

	public static Document generarPersistenciaDe(IGuardable unGuardable,
			String nombre, String documentacion) {
		documento = crearNuevoDocumento();
		documento.appendChild(documento.createComment(documentacion));
		proximoId = 0;
		idsPorObjeto = new HashMap<IGuardable, Integer>();
		elementosPorId = new HashMap<Integer, Element>();
		Element elemento = generarElementoDe(unGuardable, nombre);
		documento.appendChild(elemento);
		return documento;
	}

	private static Document crearNuevoDocumento() {
		try {
			return DocumentBuilderFactory.newInstance().newDocumentBuilder()
					.newDocument();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Element generarElementoDe(IGuardable unGuardable,
			String nombre) {
		if (unGuardable == null) {
			return generarElementoNull(unGuardable, nombre);
		}
		if (!idsPorObjeto.containsKey(unGuardable)) {
			Integer id = proximoId++;
			idsPorObjeto.put(unGuardable, id);

			Element elemento = documento.createElement(nombre);
			elemento = unGuardable.guardar(elemento);

			Map<String, String> atributos = new HashMap<String, String>();
			atributos.put(ATRIBUTO_ID, id.toString());
			atributos.put(ATRIBUTO_CLASE, unGuardable.getClass().getName());
			asignarAtributos(elemento, atributos);

			elementosPorId.put(id, elemento);
			return elemento;
		}
		String id = idsPorObjeto.get(unGuardable).toString();
		Element elemento = documento.createElement(nombre);
		elemento.setAttribute(ATRIBUTO_DEPENDS, id);
		return elemento;
	}

	public static Element generarElementoDe(Object unObjeto, String nombre) {
		if (unObjeto == null) {
			return generarElementoNull(unObjeto, nombre);
		}
		Element elemento = documento.createElement(nombre);
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put(ATRIBUTO_CLASE, unObjeto.getClass().getName());
		asignarAtributos(elemento, atributos);
		ParserObjetoAElemento.guardarObjeto(unObjeto, elemento);
		return elemento;
	}

	private static Element generarElementoNull(Object unObjeto, String nombre) {
		Element elemento = documento.createElement(nombre);
		Map<String, String> atributos = new HashMap<String, String>();
		atributos.put(ATRIBUTO_ES_NULL, "true");
		asignarAtributos(elemento, atributos);
		return elemento;
	}

	private static void asignarAtributos(Element elemento,
			Map<String, String> atributos) {
		for (Map.Entry<String, String> atributo : atributos.entrySet()) {
			elemento.setAttribute(atributo.getKey(), atributo.getValue());
		}
	}

	public static void grabar(Document documento, String nombreDeArchivo) {
		try {
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.transform(new DOMSource(documento), new StreamResult(
					new PrintStream(nombreDeArchivo)));
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerFactoryConfigurationError e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}