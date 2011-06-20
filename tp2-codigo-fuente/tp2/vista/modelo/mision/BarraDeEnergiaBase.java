package tp2.vista.modelo.mision;

import tp2.vista.ventanas.DimensionesDeVentana;
import ar.uba.fi.algo3.titiritero.Posicionable;


public class BarraDeEnergiaBase  implements Posicionable {
	
	private int x;
	private int y;
	
	public BarraDeEnergiaBase() {
		
		this.x = DimensionesDeVentana.centroX - 100;
		this.y = 8;		
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

}
