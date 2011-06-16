package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;

import tp2.modelo.Escenario;
import tp2.modelo.ObjetoEspacial;
import ar.uba.fi.algo3.titiritero.ControladorJuego;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Escenario escenario;
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
		this.escenario = new Escenario(new Rectangle(50, 50));
	}

	@Override
	public void comenzarJuego() {
		do {
			Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
			Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
			for(ObjetoEspacial objetoCreado: objetosCreados){
				this.agregarObjetoVivo(objetoCreado);
				this.agregarDibujable(objetoCreado.getVista());
			}
			for(ObjetoEspacial objetoMuerto: objetosMuertos){
				this.removerObjetoVivo(objetoMuerto);
				this.removerDibujable(objetoMuerto.getVista());
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}

	public Escenario getEscenario() {
		return escenario;
	}

}
