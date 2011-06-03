package tp2.vista.ventanas;

import java.awt.Dimension;
import java.awt.Rectangle;

import tp2.auxiliares.Point;
import tp2.control.ControlKeyPressMenuPrincipal;
import tp2.modelo.Escenario;
import tp2.modelo.NaveMilitar;
import tp2.modelo.VueloEnLineaRecta;
import tp2.vista.objetosVivos.VistaNavePRUEBA;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
		
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(500,500, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);

		unControladorJuego.agregarKeyPressObservador(new ControlKeyPressMenuPrincipal(unControladorJuego));
	
		
		// PRUEBA DE AGREGAR UN OBJETO VIVO AL ESCENARIO
		
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		NaveMilitar nave = new NaveMilitar(new Point(0,0),1,escenario,1,100);
		VueloEnLineaRecta vuelo = new VueloEnLineaRecta(nave, new Point(30,30));
		nave.setVuelo(vuelo);
		
		VistaNavePRUEBA vistaNavePRUEBA = new VistaNavePRUEBA();
		vistaNavePRUEBA.setPosicionable(nave);
			
		unControladorJuego.agregarDibujable(vistaNavePRUEBA);
		unControladorJuego.agregarObjetoVivo(nave);
	
	}	
}