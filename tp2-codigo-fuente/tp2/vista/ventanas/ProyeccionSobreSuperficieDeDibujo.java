package tp2.vista.ventanas;

import java.awt.Rectangle;

import tp2.auxiliares.Point;
import tp2.modelo.excepciones.ObjetoDesconocido;

public class ProyeccionSobreSuperficieDeDibujo {

	private static Rectangle superficieDeDibujo;
	private static Rectangle espacioDelModelo;
	
	public static void setSuperficieDeDibujo(int ancho, int alto) {
		ProyeccionSobreSuperficieDeDibujo.superficieDeDibujo = new Rectangle(ancho, alto);
	}

	public static void setEspacioDelModelo(Rectangle espacioDelModelo) {
		ProyeccionSobreSuperficieDeDibujo.espacioDelModelo = espacioDelModelo;
	}

	public static Point proyectarPunto(Point punto, double radioDelObjeto){
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
	
	public static double getEscalaX(){
		if(superficieDeDibujo == null)
			return 1;
		return superficieDeDibujo.getWidth() / espacioDelModelo.getWidth();
	}
	
	public static double getEscalaY(){
		if(superficieDeDibujo == null)
			return 1;
		return superficieDeDibujo.getHeight() / espacioDelModelo.getHeight();
	}
	
}
