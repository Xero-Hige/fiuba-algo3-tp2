package tp2.vista.ventanas;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import tp2.auxiliares.Point;
import tp2.control.ControlKeyPressMenuPrincipal;
import tp2.modelo.Escenario;
import tp2.modelo.FabricaDeNaves;
import tp2.modelo.Nave;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Circulo;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
		
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		super(500,500, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);

		unControladorJuego.agregarKeyPressObservador(new ControlKeyPressMenuPrincipal(unControladorJuego));
	
		
		// PRUEBA DE AGREGAR UN OBJETO VIVO AL ESCENARIO
		
		Escenario escenario = new Escenario(new Rectangle(50, 50));
		FabricaDeNaves fabrica = new FabricaDeNaves(escenario, "asdf", null);
		List<Nave> naves = new ArrayList<Nave>();
		naves.add(fabrica.crearAvionetaEn(new Point(30, 90)));
		naves.add(fabrica.crearBombarderoEn(new Point(15, 50)));
		naves.add(fabrica.crearExploradorEn(new Point(-15, 45)));
		//naves.add(fabrica.crearAlgo42En(new Point(15, 10)));
		
		List<Circulo> vistas = new ArrayList<Circulo>();
		for(Nave nave: naves){
			Circulo circulo = new Circulo((int) (nave.getTamanio() * 10));
			circulo.setPosicionable(nave);
			vistas.add(circulo);
			unControladorJuego.agregarDibujable(circulo);
			unControladorJuego.agregarObjetoVivo(nave);
		}
		
	
	}	
}