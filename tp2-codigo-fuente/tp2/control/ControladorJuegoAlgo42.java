package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tp2.modelo.Escenario;
import tp2.modelo.ObjetoEspacial;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Escenario escenario;
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
		this.escenario = new Escenario(new Rectangle(100, 100));
	}

	@Override
	public void comenzarJuego() {
		Map<ObjetoEspacial, Dibujable> auxiliar = new HashMap<ObjetoEspacial, Dibujable>();
		do {
			Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
			Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
			for(ObjetoEspacial objetoCreado: objetosCreados){
				this.agregarObjetoVivo(objetoCreado);
				// Creamos círculo para observar la forma del modelo (en esta prueba)
				Dibujable circulo = new Circulo((int)(objetoCreado.getTamanio() * ProyeccionSobreSuperficieDeDibujo.getEscalaX()));
				circulo.setPosicionable(objetoCreado);
				this.agregarDibujable(circulo);
				auxiliar.put(objetoCreado, circulo);
				// Creamos círculo para observar la forma del modelo (en esta prueba)
				this.agregarDibujable(objetoCreado.getVista());
			}
			for(ObjetoEspacial objetoMuerto: objetosMuertos){
				this.removerObjetoVivo(objetoMuerto);
				// Creamos círculo para observar la forma del modelo (en esta prueba)
				this.removerDibujable(auxiliar.get(objetoMuerto));
				// Creamos círculo para observar la forma del modelo (en esta prueba)
				this.removerDibujable(objetoMuerto.getVista());
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}

	public Escenario getEscenario() {
		return escenario;
	}

}
