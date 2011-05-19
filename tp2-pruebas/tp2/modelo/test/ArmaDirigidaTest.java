package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ArmaDirigidaTest{
	
	private Escenario escenario;
	private Arma arma;
	private Flota flota;
	private Proyectil proyectil1;
	private Proyectil proyectil2;
	private Proyectil proyectil3;
	private Nave objetivo1; 
	private Nave objetivo2;
	
	@Before 
	public void arrange(){
		 escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		 arma = new ArmaDirigida (new Point(10,1),escenario,100,1,new Point(4,3),"arma");
		 arma.cambiarModeloDeProyectilA(new Proyectil(new Point(0,0),0.1,0,10);
		 objetivo1 = new Nave(new Point(40,-234),1,escenario,1,100);
		 objetivo2 = new Nave(new Point(22,67),1,escenario,1,100);
		 objetivo1.cambiarEquipoA("aliados");
		 objetivo2.cambiarEquipoA("aliados");
		 flota = new Flota(objetivo1);
		 arma.cambiarFlotaObjetivoA(flota);
	}
	
	@Test
	public void testDisparar1(){		
		//Disparamos el primer proyectil, y debería alcanzar a la únicaa nave de la flota
		proyectil1 = arma.disparar();
		proyectil1.moverDurante(10000);
		Assert.assertTrue ((proyectil1.obtenerPosicion().distancia(objetivo1.obtenerPosicion())) <= (1E-10));
	}
	
	@Test
	public void TestDisparar2(){
		//Disparamos un segundo proyectil, y debería alcanzar al segundo objetivo, porque destruimos el primero
		flota.agregarNave(objetivo2);
		objetivo1.destruir();
		proyectil2 = arma.disparar();
		proyectil2.moverDurante(10000);
		Assert.assertTrue((proyectil2.obtenerPosicion().distancia(objetivo2.obtenerPosicion())) <= (1E-10));
	}
	
	@Test
	public void TestDisparar3(){
		//Disparamos un tercer proyectil con todos los objetivos destruídos, y tiene que seguir la dirección de vuelo indicada
		objetivo1.destruir();
		objetivo2.destruir();
		proyectil2 = arma.disparar();
		proyectil2.moverDurante(10);
		Assert.assertTrue((proyectil2.obtenerPosicion().distancia(new Point(810,601))) <= (1E-10));
	}
