package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeObjetoEspacialTest{
	
	private ObjetoEspacial objetoEspacial;
	private Comportamiento comportamiento;
	private Escenario escenario;

	@Before
	public void Arrange(){
		escenario = new Escenario(new Rectangle());
		objetoEspacial = new ObjetoEspacial(new Point(0,0),1,escenario);
		comportamiento = objetoEspacial.ObtenerComportamiento();
	}
	
	@Test
	public void TestSufrirChoqueDeBono(){
	//Pedimos que el objeto no se destruya cuando sufra el choque
	comportamiento.SufrirChoqueDeBono(new BonoDeEnergia(1));
	Assert.assertFalse(objetoEspacial.EstaDestruido())
	}
	
	@Test
	public void TestSufrirChoqueDeNaveCivil(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.SufrirChoqueDeNaveCivil(new NaveCivil(new Point(0,0),1,escenario,1,100);
		Assert.assertFalse(objetoEspacial.EstaDestruido())
	}
	
	@Test
	public void TestSufrirChoqueDeNaveMilitar(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.SufrirChoqueDeNaveMilitar(new NaveMilitar(new Point(0,0),1,escenario,1,100);
		Assert.assertFalse(objetoEspacial.EstaDestruido());
	}

	@Test
	public void TestSufrirChoqueDeObjetoEspacial(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.SufrirChoqueDeObjetoEspacial(new ObjetoEspacial(new Point(0,0),1,escenario);
		Assert.assertFalse(objetoEspacial.EstaDestruido());
	}

	@Test
	public void TestSufrirChoqueDeProyectil(){
		//Pedimos que el objeto no se destruya cuando sufra el choque
		comportamiento.SufrirChoqueDeProyectil(new Proyectil(new Point(0,0),0.1,0,10);
		Assert.assertFalse(objetoEspacial.EstaDestruido());
	}
