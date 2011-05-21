package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class FabricaDeNaveTest {
	
	private Escenario escenario;
	private FabricaDeNaves fabrica;
	private Flota flotaEnemiga;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		flotaEnemiga = new Flota(new NaveGuia(new Point(0,0),1,escenario,1,100));
		fabrica = new FabricaDeNaves(escenario,"aliados",flotaEnemiga);
		}

	@Test
	public void testCrearAlgo42En(){
		Nave bombardero = fabrica.crearAlgo42En(new Point(50,100)); //Habia alguna razon especial para que se llamara bombardero?
		//Pedimos que la energía sea 500
		Assert.assertTrue(bombardero.getEnergia(500);
		//Pedimos que la velocidad sea 25
		Assert.assertTrue(bombardero.getVelocidad() == 25);
		//Pedimos que el tamanio sea 7
		Assert.assertTrue(bombardero.getTamanio == 7);
		//Pedimos que tenga un cañón láser
		Assert.assertTrue(bombardero.getArmas().size() == 1);
		}

	@Test
	public void testCrearAvionCivilEn(){
		Nave avionCivil = fabrica.crearAvionCivilEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue(avionCivil.getEnergia() == 1);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue(avionCivil.getVelocidad() == 5);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue(avionCivil.getTamanio()== 5);
		//Pedimos que la penalización por destrucción sea 300
		Assert.assertTrue(avionCivil.getPenalizacion()== 300);
		}
	
	@Test
	public void testCrearAvionetaEn(){
		Nave avioneta = fabrica.crearAvionetaEn(new Point(50,100));
		//Pedimos que la energía sea 10
		Assert.assertTrue(avioneta.getEnergia() == 10);
		//Pedimos que la velocidad sea 15
		Assert.assertTrue(avioneta.getVelocidad() == 15);
		//Pedimos que el tamaño sea 3
		Assert.assertTrue(avioneta.getTamanio() == 3);
		//Pedimos que tenga una sola arma y que sea un cañón láser
		Assert.assertTrue(avioneta.getArmas().size() == 1);
		//Pedimos que la puntuación por destrucción sea 20
		Assert.assertTrue(avioneta.getPuntuacion() == 20);
		//Pedimos que el destino del vuelo sea (0,-80)
		Assert.assertTrue(avioneta.getVuelo().getDestino() == new Point(0,-80));
		}
	
	@Test
	public void testCrearBombarderoEn(){
		Nave bombardero = fabrica.crearBombarderoEn(new Point(50,100));
		//Pedimos que la energía sea 100
		Assert.assertTrue (bombardero.getEnergia() == 100);
		//Pedimos que la velocidad sea 7
		Assert.assertTrue (bombardero.getVelocidad() == 7);
		//Pedimos que el tamaño sea 7
		Assert.assertTrue (bombardero.getTamanio() == 7);
		//Pedimos que tenga las tres armas
		Assert.assertTrue (bombardero.getArmas().size() == 3;
		//Pedimos que la puntuación por destrucción sea 30
		Assert.assertTrue (bombardero.getPuntuacion() == 30);
		//Pedimos que la dirección de vuelo del zig zag sea hacia abajo y la amplitud 10
		Assert.assertTrue (bombardero.getVuelo().getDireccion().normalized() == new Point(0,-1));
		Assert.assertTrue [bombardero.getVuelo().getAmplitud() == 10);
		}
	
	@Test
	public void testCrearCazaEn(){
		GrupoCazas cazas = fabrica.crearGrupoCazaEn(new Point(50,50));
		//Pido las posiciones en V de tres cazas
		Nave caza1 = cazas[1];
		Nave caza2 = cazas[2];
		Nave caza3 = cazas[3];
		Assert.assertTrue (caza1.getPosicion()==(new Point(40,60)));
		Assert.assertTrue (caza2.getPosicion()==(new Point(50,50)));
		Assert.assertTrue (caza3.getPosicion()==(new Point(60,60)));
		//Pedimos que la energía sea 30
		Assert.assertTrue (caza1.getEnergia(30));
		//Pedimos que la velocidad sea 10
		Assert.assertTrue (caza1.getVelocidad() == 10);
		//Pedimos que el tamaño sea 6
		Assert.assertTrue (caza1.getTamanio() == 6);
		//Pedimos que tenga sólo lanzatorpedos
		Assert.assertTrue (caza1.getArmas().size() == 1);
		//Pedimos que la puntuación por destrucción sea 30
		Assert.assertTrue (caza1.getPuntuacion() == 30);
		}
	
	@Test
	public void testCrearExploradorEn(){
		Nave explorador = fabrica.crearExploradorEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue (explorador.getEnergia() == 1);
		//Pedimos que la velocidad sea 12
		Assert.assertTrue (explorador.getVelocidad() == 12);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue (explorador.getTamanio() == 5);
		//Pedimos que no tenga armas
		Assert.assertTrue (explorador.getArmas().size() == 0);
		//Pedimos que la puntuación por destrucción sea 50
		Assert.assertTrue (explorador.getPuntuacion() == 50);
		}
	
	@Test
	public void testCrearGuiaEnemigoEn(){
		Nave guiaEnemigo = fabrica.crearGuiaEnemigoEn(new Point(50,100));
		//Pedimos que la energía sea 1000
		Assert.assertTrue (guiaEnemigo.getEnergia() == 1000);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue (guiaEnemigo.getVelocidad() == 5);
		//Pedimos que el tamaño sea 15
		Assert.assertTrue (guiaEnemigo.getTamanio() == 15);
		//Pedimos que no tenga armas
		Assert.assertTrue (guiaEnemigo.getArmas().size() == 0);
	}

	@Test
	public void testCrearHelicopteroFederalEn(){
		Nave helicopteroFederal = fabrica.crearHelicopteroFederalEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue (helicopteroFederal.getEnergia() == 1);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue (helicopteroFederal.getVelocidad() == 5);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue (helicopteroFederal.getTamanio() == 5);
		//Pedimos que la penalización por destrucción sea 200
		Assert.assertTrue (helicopteroFederal.getPenalizacion() == 200);
	}
}
