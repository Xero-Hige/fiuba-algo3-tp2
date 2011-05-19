package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeObjetoEspacialTest{
	
	private ObjetoEspacial objetoEspacial;
	private Comportamiento comportamiento;
	private Escenario escenario;

	@Before 
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		objetoEspacial = new ObjetoEspacial(new Point(0,0),1,escenario);
		comportamiento = objetoEspacial.obtenerComportamiento();
	}
	
	@Test
	public void testSufrirChoqueDeBono(){
	//Pedimos que el objeto no se destruya cuando sufra el choque
	comportamiento.sufrirChoqueDeBono(new BonoDeEnergia(1));
	Assert.assertFalse(objetoEspacial.estaDestruido())
	}
	
	@Test
	public void testSufrirChoqueDeNaveCivil(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.sufrirChoqueDeNaveCivil(new NaveCivil(new Point(0,0),1,escenario,1,100);
		Assert.assertFalse(objetoEspacial.estaDestruido())
	}
	
	@Test
	public void testSufrirChoqueDeNaveMilitar(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.sufrirChoqueDeNaveMilitar(new NaveMilitar(new Point(0,0),1,escenario,1,100);
		Assert.assertFalse(objetoEspacial.estaDestruido());
	}

	@Test
	public void testSufrirChoqueDeObjetoEspacial(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.sufrirChoqueDeObjetoEspacial(new ObjetoEspacial(new Point(0,0),1,escenario);
		Assert.assertFalse(objetoEspacial.estaDestruido());
	}

	@Test
	public void testSufrirChoqueDeProyectil(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.sufrirChoqueDeProyectil(new Proyectil(new Point(0,0),0.1,0,10);
		Assert.assertFalse(objetoEspacial.estaDestruido());
	}
