package tp2;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.especificaciones.ReferenciasDeTiempo;
import tp2.vista.ventanas.VentanaPruebaMision;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class ProgramaMision2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControladorJuegoAlgo42 controlador = new ControladorJuegoAlgo42(false);
		
		Escenario escenario = new Escenario(new Rectangle(140, 140));
		Mision mision = new Mision(escenario);
		
		Map<Double, Collection<ParCadenaPosicion>> datos = new HashMap<Double, Collection<ParCadenaPosicion>>();
		ParCadenaPosicion par = new ParCadenaPosicion("asdf Falta hacer parser", new Point(40, 100));
		for(int i = 0; i < 30; i++){
			Collection<ParCadenaPosicion> lista = new ArrayList<ParCadenaPosicion>();
			lista.add(par);
			datos.put((double)i, lista);
		}
		mision.generar(datos);
		
		controlador.setMision(mision);
		
		Ventana ventana = new VentanaPruebaMision(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(ReferenciasDeTiempo.intervaloDeSimulacion);
		controlador.comenzarJuego();
	}

}
