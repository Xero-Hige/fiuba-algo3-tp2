package tp2.vista.modelo.mision;

import java.awt.Color;

import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

public class VistaBarraDeEnergiaBase extends Cuadrado {

	public VistaBarraDeEnergiaBase() {
		super(200, 15);
		
		this.setPosicionable(new BarraDeEnergiaBase());
		this.setColor(Color.GRAY);
	}

}
