package tp2.auxiliares;

import java.awt.geom.Point2D;

public class Point extends Point2D {
	
	private double x;
	private double y;

	public Point(double x, double y) {
		this.setLocation(x, y);
	}

	public double getX() {
		return this.x;
	}

	public double getY() {
		return this.y;
	}

	public void setLocation(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public Point sumar(Point punto){
		// Devuelve la suma entre el punto recibido por parámetro y el receptor del
		// mensaje.
		return new Point(this.getX() + punto.getX(), this.getY() + punto.getY());
	}
	
	public Point opuesto(){
		// Devuelve el punto opuesto al receptor del mensaje.
		return new Point(-this.getX(), -this.getY());
	}
	
	public double norma(){
		return this.distance(0, 0);
	}
	
	public double argumento(){
		// Devuelve el argumento asociado al punto recibido, respecto del origen
		return Math.atan2(this.getY(), this.getX());
	}

	public void rotar(double angulo, Point centro) {
		// Rota el punto respecto al centro y ángulo (en radianes) recibido.
		Point relativo = this.sumar(centro.opuesto());
		double x, y, norma;
		norma = relativo.norma();
		angulo += relativo.argumento();
		x = Math.cos(angulo) * norma;
		y = Math.sin(angulo) * norma;
		this.setLocation(centro.sumar(new Point(x, y)));
	}

}
