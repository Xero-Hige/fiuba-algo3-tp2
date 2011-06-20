package tp2.vista.modelo.mision;

import java.awt.Color;

import ar.uba.fi.algo3.titiritero.vista.Cuadrado;

public class VistaBarraDeEnergia extends Cuadrado {

	private static int factorDeAncho = 2;
	private static int porcentajeMaximo = 100;
	
	public VistaBarraDeEnergia() {
		super(factorDeAncho * porcentajeMaximo, 15);
		
		this.setPosicionable(new BarraDeEnergiaBase());
		this.setColor(Color.GREEN);
	}
	
	public void setPorcentajeEnergia(int porcentaje) {
		
		if (porcentaje > porcentajeMaximo)
			this.setAncho(factorDeAncho * porcentajeMaximo);
		else if (porcentaje < 0)
			this.setAncho(0);
		else
			this.setAncho(factorDeAncho * porcentaje);	
		
		if (porcentaje > 30)
			this.setColor(Color.GREEN);
		else
			this.setColor(Color.RED);
	}

	private void setAncho(int i) {
		// TODO Auto-generated method stub
		
	}
}

