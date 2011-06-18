package tp2;

import java.util.Iterator;
import java.util.List;

import tp2.auxiliares.Point;
import tp2.control.ControladorJuegoAlgo42;
import tp2.modelo.*;
import tp2.modelo.especificaciones.ReferenciasDeTiempo;
import tp2.modelo.extras.Agua;
import tp2.modelo.extras.Nube;
import tp2.vista.modelo.extras.VistaAgua;
import tp2.vista.modelo.extras.VistaNubeTipo1;
import tp2.vista.modelo.extras.VistaNubeTipo2;
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
		
		VistaAgua vistaAgua = new VistaAgua(new Agua(controlador.getEscenario()));
		controlador.agregarDibujable(vistaAgua);
				
		// Al llegar al menú de misión, dicho menú se encargará de crear la misión (de acuerdo al nivel de la partida que estará en su menú padre de partida), lo cual va a generar las naves como hacemos en este programa de prueba.
		FabricaDeNaves fabrica = new FabricaDeNaves(controlador.getEscenario(), "equipo1", null);
		
		NaveMilitarControlada algo42 = fabrica.crearAlgo42En(new Point(90, 7));
		
		fabrica.setEquipoDeLaNave("equipo2");
		
		Nave explorador = fabrica.crearExploradorEn(new Point(-10, 65));
//		Nave explorador2 = fabrica.crearExploradorEn(new Point(-40, 15));
		Nave bombardero = fabrica.crearBombarderoEn(new Point(40, 90));
		List<NaveEnemiga> grupoCaza = fabrica.crearGrupoCazaEn(new Point(30,50));
		
		algo42.iniciarFuego();
		
		controlador.getEscenario().agregarObjeto(algo42);
		controlador.getEscenario().agregarObjeto(explorador);
//		controlador.getEscenario().agregarObjeto(explorador2);
		controlador.getEscenario().agregarObjeto(bombardero);
		
		Iterator<NaveEnemiga> i = grupoCaza.iterator();
		
		while (i.hasNext()) {
			controlador.getEscenario().agregarObjeto(i.next());
		}
		
		
		VistaNubeTipo1 vistaNube1 = new VistaNubeTipo1();
		Nube nube1 = new Nube(-10, -100, 600, 5);
		vistaNube1.setPosicionable(nube1);
		controlador.agregarDibujable(vistaNube1);
		controlador.agregarObjetoVivo(nube1);
		
		VistaNubeTipo2 vistaNube2 = new VistaNubeTipo2();
		Nube nube2 = new Nube(300, -300, 700, 6);
		vistaNube2.setPosicionable(nube2);
		controlador.agregarDibujable(vistaNube2);
		controlador.agregarObjetoVivo(nube2);
		
		
		controlador.setIntervaloSimulacion(ReferenciasDeTiempo.intervaloDeSimulacion);
		controlador.comenzarJuego();
	}

}
