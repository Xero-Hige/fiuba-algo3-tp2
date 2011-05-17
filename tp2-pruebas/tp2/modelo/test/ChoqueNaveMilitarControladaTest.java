package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueNaveMilitarControladaTest {
	
	
	Escenario escenario;
	Nave nave;
	Nave naveEnemiga;
	Bono bono;
	Comportamiento comportamiento;
	
	@Before
	public void Arrange(){
		escenario = new Escenario(new Rectangle());
		nave = new NaveMilitarControlada(new Point(0,0),1,escenario,1,100);
		naveEnemiga = NaveEnemiga(new Point(0,0),1,escenario,1,30);
		bono = new BonoDeEnergia(1);
		naveEnemiga.CambiarBonoA(bono);
		nave.RecibirDanio(50);
		comportamiento = nave.ObtenerComportamiento();
	}
	
	@Test
	public void TestSufrirChoqueDeBono(){
	//Pedimos que al sufrir el choque del bono, la nave recupere los 30 puntos de energía del enemigo
	comportamiento.SufrirChoqueDeBono(bono);
	Assert.assertTrue(nave.ObtenerEnergia() = 80);
	}

}
