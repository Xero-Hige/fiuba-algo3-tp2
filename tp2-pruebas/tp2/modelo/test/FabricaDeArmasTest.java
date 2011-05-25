package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class FabricaDeArmasTest {
	
	private Escenario escenario;
	private FabricaDeArmas fabricaDeArmas;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		fabricaDeArmas = new FabricaDeArmas(escenario);
	}
	
	@Test
	public void testCrearCanionLaser(){
		Arma canion = fabricaDeArmas.crearCanionLaser();
		canion.setPosicion(new Point(200,400));
		Proyectil laserDisparado = canion.disparar();
		laserDisparado.moverDurante(1);
		
		//Pedimos que el proyectil se desplace 100 unidades hacia abajo por unidad de tiempo
		Assert.assertTrue(laserDisparado.getPosicion().distance(new Point(200,300)) <= 1E-10);
		//Pedimos que su identificación sea: CanonLaser
		Assert.assertTrue(canion.getIdentificacion() == "CanionLaser");
		//Pedimos que la carga sea infinita
		Assert.assertTrue(canion.getCarga() == ((Number) Float.POSITIVE_INFINITY));
		//Pedimos que el láser tenga el daño igual a 10
		Assert.assertTrue(laserDisparado.getDanio() == 10);
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue(canion.getFrecuenciaDeDisparo()== 5);
	}

	@Test
	public void testCrearLanzaCohetes(){
		ArmaLimitada lanzaCohetes = fabricaDeArmas.crearLanzaCohetes();
		lanzaCohetes.setPosicion(new Point(200,400));
		Proyectil coheteDisparado = lanzaCohetes.disparar();
		//Pedimos que el proyectil se desplace 50 unidades hacia abajo por unidad de tiempo
		coheteDisparado.moverDurante(1);
		Assert.assertTrue((coheteDisparado.getPosicion().distance(new Point(200,350)) <= 1E-10));
		//Pedimos que su identificación sea: LanzaCohetes
		Assert.assertTrue((lanzaCohetes.getIdentificacion() == "LanzaCohetes"));
		//Pedimos que la carga sea inicialmente 10, o sea ahora que disparó un cohete: 9
		Assert.assertEquals(lanzaCohetes.getCarga(), 9);
		//Pedimos que el cohete tenga el daño igual a 50
		Assert.assertTrue((coheteDisparado.getDanio()) == 50);
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue(lanzaCohetes.getFrecuenciaDeDisparo() == 2);
	}
	
	@Test
	public void testCrearLanzaTorpedos1(){
		ArmaDirigida lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.setPosicion(new Point(200,400));
		Proyectil torpedoDisparado = lanzaTorpedos.disparar();
		//Pedimos que el proyectil se desplace 20 unidades hacia abajo por unidad de tiempo
		torpedoDisparado.moverDurante(1);
		Assert.assertTrue((torpedoDisparado.getPosicion().distance(new Point (200,380)) <= 1E-10));
		//Pedimos que su identificación sea: LanzaTorpedos
		Assert.assertTrue((lanzaTorpedos.getIdentificacion() == "LanzaTorpedos"));
		//Pedimos que la carga sea inicialmente 5, o sea ahora que disparó un cohete: 4
		Assert.assertEquals(lanzaTorpedos.getCarga(), 4);
		//Pedimos que el torpedo tenga el daño igual a 150
		Assert.assertTrue((torpedoDisparado.getDanio() == 150)); 
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue((lanzaTorpedos.getFrecuenciaDeDisparo()== 0.5));
	}
	
	@Test
	public void testCrearLanzaTorpedos2(){
		ArmaDirigida lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.setPosicion(new Point(200,400));
		//Ahora probamos de dirigirle un disparo a una nave de una flota
		NaveMilitar objetivo = new NaveMilitar(new Point(0, 0), 1, escenario, 1, 1);
		objetivo.setPosicion(new Point(34.234,89.238));
		objetivo.setEquipo("aliados");
		Flota flotaObjetivo = new Flota(objetivo);
		lanzaTorpedos.setFlotaObjetivo(flotaObjetivo);
		Proyectil torpedoDisparado = lanzaTorpedos.disparar();
		torpedoDisparado.moverDurante(10000);
		Assert.assertTrue(torpedoDisparado.getPosicion().distance(objetivo.getPosicion()) <= 1E-10);
	}

}
