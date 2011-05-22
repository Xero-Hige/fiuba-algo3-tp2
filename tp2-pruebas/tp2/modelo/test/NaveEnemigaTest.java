package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class NaveEnemigaTest {
	
	NaveEnemiga naveEnemiga;
	Escenario escenario; 
	
	@Before
	public void arrange(){
		
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		naveEnemiga = new NaveEnemiga(new Point(0,0),1,escenario,1,100);
	}
	
	@Test
	public void testCambiarPuntuacion(){
		//Probamos agregar una puntuación positiva
		naveEnemiga.setPuntuacion(10);
		Assert.assertEquals(naveEnemiga.getPuntuacion(),10);
		
		//Probamos agregar una puntuación negativa		 
		try {
			naveEnemiga.setPuntuacion(-10);
			Assert.fail("Se asignó una puntuación negativa");
			}
		catch(ValorInvalido e){
			Assert.assertTrue(true);
			}		 
		catch(Exception e){
			Assert.fail("Falla con una excepccion invalida");
			}
		}
		
		@Test
		public void testDestruir(){
		
			Bono bono = new BonoDeEnergia(1);
			naveEnemiga.setBono(bono);
			//Al destruir la nave, el bono debería aparecer en el escenario
			naveEnemiga.destruir();
			Assert.assertTrue(escenario.contieneObjeto(bono));
		}
}
