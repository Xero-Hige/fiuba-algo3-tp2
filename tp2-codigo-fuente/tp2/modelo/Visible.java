package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.vista.ventanas.Proyeccion;
import ar.uba.fi.algo3.titiritero.Posicionable;

public interface Visible extends Posicionable {
	
	public void setProyeccion(Proyeccion proyeccion);
	public Point getPosicion();
	public String getIdentificacion();
	public double getTamanio();

}
