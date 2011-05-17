package tp2.modelo.test;


import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ObjetoEspacialPrueba {

	private ObjetoEspacial objeto1;
	private ObjetoEspacial objeto2;
	private Escenario escenario;

	@Before
	public void setUp() throws Exception {
		escenario = new Escenario(new Rectangle());
		objeto1 = new Nave(new Point(0, 0), 3, escenario, 1, 1);
	}
	
	@Test
	public void testEstaSuperpuesto1(){
		//Creamos otro objeto a 5 unidades de distancia.
		objeto2 = new Nave(new Point(4, 3), 2, escenario, 1, 1);
		assertFalse(objeto1.estaSuperpuesto(objeto2));
	}
	
	@Test
	public void testEstaSuperpuesto2(){
		objeto2 = new Nave(new Point(4, 3), 2.1, escenario, 1, 1);
		// Los objetos están superpuestos
		assertTrue(objeto1.estaSuperpuesto(objeto2));
	}
	
	@Test
	public void testEstaSuperpuesto3(){
		objeto2 = new Nave(new Point(10, 0), 2.1, escenario, 1, 1);
		// Los objetos no están superpuestos
		assertFalse(objeto1.estaSuperpuesto(objeto2));
	}
	
	@Test
	public void testDestruir(){
		objeto1.destruir();
		assertTrue(objeto1.estaDestruido());
	}

}
