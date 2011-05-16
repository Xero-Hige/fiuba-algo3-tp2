package tp2.modelo.test;
import org.junit.*;

public class ArmaLimitadaTest {
	
	//Definidas variables fuera del metodo para el caso de agregar mas pruebas
	private Arma arma;
	private Escenario escenario;
	
	//Idem variables
	@before
	public void Arrange{
		escenario = new Escenario((0 @ 0) extent: (1 @ 1));
		arma = new ArmaLimitada((0 @ 0),escenario,100,1,(4 @ 3),"arma");
		arma.CambiarModeloDeProyectilA(new Proyectil((0 @ 0),0.1,0,10));
		arma.CargarCon(15);
	}
	
	@test
	public void TestDisparar{
		//Hay que probar que al disparar la carga vaya disminuyendo
		int i = 0;
		while (i<8){
			arma.Disparar();
			i++;
		}
		Assert.assertEquals(7,arma.ObtenerCarga());
	}
