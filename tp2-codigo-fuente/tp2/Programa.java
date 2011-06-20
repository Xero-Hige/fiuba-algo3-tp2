package tp2;

import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.especificaciones.ReferenciasDeTiempo;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	public static void main(String[] args) {
		
		ControladorJuegoAlgo42 controlador = new ControladorJuegoAlgo42(false);
		Ventana ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(ReferenciasDeTiempo.intervaloDeSimulacion);
		controlador.comenzarJuego();
		
//		Map<Double, Collection<ParCadenaPosicion>> a = ConstructorMisionDesdeXml.datosMision(1);
//		System.out.println(a.toString());
	}
}
