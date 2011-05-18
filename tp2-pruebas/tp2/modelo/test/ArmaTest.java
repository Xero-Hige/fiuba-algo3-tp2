package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ArmaTest {
	
	private Escenario escenario;
	private Arma arma;
	private Proyectil proyectil;
	private Proyectil proyectil2;
	private Posicion posicionInicial;
	
	@Before
	public void Arrange(){
		escenario = new Escenario(new Rectangle ());
		arma = new Arma(new Point(10,1),escenario,100,1,new Point(4,3),"arma");
		arma.CambiarModeloDeProyectilA(new Proyectil(new Point(0,0),0.1,0,10);
	}
	
	@Test
	public void TestDisparar(){
		
		//Disparamos y verificamos que el proyectil siga la ruta correcta
		proyectil = arma.Disparar();
		posicionInicial = proyectil.ObtenerPosicion();
		proyectil.MoverDurante(1); //Se desplazó en (80 @ 60)
		
		Assert.assertTrue((posicionInicial.Distancia(new Point(10,1)) < 1E-10));
		Assert.assertTrue((proyectil.ObtenerPosicion().Distancia(new Point(90,61)) < 1E-10);
	}

	@Test
	public void TestDisparar2(){
		
		proyectil = arma.Disparar();
		proyectil2 = arma.Disparar();
		
		//Disparamos dos proyectiles y deberían ser instancias diferentes
		Assert.assertTrue(proyectil != proyectil2);
	}
	
	@Test
	public void TestMoverDurante(){
		private ObjetoVolador nave = new NaveMilitar(new Point(56,71),1,escenario,1,100);
		arma = new Arma(new Point(5,5),escenario,100,1,new Point(4,3),"arma");
		//Intentamos mover el arma sin que esta pertenezca a ninguna nave
		arma.MoverDurante(10);
		Assert.assertTrue(arma.ObtenerPosicion().Distancia(new Point(5,5)) <= 1E-10);
		
		//Ahora le asignamos una nave y la volvemos a mover
		
		arma.CambiarDuenoA(nave);
		arma.MoverDurante(10);
		Assert.assertTrue(arma.ObtenerPosicion().Distancia(new Point(56,71)) <= 1E-10);
		}
}
