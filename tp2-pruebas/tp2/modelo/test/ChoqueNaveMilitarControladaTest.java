package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueNaveMilitarControladaTest {
	
	private Escenario escenario;
	private Nave nave;
	private Nave naveEnemiga;
	private Bono bono;
	private Comportamiento comportamiento;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new NaveMilitarControlada(new Point(0,0),1,escenario,1,100);
		naveEnemiga = NaveEnemiga(new Point(0,0),1,escenario,1,30);
		bono = new BonoDeEnergia(1);
		naveEnemiga.cambiarBonoA(bono);
		nave.recibirDanio(50);
		comportamiento = nave.obtenerComportamiento();
	}
	
	@Test
	public void testSufrirChoqueDeBono(){
	//Pedimos que al sufrir el choque del bono, la nave recupere los 30 puntos de energía del enemigo
	comportamiento.sufrirChoqueDeBono(bono);
	Assert.assertTrue(nave.obtenerEnergia() = 80);
	}

}
