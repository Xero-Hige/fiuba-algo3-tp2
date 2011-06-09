package tp2.control;

import tp2.modelo.Mision;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class ControladorMision extends ControladorJuego {
	
	private Mision mision;

	public ControladorMision(boolean activarReproductor, Mision mision) {
		super(activarReproductor);
		this.mision = mision;
	}
	
	public void avanzarUnCiclo(){
		// ***Lógica adicional*** Falta implementar
		this.comenzarJuego(1);
		// ***Lógica adicional***
	}

}
