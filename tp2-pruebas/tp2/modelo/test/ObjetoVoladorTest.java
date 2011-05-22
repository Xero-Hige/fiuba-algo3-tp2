package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.modelo.excepciones.*;
import tp2.auxiliares.*;

public class ObjetoVoladorTest {

	ObjetoVolador objetoVolador;
	Vuelo vuelo;
	Escenario escenario;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		objetoVolador = new Nave(new Point(10,3),1,escenario,5,10);
		vuelo = new VueloEnLineaRecta(objetoVolador, new Point(3,4));
	}

	@Test
	public void testMoverDurante1(){
		//Intentamos mover al objeto sin haberle asignado un vuelo	
		try {
			objetoVolador.moverDurante(1);
			Assert.fail("El objeto se movió sin tener un vuelo definido");
			}
		catch(ComposicionIncompleta e){
			Assert.assertTrue(true);
			}		 
		catch(Exception e){
			Assert.fail("Falla con una excepccion invalida");
			}
	}

	@Test
	public void testMoverDurante2(){
		//Intentamos mover al objeto habiéndole definido el vuelo
		objetoVolador.setVuelo(vuelo);
		objetoVolador.setEscenario(escenario);
		objetoVolador.moverDurante(10); //Ahora tiene que estar en (10,3) + (30,40)
		Assert.assertTrue(objetoVolador.getPosicion().distance(new Point (40,43)) <= 1E-10);
		}
}
