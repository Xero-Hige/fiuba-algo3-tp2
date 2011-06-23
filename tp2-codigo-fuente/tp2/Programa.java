package tp2;

import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.especificaciones.ReferenciasDeTiempo;
import tp2.vista.ventanas.VentanaPrincipal;


public class Programa {

	public static void main(String[] args) {
		
		ControladorJuegoAlgo42 controlador = new ControladorJuegoAlgo42(false);
		VentanaPrincipal ventana = new VentanaPrincipal(controlador);
		controlador.setVentana(ventana);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(ReferenciasDeTiempo.intervaloDeSimulacion);
		controlador.comenzarJuego();
	}
}
