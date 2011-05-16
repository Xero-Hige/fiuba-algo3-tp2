package tp2.modelo.test;
import org.junit.*;

public class ArmaDirigidaTest {
	
	private Escenario escenario;
	private Arma arma;
	private Flota flota;
	private Proyectil proyectil1;
	private Proyectil proyectil2;
	private Proyectil proyectil3;
	private Nave objetivo1; 
	private Nave objetivo2;
	
	@before
	public void Arrange(){
		 escenario = new Escenario((0 @ 0) extent: (1 @ 1));
		 arma = new ArmaDirigida ((10 @ 1),escenario,100,1,(4 @ 3),"arma");
		 arma.CambiarModeloDeProyectilA(new Proyectil((0 @ 0),0.1,0,10);
		 objetivo1 = new Nave((40 @ -234),1,escenario,1,100);
		 objetivo2 = new Nave((22 @ 67),1,escenario,1,100);
		 objetivo1.CambiarEquipoA("aliados");
		 objetivo2.CambiarEquipoA("aliados");
		 flota = new Flota(objetivo1);
		 arma.CambiarFlotaObjetivoA(flota);
	}
	
	@test
	public void TestDisparar1(){		
		//Disparamos el primer proyectil, y debería alcanzar a la únicaa nave de la flota
		proyectil1 = arma.disparar();
		proyectil1.MoverDurante(10000);
		Assert.assertTrue((proyectil1.ObtenerPosicion().Distancia(objetivo1.ObtenerPosicion())) <= (1E-10));
	}
	
	@test
	public void TestDisparar2(){
		//Disparamos un segundo proyectil, y debería alcanzar al segundo objetivo, porque destruimos el primero
		flota.AgregarNave(objetivo2);
		objetivo1.Destruir();
		proyectil2 = arma.Disparar();
		proyectil2.MoverDurante(10000);
		Assert.assertTrue((proyectil2.ObtenerPosicion().Distancia(objetivo2.ObtenerPosicion())) <= (1E-10));
	}
	
	@test
	public void TestDisparar3(){
		//Disparamos un tercer proyectil con todos los objetivos destruídos, y tiene que seguir la dirección de vuelo indicada
		objetivo1.Destruir();
		objetivo2.Destruir();
		proyectil2 = arma.Disparar();
		proyectil2.MoverDurante(10);
		Assert.assertTrue((proyectil2.ObtenerPosicion().Distancia((810 @ 601))) <= (1E-10));
	}
