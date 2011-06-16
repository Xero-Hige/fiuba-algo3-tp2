package tp2;

import tp2.auxiliares.Point;
import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.*;
import tp2.vista.ventanas.VentanaPruebaMision;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class ProgramaMision {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ControladorJuegoAlgo42 controlador = new ControladorJuegoAlgo42(false);
		Ventana ventana = new VentanaPruebaMision(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		FabricaDeNaves fabrica = new FabricaDeNaves(controlador.getEscenario(), "equipo1", null);
		
		NaveMilitarControlada algo42 = fabrica.crearAlgo42En(new Point(25, 10));
		
		fabrica.setEquipoDeLaNave("equipo2");
		
		Nave explorador = fabrica.crearExploradorEn(new Point(10, 45));
		Nave explorador2 = fabrica.crearExploradorEn(new Point(-10, 15));
		
		algo42.iniciarFuego();
		
		controlador.getEscenario().agregarObjeto(algo42);
		controlador.getEscenario().agregarObjeto(explorador);
		controlador.getEscenario().agregarObjeto(explorador2);
		
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
	}

}
