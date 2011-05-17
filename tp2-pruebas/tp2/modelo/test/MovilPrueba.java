package tp2.modelo.test;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import tp2.auxiliares.Point;
import tp2.modelo.Escenario;
import tp2.modelo.Movil;
import tp2.modelo.Nave;

public class MovilPrueba {

	private Escenario escenario;
	private Movil movil, aliado, enemigo;

	@Before
	public void setUp() throws Exception {
		escenario = new Escenario(new Rectangle());
		movil = new Nave(new Point(25, 8), 3, escenario, 1, 1);
	}

	@Test
	public void testEsAliado() {
		aliado = new Nave(new Point(0, 0), 3, escenario, 1, 1);
		enemigo = new Nave(new Point(0, 0), 3, escenario, 1, 1);
		movil.setEquipo("equipo1");
		aliado.setEquipo("equipo1");
		enemigo.setEquipo("equipo2");
		assertTrue(movil.esAliado(aliado));
		assertFalse(movil.esAliado(enemigo));
		assertFalse(enemigo.esAliado(aliado));
	}

	@Test
	public void testDesplazar1() {
		movil.desplazar(new Point(10, -2));
		double error = movil.getPosicion().distance(new Point(35, 6));
		assertEquals(0, error, 1e-10);
	}
	
	@Test
	public void testDesplazar2() {
		movil.desplazar(new Point(-1.5, -2.8));
		double error = movil.getPosicion().distance(new Point(23.5, 5.2));
		assertEquals(0, error, 1e-10);
	}

}
