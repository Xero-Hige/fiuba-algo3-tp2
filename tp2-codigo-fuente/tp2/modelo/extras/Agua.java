package tp2.modelo.extras;

import tp2.auxiliares.Point;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Agua implements Posicionable {

	@Override
	public int getX() {
		return (int) ProyeccionSobreSuperficieDeDibujo.proyectarPunto(new Point(50, 50)).getX();
	}

	@Override
	public int getY() {
		return (int) ProyeccionSobreSuperficieDeDibujo.proyectarPunto(new Point(50, 50)).getY();
	}
}
