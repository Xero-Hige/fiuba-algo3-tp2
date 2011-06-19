package tp2.modelo.extras;

import ar.uba.fi.algo3.titiritero.Posicionable;
import tp2.auxiliares.Point;


public class InicioMision implements Posicionable {

	private Point posicion;
	
	public InicioMision() {
		
		this.posicion = new Point(250, 250);
	}
	
	@Override
	public int getX() {
		// TODO Auto-generated method stub
		return (int) this.posicion.getX();
	}

	@Override
	public int getY() {
		// TODO Auto-generated method stub
		return (int) this.posicion.getY();
	}
}
