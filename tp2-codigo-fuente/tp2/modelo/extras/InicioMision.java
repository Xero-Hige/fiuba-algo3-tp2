package tp2.modelo.extras;

import ar.uba.fi.algo3.titiritero.Posicionable;
import tp2.auxiliares.Point;
import tp2.vista.ventanas.DimensionesDeVentana;


public class InicioMision implements Posicionable {

	private Point posicion;
	
	public InicioMision() {
		
		this.posicion = new Point(DimensionesDeVentana.centroX - 50, DimensionesDeVentana.centroY - 10);
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
