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
		CanionLaser canion = fabricaDeArmas.crearCanonLaser();
		canion.cambiarPosicionA(new Point(200,400));
		Laser laserDisparado = canion.disparar();
		laserDisparado.moverDurante(1);
		
		//Pedimos que el proyectil se desplace 100 unidades hacia abajo por unidad de tiempo
		Assert.assertTrue(laserDisparado.obtenerPosicion().distancia(new point(200,300)) <= 1E-10);
		//Pedimos que su identificación sea: CanonLaser
		Assert.assertTrue(canion.obtenerIdentificacion() == "CanionLaser");
		//Pedimos que la carga sea infinita
		Assert.assertTrue(canion.obtenerCarga() = (Float(infinity))); //Does this even work?
		//Pedimos que el láser tenga el daño igual a 10
		Assert.assertTrue((laserDisparado.obtenerDanio()) = 10);
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue((canion.obtenerFrecuenciaDeDisparo()= 5);
	}

	@Test
	public void testCrearLanzaCohetes(){
		LanzaCohetes lanzaCohetes = fabricaDeArmas.crearLanzaCohete();
		lanzaCohetes.cambiarPosicionA(new Point(200,400));
		Cohete coheteDisparado = lanzaCohetes.disparar();
		//Pedimos que el proyectil se desplace 50 unidades hacia abajo por unidad de tiempo
		coheteDisparado.moverDurante(1);
		Assert.assertTrue((coheteDisparado.obtenerPosicion().distancia(new Point(200,350)) <= 1E-10));
		//Pedimos que su identificación sea: LanzaCohetes
		Assert.assertTrue((lanzaCohetes.obtenerIdentificacion() == "LanzaCohetes"));
		//Pedimos que la carga sea inicialmente 10, o sea ahora que disparó un cohete: 9
		Assert.assertTrue(lanzaCohetes.obtenerCarga() == 9);
		//Pedimos que el cohete tenga el daño igual a 50
		Assert.assertTrue((coheteDisparado.obtenerDanio) == 50);
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue((lanzaCohetes.obtenerFrecuenciaDeDisparo() == 2);
	}
	
	@Test
	public void testCrearLanzaTorpedos1(){
		LanzaTorpedos lanzaCohetes = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.cambiarPosicionA(new Point(200,400));
		Torpedo torpedoDisparado = lanzaTorpedos.disparar();
		//Pedimos que el proyectil se desplace 20 unidades hacia abajo por unidad de tiempo
		torpedoDisparado.moverDurante(1);
		Assert.assertTrue((torpedoDisparado.obtenerPosicion().distancia(new Point (200,380)) <= 1E-10));
		//Pedimos que su identificación sea: LanzaTorpedos
		Assert.assertTrue((lanzaTorpedos.obtenerIdentificacion() == "LanzaTorpedos"));
		//Pedimos que la carga sea inicialmente 5, o sea ahora que disparó un cohete: 4
		Assert.assertTrue((lanzaTorpedos.obtenerCarga() == 4));
		//Pedimos que el torpedo tenga el daño igual a 150
		Assert.assertTrue((torpedoDisparado.obtenerDanio() == 150)); 
		//Pedimos que la frecuencia de disparo sea 5
		Assert.assertTrue((lanzaTorpedos.obtenerFrecuenciaDeDisparo()== 0.5));
	}
	
	@Test
	public void testCrearLanzaTorpedos2(){
		LanzaTorpedos lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.cambiarPosicionA(new Point(200,400));
		//Ahora probamos de dirigirle un disparo a una nave de una flota
		Nave objetivo = new NaveMilitar();
		objetivo.cambiarPosicionA(new Point(34.234,89.238));
		objetivo.cambiarEquipoA("aliados");
		Flota flotaObjetivo = new Flota(objetivo);
		lanzaTorpedos.cambiarFlotaObjetivoA(flotaObjetivo);
		Torpedo torpedoDisparado = lanzaTorpedos.disparar();
		torpedoDisparado.moverDurante(10000);
		Assert.assertTrue(torpedoDisparado.obtenerPosicion().distancia(objetivo.obtenerPosicion()) <= 1E-10);
	}

}
