package tp2.control;

import java.awt.Rectangle;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.Visible;
import tp2.modelo.ObjetoEspacial;
import tp2.modelo.extras.Agua;
import tp2.modelo.extras.Explosion;
import tp2.modelo.extras.Nube;
import tp2.modelo.extras.ObjetosExplosivos;
import tp2.vista.modelo.ParserObjetoIdAVista;
import tp2.vista.modelo.extras.VistaNubeTipo1;
import tp2.vista.modelo.extras.VistaNubeTipo2;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

public class ControladorJuegoAlgo42 extends ControladorJuego {

	private Escenario escenario;
	private Map<Visible, Dibujable> vistas = new HashMap<Visible, Dibujable>();
	private ProyeccionSobreSuperficieDeDibujo proyeccion;
	private Mision mision;
	private HashMap<Visible, Dibujable> auxiliar; // BORRAR después
	
	public ControladorJuegoAlgo42(boolean activarReproductor) {
		super(activarReproductor);
	}

	@Override
	public void setSuperficieDeDibujo(SuperficieDeDibujo superficieDeDibujo) {
		super.setSuperficieDeDibujo(superficieDeDibujo);
	}

	@Override
	public void comenzarJuego() {
		this.auxiliar = new HashMap<Visible, Dibujable>();
		do {
			if(this.mision != null){
				this.simularJuego();
			}
			super.comenzarJuego(1);
		} while (this.estaEnEjecucion());
	}
	
	private synchronized void simularJuego() {
		Collection<ObjetoEspacial> objetosCreados = this.escenario.getObjetosCreados();
		Collection<ObjetoEspacial> objetosMuertos = this.escenario.getObjetosMuertos();
		for(ObjetoEspacial objetoCreado: objetosCreados){
			this.agregarObjetoVivo(objetoCreado);
			// Creamos círculo para observar la forma del modelo (borrar después)
			Dibujable circulo = new Circulo((int)(objetoCreado.getTamanio() * proyeccion.getEscalaX()));
			circulo.setPosicionable(objetoCreado);
			this.agregarDibujable(circulo);
			auxiliar.put(objetoCreado, circulo);
			// Fin Creamos círculo para observar la forma del modelo (borrar después)
			this.agregarNuevaVista(objetoCreado);
		}
		for(ObjetoEspacial objetoMuerto: objetosMuertos){
			this.removerObjetoVivo(objetoMuerto);
			// Creamos círculo para observar la forma del modelo (borrar después)
			this.removerDibujable(auxiliar.get(objetoMuerto));
			// Fin Creamos círculo para observar la forma del modelo (borrar después)
			this.removerVista(objetoMuerto);
		}
		this.mision.simularDurante(this.getIntervaloSimulacion() / 1000.0);
	}

	private void construirVistasDeFondo() {
		Agua agua = new Agua(this.escenario);
		this.agregarNuevaVista(agua);
		
		VistaNubeTipo1 vistaNube1 = new VistaNubeTipo1();
		Nube nube1 = new Nube(-10, -100, 600, 5);
		vistaNube1.setPosicionable(nube1);
		this.agregarDibujable(vistaNube1);
		this.agregarObjetoVivo(nube1);
		
		VistaNubeTipo2 vistaNube2 = new VistaNubeTipo2();
		Nube nube2 = new Nube(300, -300, 700, 6);
		vistaNube2.setPosicionable(nube2);
		this.agregarDibujable(vistaNube2);
		this.agregarObjetoVivo(nube2);
	}

	public void agregarNuevaVista(Visible objeto){
		objeto.setProyeccion(proyeccion);
		Dibujable vista = ParserObjetoIdAVista.getVista(objeto, proyeccion);
		// Borrar después:
		if (vista == null) {
			vista = new Circulo(
					(int) (objeto.getTamanio() * proyeccion.getEscalaX()));
		}
		// Fin borrar después.
		vista.setPosicionable(objeto);
		this.agregarDibujable(vista);
		this.vistas.put(objeto, vista);
	}
	
	public void removerVista(Visible objeto){
		this.removerDibujable(this.vistas.get(objeto));
		this.vistas.remove(objeto);
		if(ObjetosExplosivos.esExplosivo(objeto)){
			Explosion explosion = new Explosion(objeto, 10, objeto.getTamanio());
			this.agregarObjetoVivo(explosion);
			this.agregarNuevaVista(explosion);
		}
	}

	public Mision getMision() {
		return mision;
	}

	public synchronized void setMision(Mision mision) {
		this.mision = mision;
		this.escenario = mision.getEscenario();
		this.proyeccion = new ProyeccionSobreSuperficieDeDibujo(this.escenario.getAreaDeCombate(), new Rectangle(DimensionesDeVentana.ancho, DimensionesDeVentana.alto));
		this.construirVistasDeFondo();
	}

}
