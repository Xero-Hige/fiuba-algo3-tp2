package tp2.modelo.test;

import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class BonoDeEnergiaTest {	
	
	private Bono bono;
	private Nave nave;
	private Nave naveReceptora;
	private Escenario escenario;	

	@Before 
	public void Arrange(){
		escenario = new Escenario(new Rectangle());
		nave = new NaveEnemiga(new Point(243,71),1,escenario,1,50);
		naveReceptora = new NaveMilitarControlada((2,271),1,escenario,1,200);
		naveReceptora.RecibirDanio(100);
		bono = new BonoDeEnergia(1);
		nave.CambiarBonoA(bono);
	}
	
	@Test
	public void TestEntregarBonoA(){
		//Le damos el bono a la nave receptora, y vemos si efectivamente recibió la energía
		bono.EntregarBonoA(naveReceptora);
		Assert.assertTrue(naveReceptora.ObtenerEnergia() = 150);
	}

}
