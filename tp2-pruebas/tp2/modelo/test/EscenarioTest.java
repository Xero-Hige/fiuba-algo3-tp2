package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class EscenarioTest {
	
	private Escenario escenario;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
	}
	
	@Test
	public void testAgregarObjeto(){

		Escenario escenario2 = new Escenario(new Rectangle(new Dimension(2,1)));
		ObjetoEspacial objeto = new ObjetoEspacial(new Point(0,0),1,escenario);
		
		//Agregamos el objeto al escenario
		escenario.agregarObjeto(objeto);
		//Probamos agregarlo al escenario incorrecto
		Assert.fail(escenario2.agregarObjeto(objeto)) //raise: ObjetoDesconocido
	}

	@Test
	public void testAvanzarTiempoEn(){
		//Ponemos en el escenario una nave preparada para volar
		Nave nave = new Nave (new Point(23,87),1,escenario,3,100);
		Vuelo vuelo = new VueloEnLineaRecta(nave,new Point(1,0));
		nave.cambiarVueloA(vuelo);
		
		//Avanzamos el tiempo del escenario y verificamos que la nave se haya movido
		escenario.avanzarTiempoEn(1);
		Assert.assertTrue(nave.obtenerPosicion().distancia(new Point(26,87)) <= 1E-10);
}
