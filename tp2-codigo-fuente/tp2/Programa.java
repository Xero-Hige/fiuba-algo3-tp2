package tp2;

import tp2.control.ControladorJuegoAlgo42;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	public static void main(String[] args) {
		
		ControladorJuego controlador = new ControladorJuegoAlgo42(false);
		Ventana ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
	}
}
