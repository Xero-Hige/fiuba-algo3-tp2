package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class NaveMilitarControladaTest {
	
	private NaveMilitarControlada nave;
	private Arma arma1;
	private Arma arma2;
	private Escenario escenario;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new NaveMilitarControlada(new Point(5,5),1,escenario,1,100);
		nave.setVelocidad(10);
		arma1 = new Arma(new Point(10,1),escenario,100,1,new Point(4,3),"arma1");
		arma1 = new Arma(new Point(10,1),escenario,100,1,new Point(4,3),"arma2");
		arma1.setModeloDeProyectil( new Proyectil(new Point(0,0),0.1,0,10));
		arma2.setModeloDeProyectil( new Proyectil(new Point(0,0),0.1,0,10));
		nave.agregarArma(arma1);
		nave.agregarArma(arma2);
	}
	
	@Test
	public void testCambiarDireccionDeVueloA1(){
		//Probamos que la nave siga la dirección que le indicamos
		nave.setDireccionDeVuelo(new Point(1,0));
		nave.moverDurante(1);
		Assert.assertTrue(nave.getPosicion().distance(new Point(15,5)) <= 1E-10);
	}
	
	@Test
	public void testCambiarDireccionDeVueloA2(){
		//Probamos que la nave siga la dirección que le indicamos
		nave.setDireccionDeVuelo(new Point(4,3));
		nave.moverDurante(1);
		Assert.assertTrue(nave.getPosicion().distance(new Point(13,11)) <= 1E-10);
	}

	@Test
	public void testDetenerFuegoConArmaDeId(){
		arma1.comenzarDisparos();
		arma2.comenzarDisparos();
		
		//Probamos la detención del fuego de una (y que no afecte a la otra)
		nave.detenerFuegoConArmaDeId("arma2");
		Assert.assertTrue(arma1.estaDisparando());
		Assert.assertFalse(arma2.estaDisparando());
		
	}
	
	@Test
	public void testIniciarFuegoConArmaDeId(){
		//Probamos el inicio del fuego de una (y que no afecte a la otra)
		nave.iniciarFuegoConArmaDeId("arma1");
		Assert.assertTrue(arma1.estaDisparando());
		Assert.assertFalse(arma2.estaDisparando());
	}
}
