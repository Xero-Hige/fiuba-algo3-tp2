package tp2.modelo.test;
import org.junit.*;

public class ArmaTest {
	
	private Escenario escenario;
	private Arma arma;
	private Proyectil proyectil;
	private Proyectil proyectil2;
	private Posicion posicionInicial;
	
	@before
	public void Arrange{
		escenario = new Escenario((0 @ 0) extent: (1 @ 1));
		arma = new Arma((10 @ 1),escenario,100,1,(4 @ 3),"arma");
		arma.CambiarModeloDeProyectilA(new Proyectil((0 @ 0),0.1,0,10);
	}
	
	@test
	public void TestDisparar{
		
		//Disparamos y verificamos que el proyectil siga la ruta correcta
		proyectil = arma.Disparar();
		posicionInicial = proyectil.ObtenerPosicion();
		proyectil.MoverDurante(1) //Se desplazó en (80 @ 60)
		
		Assert.assertTrue((posicionInicial.Distancia((10 @ 1)) < 1E-10));
		Assert.assertTrue((proyectil.ObtenerPosicion().Distancia((90 @ 61)) < 1E-10);
	}

	@test
	public void TestDisparar2{
		
		proyectil = arma.Disparar();
		proyectil2 = arma.Disparar();
		
		//Disparamos dos proyectiles y deberían ser instancias diferentes
		Assert.assertTrue(proyectil != proyectil2);
	}
	
	@test
	public void TestMoverDurante{
		private Nave nave = new NaveMilitar((56 @ 71),1,escenario,1,100);
		arma = new Arma((5 @ 5),escenario,100,1,(4 @ 3),"arma");
		//Intentamos mover el arma sin que esta pertenezca a ninguna nave
		arma.MoverDurante(10);
		Assert.assertTrue(arma.ObtenerPosicion().Distancia((5 @ 5)) <= 1E-10);
		
		//Ahora le asignamos una nave y la volvemos a mover
		
		arma.CambiarDuenoA(nave);
		arma.MoverDurante(10);
		Assert.assertTrue(arma.ObtenerPosicion().Distancia((56 @ 71)) <= 1E-10);
		}
}
