package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class VueloEnZigZagTest {
	
	@Test
	public void testAvanzarDurante(){
		
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		//Configuramos un vuelo en zig-zag hacia abajo con amplitud igual a 1
		Point posicionActual = new Point (0,0);
		double velocidad = Math.sqrt(2);
		ObjetoVolador objetoVolador = new ObjetoVolador(posicionActual,1,escenario,velocidad);
		VueloEnZigZag vuelo = new VueloEnZigZag(objetoVolador,1,new Point(0,-1));
		
		//Intentamos avanzar el vuelo sin iniciarlo
		 try {
			 vuelo.avanzarDurante(1);
			 Assert.fail("El vuelo avanzó sin estar iniciado");
			 }
		 catch(VueloNoIniciado e){
				 Assert.assertTrue(true);
			 }		 
		 catch(Exception e){
				 Assert.fail("Falla con una excepccion invalida");
			 }
		 
		 vuelo.iniciar();
		 
		 //Verificamos que el vuelo siga la ruta esperada
		 ArrayList posiciones = new ArrayList();
		 posicionActual = posicionActual.sumarCon(vuelo.avanzarDurante(1));
		 posiciones.add(posicionActual);
		 posicionActual = posicionActual.sumarCon(vuelo.avanzarDurante(2));
		 posiciones.add(posicionActual);
		 posicionActual = posicionActual.sumarCon(vuelo.avanzarDurante(3));
		 posiciones.add(posicionActual);
		 Assert.assertTrue(((Point)posiciones.get(1)).distance(new Point(1,-1)) <= 1E-10);
		 Assert.assertTrue(((Point)posiciones.get(2)).distance(new Point(-1,-3)) <= 1E-10);
		 Assert.assertTrue(((Point)posiciones.get(3)).distance(new Point(0,-6)) <= 1E-10);
	}
}
