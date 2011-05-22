package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class VueloDireccionableTest {

	private VueloDireccionable vuelo;
	private ObjetoVolador objetoVolador;
	private Escenario escenario;
	private Point desplazamiento;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		objetoVolador = new Nave(new Point(0,0),1,escenario,2,10);
		vuelo = new VueloDireccionable(objetoVolador,new Point(2,4));
		vuelo.iniciar();
		desplazamiento = vuelo.avanzarDurante(1);		
	}
	
	@Test
	public void testAvanzarDurante1(){
		//Probamos que el desplazamiento sea el esperado
		Point punto = new Point(2,4).normalizar().multiplicar(2);
		Assert.assertTrue(desplazamiento.distance(punto) <= (1E-10));
	}
	
	
	@Test
	public void testAvanzarDurante2(){
		//Probamos ver si el desplazamiento es nulo para la dirección nula
		vuelo.setDireccion(new Point(0,0));
		desplazamiento = vuelo.avanzarDurante(1);
		Assert.assertTrue(desplazamiento == new Point(0,0));
	}
}