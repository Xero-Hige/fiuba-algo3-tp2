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
	
	// Devuelve la suma entre el punto recibido por parámetro y el receptor del
	// mensaje.
	public Point sumarCon(Point punto){
		return new Point(this.getX() + punto.getX(), this.getY() + punto.getY());
	}
	
	// Devuelve el punto opuesto al receptor del mensaje.
	public Point getOpuesto(){
		return new Point(-this.getX(), -this.getY());
	}
	
	// Devuelve el argumento asociado al punto recibido, respecto del origen
	public double argumento(){
		return Math.atan2(this.getY(), this.getX());
	}
	// Rota el punto respecto al centro y ángulo (en radianes) recibido.
	public Point rotarEn(double angulo, Point centro) {
		Point relativo = this.sumarCon(centro.getOpuesto());
		double x, y, norma;
		norma = relativo.norma();
		angulo += relativo.argumento();
		x = Math.cos(angulo) * norma;
		y = Math.sin(angulo) * norma;
		this.setLocation(centro.sumarCon(new Point(x, y)));
		return this;
	}

	public Point multiplicar(double multiplicador) {
		return new Point(this.getX() * multiplicador, this.getY() * multiplicador);
	}

	@Override
	public String toString() {
		return String.format("(%.5f, %.5f)", this.getX(), this.getY());
	}
	
	public double norma(){
		return this.distance(0, 0);
	}
    
    // Devuelve el radio del punto en el sistema de coordenadas polares
    public double radio() {
    	return (Math.sqrt((this.x * this.x) + (this.y * this.y)));
    }
    
    // Devuelve un punto nuevo normalizado.
    public Point normalizar() {
    	double r = this.radio();
    	return new Point((this.x / r), (this.y / r));
    }   
}
