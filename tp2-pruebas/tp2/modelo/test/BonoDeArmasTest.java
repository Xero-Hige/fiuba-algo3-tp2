package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class BonoDeArmasTest {
	
	private Bono bono;
	private Nave nave;
	private Nave naveReceptora;
	private Arma arma;
	private Escenario escenario;	
	
	@Before 
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		nave = new NaveEnemiga(new Point(243,71),1,escenario,1,100);
		naveReceptora = new NaveMilitarControlada((2,271),1,escenario,1,100);
		arma = new Arma(new Point(5,5),escenario,100,1,(4,3),"arma");
		nave.agregarArma(arma);
		bono = new BonoDeArmas(1);
		nave.cambiarBonoA(bono);
	}
	
	@Test
	public void testEntregarBonoA(){
		//Le damos el bono a la nave receptora, y vemos si efectivamente recibió el arma
		bono.entregarBonoA(naveReceptora);
		Assert.assertTrue((naveReceptora.obtenerArmas().size()) = 1);
	}
}
