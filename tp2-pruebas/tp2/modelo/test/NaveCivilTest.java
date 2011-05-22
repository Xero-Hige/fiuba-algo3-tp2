package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class NaveCivilTest {

	@Test
	public void testCambiarPenalizacion(){
		Escenario escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		NaveCivil naveCivil = new NaveCivil(new Point(0,0),1,escenario,1,100);
		
		//Probamos agregar una penalización positiva."
		naveCivil.setPenalizacion(10);
		Assert.assertEquals(naveCivil.getPenalizacion(),10);
		
		//Probamos agregar una penalización negativa."" +
		try {
			naveCivil.setPenalizacion(-10);
			Assert.fail("Se asignó una penalización negativa");
			}
		catch(ValorInvalido e){
			Assert.assertTrue(true);
		}		 
		catch(Exception e){
			Assert.fail("Falla con una excepccion invalida");
		}
	}
}
