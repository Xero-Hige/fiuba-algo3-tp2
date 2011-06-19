package tp2;

import java.io.IOException;
import java.io.File;
import java.util.HashMap;

import tp2.control.ControladorJuegoAlgo42;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class Programa {

	public static void main(String[] args) {
		
		ControladorJuegoAlgo42 controlador = new ControladorJuegoAlgo42(false);
		Ventana ventana = new VentanaPrincipal(controlador);
		controlador.setSuperficieDeDibujo(ventana);
		ventana.setVisible(true);
		
		controlador.setIntervaloSimulacion(20);
		controlador.comenzarJuego();
		
//		HashMap<String, String> a = null;
//		String directorioActual = null;
//
//		try {
//			File dir1 = new File (".");
//			directorioActual = dir1.getCanonicalPath();
//		}
//		catch(Exception e){
//			e.printStackTrace();
//		}		
//		try {
//			System.out.println(directorioActual);
//			a = BuscadorDeArchivos.getArchivos(directorioActual+"/Saves", "save");
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println(a.toString());
	}
}
