package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeNaveTest {

	private Nave nave;
	private Nave aliado; 
	private Nave enemigo; 
	private Escenario escenario;
	private Proyectil proyectilAliado;
	private Proyectil proyectilEnemigo;
	
	public void arrange1(){
		aliado = new NaveCivil(new Point(0,0),1,escenario,1,100);
		aliado.setEquipo("aliados");
		enemigo = new NaveCivil(new Point(0,0),1,escenario,1,100);
		enemigo.setEquipo("enemigos");
	}
	 
	public void arrange2(){
		aliado = new NaveMilitar(new Point(0,0),1,escenario,1,100);
		aliado.setEquipo("aliados");
		enemigo = new NaveMilitar(new Point(0,0),1,escenario,1,100);
		enemigo.setEquipo("enemigos");
	}	 
	 
	@Before 
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new Nave(new Point(0,0),1,escenario,1,100);
		nave.setEquipo("aliados");
		proyectilAliado = new Proyectil(new Point(0,0),0.1,0,10); 
		proyectilAliado.setEquipo("aliados");
		proyectilEnemigo = new Proyectil(new Point(0,0),0.1,0,10); 
		proyectilEnemigo.setEquipo("enemigos");
	}
	 
	@Test
	public void testSufrirChoqueDeNaveCivil1(){
		this.arrange1();
		//Pedimos que la nave no sea destruída al sufrir el choque del aliado
		nave.sufrirChoqueDeNaveCivil((NaveCivil) aliado);
		Assert.assertFalse(nave.estaDestruido());
	}
	
	@Test
	public void testSufrirChoqueDeNaveCivil2(){
		this.arrange1();
		//Pedimos que la nave no sea destruída al sufrir el choque del enemigo (civil)
		nave.sufrirChoqueDeNaveCivil((NaveCivil) enemigo);
		Assert.assertFalse(nave.estaDestruido());
	}
	 
	@Test
	public void testSufrirChoqueDeNaveMilitar1(){
		this.arrange2();
		//Pedimos que la nave no sea destruída al sufrir el choque del aliado
		nave.sufrirChoqueDeNaveMilitar((NaveMilitar) aliado);
		Assert.assertFalse(nave.estaDestruido());
	}
	 
	@Test
	public void testSufrirChoqueDeNaveMilitar2(){
		this.arrange2();
		//Pedimos que la nave sea destruída al sufrir el choque del enemigo
		nave.sufrirChoqueDeNaveMilitar((NaveMilitar) enemigo);
		Assert.assertTrue(nave.estaDestruido());
	}
	 
	@Test
	public void testSufrirChoqueDeProyectil1(){
		//Pedimos que la nave sufra el daño del proyectil enemigo al sufrir el choque
		nave.sufrirChoqueDeProyectil(proyectilEnemigo);
		Assert.assertTrue(nave.getEnergia() == 5);
	}

	@Test
	public void testSufrirChoqueDeProyectil2(){
		//Pedimos que la nave no sufra el daño del proyectil aliado al sufrir el choque
		nave.sufrirChoqueDeProyectil(proyectilAliado);
		Assert.assertTrue(nave.getEnergia() == 15);
	}
}
