package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueNaveMilitarControladaTest {
	
	private Escenario escenario;
	private NaveMilitarControlada nave;
	private NaveEnemiga naveEnemiga;
	private Bono bono;
	private ChoqueDeObjetoEspacial comportamiento;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new NaveMilitarControlada(new Point(0,0),1,escenario,1,100);
		naveEnemiga = new NaveEnemiga(new Point(0,0),1,escenario,1,30);
		bono = new BonoDeEnergia(1);
		naveEnemiga.setBono(bono);
		nave.recibirDanio(50);
		comportamiento = nave.getComportamiento();
	}
	
	@Test
	public void testSufrirChoqueDeBono(){
	//Pedimos que al sufrir el choque del bono, la nave recupere los 30 puntos de energía del enemigo
	comportamiento.sufrirChoqueDeBono(bono);
	Assert.assertTrue(nave.getEnergia() == 80);
	}

}
