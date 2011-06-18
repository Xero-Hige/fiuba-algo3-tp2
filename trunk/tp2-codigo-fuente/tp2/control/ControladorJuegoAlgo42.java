package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tp2.modelo.Escenario;
import tp2.modelo.Visible;
import tp2.modelo.ObjetoEspacial;
import tp2.modelo.extras.Explosion;
import tp2.modelo.extras.ObjetosExplosivos;
import tp2.vista.modelo.ParserObjetoIdAVista;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Escenario escenario;
	private Map<Visible, Dibujable> vistas = new HashMap<Visible, Dibujable>();
	
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
		this.escenario = new Escenario(new Rectangle(140, 140));
		ProyeccionSobreSuperficieDeDibujo.setEspacioDelModelo(this.escenario.getAreaDeCombate());
	}

	@Override
	public void comenzarJuego() {
		Map<Visible, Dibujable> auxiliar = new HashMap<Visible, Dibujable>();
		do {
			Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
			Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
			for(ObjetoEspacial objetoCreado: objetosCreados){
				this.agregarObjetoVivo(objetoCreado);
				// Creamos c�rculo para observar la forma del modelo (en esta prueba)
				Dibujable circulo = new Circulo((int)(objetoCreado.getTamanio() * ProyeccionSobreSuperficieDeDibujo.getEscalaX()));
				circulo.setPosicionable(objetoCreado);
				this.agregarDibujable(circulo);
				auxiliar.put(objetoCreado, circulo);
				// Fin Creamos c�rculo para observar la forma del modelo (en esta prueba)
				this.agregarNuevaVista(objetoCreado);
			}
			for(ObjetoEspacial objetoMuerto: objetosMuertos){
				this.removerObjetoVivo(objetoMuerto);
				// Creamos c�rculo para observar la forma del modelo (en esta prueba)
				this.removerDibujable(auxiliar.get(objetoMuerto));
				// Fin Creamos c�rculo para observar la forma del modelo (en esta prueba)
				this.removerVista(objetoMuerto);
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}
	
	private void agregarNuevaVista(Visible objeto){
		Dibujable vista = ParserObjetoIdAVista.getVista(objeto);
		// Borrar despu�s:
		if (vista == null) {
			vista = new Circulo(
					(int) (objeto.getTamanio() * ProyeccionSobreSuperficieDeDibujo
							.getEscalaX()));
		}
		// Fin borrar despu�s.
		vista.setPosicionable(objeto);
		this.agregarDibujable(vista);
		this.vistas.put(objeto, vista);
	}
	
	private void removerVista(Visible objeto){
		this.removerDibujable(this.vistas.get(objeto));
		this.vistas.remove(objeto);
		if(ObjetosExplosivos.esExplosivo(objeto)){
			Explosion explosion = new Explosion(objeto, 10, objeto.getTamanio());
			this.agregarObjetoVivo(explosion);
			this.agregarNuevaVista(explosion);
		}
	}

	public Escenario getEscenario() {
		return escenario;
	}

}