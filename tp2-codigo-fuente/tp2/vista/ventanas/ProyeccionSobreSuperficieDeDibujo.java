package tp2.vista.ventanas;

import java.awt.Rectangle;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ObjetoDesconocido;

public class ProyeccionSobreSuperficieDeDibujo implements Proyeccion {

	private Rectangle superficieDeDibujo;
	private Rectangle espacioDelModelo;
	
	public ProyeccionSobreSuperficieDeDibujo(Rectangle espacioDelModelo, Rectangle superficieDeDibujo){
		this.superficieDeDibujo = superficieDeDibujo;
		this.espacioDelModelo = espacioDelModelo;
	}
	
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
	
}
