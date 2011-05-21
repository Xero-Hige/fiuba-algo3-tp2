package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ArmaTest {
	
	private Escenario escenario;
	private Arma arma;
	private Proyectil proyectil;
	private Proyectil proyectil2;
	private Point posicionInicial;
	
	@Before 
	public void arrange(){
		escenario = new Escenario(new Rectangle (new Dimension(1,1)));
		arma = new Arma(new Point(10,1),escenario,100,1,new Point(4,3),"arma");
		arma.setModeloDeProyectil(new Proyectil(new Point(0,0),0.1,0,10));
	}
	
	@Test
	public void testDisparar(){
		
		//Disparamos y verificamos que el proyectil siga la ruta correcta
		proyectil = arma.disparar();
		posicionInicial = proyectil.getPosicion();
		proyectil.moverDurante(1); //Se desplazó en (80 @ 60)
		
		Assert.assertTrue((posicionInicial.distance(new Point(10,1)) < 1E-10));
		Assert.assertTrue((proyectil.getPosicion().distance(new Point(90,61)) < 1E-10));
	}

	@Test
	public void testDisparar2(){
		
		proyectil = arma.disparar();
		proyectil2 = arma.disparar();
		
		//Disparamos dos proyectiles y deberían ser instancias diferentes
		Assert.assertTrue(proyectil != proyectil2);
	}
	
	@Test
	public void testMoverDurante(){
		NaveMilitar nave = new NaveMilitar(new Point(56,71),1,escenario,1,100);
		arma = new Arma(new Point(5,5),escenario,100,1,new Point(4,3),"arma");
		//Intentamos mover el arma sin que esta pertenezca a ninguna nave
		arma.moverDurante(10);
		Assert.assertTrue(arma.getPosicion().distance(new Point(5,5)) <= 1E-10);
		
		//Ahora le asignamos una nave y la volvemos a mover
		
		arma.setNaveDuenia(nave);
		arma.moverDurante(10);
		Assert.assertTrue(arma.getPosicion().distance(new Point(56,71)) <= 1E-10);
		}
}
