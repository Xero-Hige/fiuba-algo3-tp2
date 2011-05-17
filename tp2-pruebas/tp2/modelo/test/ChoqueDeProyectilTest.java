package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ChoqueDeProyectilTest {
	private Proyectil proyectil;
	private Comportamiento comportamiento;
	private Nave aliado;
	private Nave enemigo;
	private Escenario escenario;
	
	@Betfore
	public void Arrenge(){
		escenario = new Escenario(new Rectangle());
		proyectil = new Proyectil(new Point(0,0),0.1,0,10);
		proyectil.CambiarEquipoA("aliados");
		aliado = new NaveMilitar (new Point(0,0),1,escenario,1,100);
		aliado.CambiarEquipoA("aliados");
		enemigo = new NaveMilitar (new Point(0,0),1,escenario,1,100);
		enemigo.CambiarEquipoA("enemigos");
		comportamiento = proyectil.ObtenerComportamiento();
	}

	@Test
	public void TestSufrirChoqueDeNaveMilitar1(){
		//Pedimos que el proyectil no sea destruído al sufrir el choque del aliado
		comportamiento.SufrirChoqueDeNaveMilitar(aliado);
		Assert.assertFalse(proyectil.EstaDestruido());
	}

	@Test
	public void TestSufrirChoqueDeNaveMilitar2(){
		//Pedimos que el proyectil sea destruído al sufrir el choque del enemigo
		comportamiento.SufrirChoqueDeNaveMilitar(enemigo);
		Assert.assertTrue(proyectil.EstaDestruido());
}
