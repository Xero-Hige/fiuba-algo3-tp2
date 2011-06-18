package tp2.modelo;

import tp2.auxiliares.Point;
import ar.uba.fi.algo3.titiritero.Posicionable;

public interface Visible extends Posicionable {
	
	public Point getPosicion();
	public String getIdentificacion();
	public double getTamanio();

}
