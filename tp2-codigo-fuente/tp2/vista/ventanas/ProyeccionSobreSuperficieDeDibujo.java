package tp2.vista.ventanas;

import java.awt.Rectangle;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ObjetoDesconocido;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

public class ProyeccionSobreSuperficieDeDibujo implements Proyeccion, IGuardable {

	private Rectangle superficieDeDibujo;
	private Rectangle espacioDelModelo;
	
	public ProyeccionSobreSuperficieDeDibujo(Rectangle espacioDelModelo, Rectangle superficieDeDibujo){
		this.superficieDeDibujo = superficieDeDibujo;
		this.espacioDelModelo = espacioDelModelo;
	}
	
	public ProyeccionSobreSuperficieDeDibujo() {}
	
	public void setSuperficieDeDibujo(int ancho, int alto) {
		this.superficieDeDibujo = new Rectangle(ancho, alto);
	}

	public void setEspacioDelModelo(Rectangle espacioDelModelo) {
		this.espacioDelModelo = espacioDelModelo;
	}

	public Point proyectarPunto(Point punto){
		if(superficieDeDibujo == null){
			throw new ObjetoDesconocido("Debe definirse la superficie de dibujo.");
		}
		if(espacioDelModelo == null){
			throw new ObjetoDesconocido("Debe definirse el rectangulo.");
		}
		double x = punto.getX() * getEscalaX();
		double y = superficieDeDibujo.getHeight() - punto.getY() * getEscalaY();
		return new Point(x, y);
	}
	
	public double getEscalaX(){
		if((superficieDeDibujo == null) || (espacioDelModelo == null))
			return 1;
		return superficieDeDibujo.getWidth() / espacioDelModelo.getWidth();
	}
	
	public double getEscalaY(){
		if((superficieDeDibujo == null) || (espacioDelModelo == null))
			return 1;
		return superficieDeDibujo.getHeight() / espacioDelModelo.getHeight();
	}

	@Override
	public Element guardar(Element contenedor) {
		contenedor.appendChild(GeneradorXml.generarElementoDe(superficieDeDibujo, "superficieDeDibujo"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(espacioDelModelo, "espacioDelModelo"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.superficieDeDibujo = (Rectangle) ReconstructorDesdeXml.generarObjeto(atributos.get("superficieDeDibujo"));
		this.espacioDelModelo = (Rectangle) ReconstructorDesdeXml.generarObjeto(atributos.get("espacioDelModelo"));
		return this;
	}
	
}
