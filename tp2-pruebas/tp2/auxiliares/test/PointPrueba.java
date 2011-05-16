package tp2.auxiliares.test;

import org.junit.Test;

import tp2.auxiliares.Point;

import junit.framework.Assert;
import junit.framework.TestCase;

public class PointPrueba extends TestCase{
	
	@Test
	public void testSumar(){
		Point punto = new Point(3, 4);
		Point desplazamiento = new Point(5, 6);
		// Probamos de sumar los dos puntos
		punto = punto.sumar(desplazamiento);
		double error = punto.distance(new Point(8, 10));
		Assert.assertEquals(0, error, 1e-10);
	}
	
	@Test
	public void testRotar(){
		Point punto = new Point(5, 6);
		Point centro = new Point(5, 7);
		double angulo = Math.PI / 4;
		// Rotamos el punto respecto al centro indicado
		punto.rotar(angulo, centro);
		Point resultado = new Point(5 + Math.sqrt(2) / 2, 7 - Math.sqrt(2)/2);
		double error = punto.distance(resultado);
		Assert.assertEquals(0, error, 1e-10);
	}
}
