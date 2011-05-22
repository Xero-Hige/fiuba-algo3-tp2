package tp2.modelo.test;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class ProyectilesTest {
	
	Proyectil proyectil;
	
	@Before
	public void arrange(){
		proyectil = new Proyectil(new Point(0,0),0.1,0,1);
	}
	
	@Test
	public void testCambiarDanio1(){
		//Probamos agregar una penalización positiva
		proyectil.setDanio(10);
		Assert.assertEquals(proyectil.getDanio(),10, 0);
	}
	
		
	@Test
	public void testCambiarDanio2(){
		//Probamos asignar un daño negativo
		try {
			proyectil.setDanio(-10);
			Assert.fail("Se asignó un daño negativo");
		}
		catch(ValorInvalido e){
			Assert.assertTrue(true);
		}
		catch(Exception e){
			Assert.fail("Falla con una excepccion invalida");
		}
	}
}