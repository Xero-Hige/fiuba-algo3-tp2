package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class NaveMilitarTest {
	
	@Test
	public void testAgregarArma(){
		
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		NaveMilitar nave = new NaveMilitar(new Point(0,0),1,escenario,1,100);
		Arma arma1 = new ArmaLimitada(new Point(0,0),escenario,100,1,new Point(4,3),"arma");
		arma1.cargarCon(20);
		Arma arma2 = new ArmaLimitada(new Point(0,0),escenario,100,1,new Point(4,3),"arma");
		arma2.cargarCon(10);
		//Probamos agregar ambas armas, y luego nos fijamos si la primer arma se cargó con la carga de la segunda"
		nave.agregarArma(arma1);
		nave.agregarArma(arma2);
		Assert.assertEquals(arma1.getCarga(),30);
	}
}
