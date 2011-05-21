package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class NaveTest {

	private Nave nave;
	private Escenario escenario;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new Nave(new Point(0,0),1,escenario,1,50);
		
	}
	
	@Test
	public void testRecibirDanio1(){
		//Vemos si le podemos hacer 30 de daño
		nave.recibirDanio(30);
		Assert.assertTrue(nave.getEnergia() == 20);
	}
	
	
	@Test
	public void testRecibirDanio2(){
		//Vemos si se destruye al recibir 50 de daño
		nave.recibirDanio(50);
		Assert.assertTrue(nave.estaDestruido());
	}

	@Test
	public void testRecibirDanio3(){
		//Vemos si se destruye al recibir 50 de daño
		nave.recibirDanio(60);
		Assert.assertTrue(nave.estaDestruido());
	}
	
	@Test
	public void testRecuperarEnergiaEn1(){
		new Nave(new Point(0,0),1,escenario,1,100);
		nave.recibirDanio(50);
		
		//Vemos si le podemos recuperar 30 de daño
		nave.recuperarEnergiaEn(30);
		Assert.assertTrue(nave.getEnergia() == 80);
	}
	
	@Test
	public void testRecuperarEnergiaEn2(){
		new Nave(new Point(0,0),1,escenario,1,100);
		nave.recibirDanio(50);
		
		//Vemos si le podemos recuperar 30 de daño
		nave.recuperarEnergiaEn(1000);
		Assert.assertTrue(nave.getEnergia() == 100);
	}
}
