package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class VueloDirigidoTest {
	
	@Test
	public void testAvanzarDurante(){
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		ObjetoVolador objetoVolador = new Nave(new Point(0,0),1,escenario,2,10);
		ObjetoVolador objetivo = new Nave(new Point(100,0),1,escenario,2,10);
		Vuelo vuelo = new VueloDirigido(objetoVolador,objetivo);
		vuelo.iniciar();
		//Probamos que el desplazamiento sea el esperado
		ArrayList<Point> desplazamientos = new ArrayList<Point>();
		desplazamientos.add(vuelo.avanzarDurante(1));
		objetoVolador.setPosicion(new Point(2,0));
		objetivo.setPosicion(new Point(2,100));
		desplazamientos.add(vuelo.avanzarDurante(1000));
		Assert.assertTrue(((Point)desplazamientos.get(1)).distance(new Point(2,0)) <= 1E-10);
		Assert.assertTrue(((Point)desplazamientos.get(2)).distance(new Point(0,100)) <= 1E-10);
	}
}
