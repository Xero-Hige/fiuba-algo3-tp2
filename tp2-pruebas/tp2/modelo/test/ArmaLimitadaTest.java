package tp2.modelo.test;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class ArmaLimitadaTest {

	//Definidas variables fuera del metodo para el caso de agregar mas pruebas
	private Arma arma;
	private Escenario escenario;

	//Idem variables
	@Before
	public void Arrange(){
		escenario = new Escenario(new Rectangle());
		arma = new ArmaLimitada(new Point(0,0),escenario,100,1,new Point(4,3),"arma");
		arma.CambiarModeloDeProyectilA(new Proyectil(new Point(0,0),0.1,0,10));
		arma.CargarCon(15);
	}

	@Test
	public void TestDisparar(){
		//Hay que probar que al disparar la carga vaya disminuyendo
		int i = 0;
		while (i<8){
			arma.Disparar();
			i++;
		}
		Assert.assertEquals(7,arma.ObtenerCarga());
	}
