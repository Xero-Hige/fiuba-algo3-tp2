package tp2.modelo.test;

import java.awt.Dimension;
import java.awt.Rectangle;

import org.junit.*;

import tp2.modelo.*;
import tp2.auxiliares.*;

public class FabricaDeNaveTest {
	
	private Escenario escenario;
	private Fabrica fabrica;
	private Flota flotaEnemiga;
	
	@Before
	public void arrange(){
		escenario = new Escenario(new Rectangle(new Dimension(1,1)));
		flotaEnemiga = new Flota ( new NaveGuia(new Point(0,0),1,escenario,1,100,"enemigos"));
		fabrica = new FabricaDeNaves(escenario,"aliados",flotaEnemiga);
		}

	@Test
	public void testCrearAlgo42En(){
		Nave bombardero = fabrica.crearAlgo42En(new Point(50,100)); //Habia alguna razon especial para que se llamara bombardero?
		//Pedimos que la energía sea 500
		Assert.assertTrue(bombardero.obtenerEnergia(500);
		//Pedimos que la velocidad sea 25
		Assert.assertTrue(bombardero.obtenerVelocidad() == 25);
		//Pedimos que el tamanio sea 7
		Assert.assertTrue(bombardero.obtenerTamanio == 7);
		//Pedimos que tenga un cañón láser
		Assert.assertTrue(bombardero.obtenerArmas().size() == 1);
		}

	@Test
	public void testCrearAvionCivilEn(){
		Nave avionCivil = fabrica.crearAvionCivilEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue(avionCivil.obtenerEnergia() == 1);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue(avionCivil.obtenerVelocidad() == 5);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue(avionCivil.obtenerTamanio()== 5);
		//Pedimos que la penalización por destrucción sea 300
		Assert.assertTrue(avionCivil.obtenerPenalizacion()== 300);
		}
	
	@Test
	public void testCrearAvionetaEn(){
		Nave avioneta = fabrica.crearAvionetaEn(new Point(50,100));
		//Pedimos que la energía sea 10
		Assert.assertTrue(avioneta.obtenerEnergia() == 10);
		//Pedimos que la velocidad sea 15
		Assert.assertTrue(avioneta.obtenerVelocidad() == 15);
		//Pedimos que el tamaño sea 3
		Assert.assertTrue(avioneta.obtenerTamanio() == 3);
		//Pedimos que tenga una sola arma y que sea un cañón láser
		Assert.assertTrue(avioneta.obtenerArmas().size() == 1);
		//Pedimos que la puntuación por destrucción sea 20
		Assert.assertTrue(avioneta.obtenerPuntuacion() == 20);
		//Pedimos que el destino del vuelo sea (0,-80)
		Assert.assertTrue(avioneta.obtenerVuelo().obtenerDestino() == new Point(0,-80));
		}
	
	@Test
	public void testCrearBombarderoEn(){
		Nave bombardero = fabrica.crearBombarderoEn(new Point(50,100));
		//Pedimos que la energía sea 100
		Assert.assertTrue (bombardero.obtenerEnergia() == 100);
		//Pedimos que la velocidad sea 7
		Assert.assertTrue (bombardero.obtenerVelocidad() == 7);
		//Pedimos que el tamaño sea 7
		Assert.assertTrue (bombardero.obtenerTamanio() == 7);
		//Pedimos que tenga las tres armas
		Assert.assertTrue (bombardero.obtenerArmas().size() == 3;
		//Pedimos que la puntuación por destrucción sea 30
		Assert.assertTrue (bombardero.obtenerPuntuacion() == 30);
		//Pedimos que la dirección de vuelo del zig zag sea hacia abajo y la amplitud 10
		Assert.assertTrue (bombardero.obtenerVuelo().obtenerDireccion().normalized() == new Point(0,-1));
		Assert.assertTrue [bombardero.obtenerVuelo().obtenerAmplitud() == 10);
		}
	
	@Test
	public void testCrearCazaEn(){
		GrupoCazas cazas = fabrica.crearGrupoCazaEn(new Point(50,50));
		//Pido las posiciones en V de tres cazas
		Nave caza1 = cazas[1];
		Nave caza2 = cazas[2];
		Nave caza3 = cazas[3];
		Assert.assertTrue (caza1.obtenerPosicion()==(new Point(40,60)));
		Assert.assertTrue (caza2.obtenerPosicion()==(new Point(50,50)));
		Assert.assertTrue (caza3.obtenerPosicion()==(new Point(60,60)));
		//Pedimos que la energía sea 30
		Assert.assertTrue (caza1.obtenerEnergia(30));
		//Pedimos que la velocidad sea 10
		Assert.assertTrue (caza1.obtenerVelocidad() == 10);
		//Pedimos que el tamaño sea 6
		Assert.assertTrue (caza1.obtenerTamanio() == 6);
		//Pedimos que tenga sólo lanzatorpedos
		Assert.assertTrue (caza1.obtenerArmas().size() == 1);
		//Pedimos que la puntuación por destrucción sea 30
		Assert.assertTrue (caza1.obtenerPuntuacion() == 30);
		}
	
	@Test
	public void testCrearExploradorEn(){
		Nave explorador = fabrica crearExploradorEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue (explorador.obtenerEnergia() == 1);
		//Pedimos que la velocidad sea 12
		Assert.assertTrue (explorador.obtenerVelocidad() == 12);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue (explorador.obtenerTamanio() == 5);
		//Pedimos que no tenga armas
		Assert.assertTrue (explorador.obtenerArmas().size() == 0);
		//Pedimos que la puntuación por destrucción sea 50
		Assert.assertTrue (explorador.obtenerPuntuacion() == 50);
		}
	
	@Test
	public void testCrearGuiaEnemigoEn(){
		Nave guiaEnemigo = fabrica.crearGuiaEnemigoEn(new Point(50,100));
		//Pedimos que la energía sea 1000
		Assert.assertTrue (guiaEnemigo.obtenerEnergia() == 1000);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue (guiaEnemigo.obtenerVelocidad() == 5);
		//Pedimos que el tamaño sea 15
		Assert.assertTrue (guiaEnemigo.obtenerTamanio() == 15);
		//Pedimos que no tenga armas
		Assert.assertTrue (guiaEnemigo.obtenerArmas().size() == 0);
	}

	@Test
	public void testCrearHelicopteroFederalEn(){
		Nave helicopteroFederal = fabrica.crearHelicopteroFederalEn(new Point(50,100));
		//Pedimos que la energía sea 1
		Assert.assertTrue (helicopteroFederal.obtenerEnergia() == 1);
		//Pedimos que la velocidad sea 5
		Assert.assertTrue (helicopteroFederal.obtenerVelocidad() == 5);
		//Pedimos que el tamaño sea 5
		Assert.assertTrue (helicopteroFederal.obtenerTamanio() == 5);
		//Pedimos que la penalización por destrucción sea 200
		Assert.assertTrue (helicopteroFederal.obtenerPenalizacion() == 200);
	}
}
