package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class FlotaTest {
	
	Flota flota;
	NaveGuia naveGuia;
	NaveMilitar nave2;
	Escenario escenario;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));	
		naveGuia = new NaveGuia(new Point(6,8),1,escenario,10,100);
		flota = naveGuia.getFlota();
		nave2 = new NaveMilitar (new Point(20,0),1,escenario,5,100);
		nave2.setEquipo("equipo");
		flota.agregarNave(nave2);
	}
	
	@Test
	public void testFlota(){
		//Probamos que al iniciar la retirada, las naves vuelen en la dirección correcta
		flota.iniciarRetiradaEnDireccion(new Point(-3,4));
		naveGuia.moverDurante(1);
		nave2.moverDurante(1);
		Assert.assertTrue(naveGuia.getPosicion().distance(new Point(0,16)) <= 1E-10);
		Assert.assertTrue(nave2.getPosicion().distance(new Point(17,4)) <= 1E-10);
	}
}
