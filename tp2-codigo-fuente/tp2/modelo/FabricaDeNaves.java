package tp2.modelo;

import java.util.*;


import tp2.auxiliares.Point;
import tp2.modelo.especificaciones.ValoresDeBonos;
import tp2.modelo.especificaciones.ValoresDeNaves;

// La fábrica de armas puede crear las naves particulares del juego.
public class FabricaDeNaves {

	private Escenario escenarioActual;
	private String equipoDeLaNave;
	private Flota flotaEnemiga;
	private FabricaDeArmas fabricaDeArmas;
	
	// Constructor
	public FabricaDeNaves(Escenario unEscenario,String unEquipo, Flota unaFlotaEnemiga){
		escenarioActual = unEscenario;
		equipoDeLaNave = unEquipo;
		flotaEnemiga = unaFlotaEnemiga;
		fabricaDeArmas = new FabricaDeArmas(unEscenario);
	}
	
	// Crea un Algo42 en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 500, 
	// un tamaño de 7, velocidad igual a 25 y un cañón láser. Su vuelo es en 
	// zig zag hacia abajo. Su vuelo (inicialmente quieto) y disparos pueden 
	// controlarse y puede adquirir bonos de otras naves.
	public NaveMilitarControlada crearAlgo42En(Point unaPosicion){
		
		NaveMilitarControlada algo42 = new NaveMilitarControlada(unaPosicion,ValoresDeNaves.algo42Tamanio,escenarioActual,ValoresDeNaves.algo42Velocidad,ValoresDeNaves.algo42Energia);
		algo42.setIdentificacion("Algo42");
		algo42.setEquipo(equipoDeLaNave);
		Arma canionLaser = fabricaDeArmas.crearCanionLaser();
		canionLaser.setDireccionDeDisparo(new Point(0, 1));
		algo42.agregarArma(canionLaser);
		ArmaLimitada lanzaCohetes = fabricaDeArmas.crearLanzaCohetes();
		lanzaCohetes.setDireccionDeDisparo(new Point(0, 1));
		lanzaCohetes.descargarEn((Integer) lanzaCohetes.getCarga());
		algo42.agregarArma(lanzaCohetes);
		ArmaDirigida lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.setDireccionDeDisparo(new Point(0, 1));
		lanzaTorpedos.descargarEn((Integer) lanzaTorpedos.getCarga());
		lanzaTorpedos.setFlotaObjetivo(flotaEnemiga);
		algo42.agregarArma(lanzaTorpedos);
		
		return algo42;
	}
	
	// Crea un avión civil en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 1, un tamaño 
	// de 5 y velocidad igual a 5. Su vuelo es en línea recta hacia abajo. Su 
	// penalización por destrucción es de 300.
	public NaveCivil crearAvionCivilEn(Point unaPosicion){
		
		NaveCivil avionCivil = new NaveCivil(unaPosicion,ValoresDeNaves.avionCivilTamanio,escenarioActual,ValoresDeNaves.avionCivilVelocidad,ValoresDeNaves.avionCivilEnergia);
		avionCivil.setIdentificacion("AvionCivil");
		avionCivil.setEquipo(equipoDeLaNave);
		avionCivil.setVuelo(new VueloEnLineaRecta(avionCivil,new Point(0,-1)));
		avionCivil.setPenalizacion(ValoresDeNaves.avionCivilPenalizacion);
		
		return avionCivil;
	}
	
	// Crea una avioneta en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. La misma tiene una energía de 10, un tamaño de 3, 
	// velocidad igual a 15 y un cañón láser. Su vuelo es de ida 80 unidades hacia 
	// abajo, y luego de vuelta hacia arriba. Su puntuación por destrucción es de 20.
	public NaveEnemiga crearAvionetaEn(Point unaPosicion){
		
		NaveEnemiga avioneta = new NaveEnemiga(unaPosicion,ValoresDeNaves.avionetaTamanio,escenarioActual,ValoresDeNaves.avionetaVelocidad,ValoresDeNaves.avionetaEnergia);
		avioneta.setEquipo(equipoDeLaNave);
		avioneta.setIdentificacion("Avioneta");
		avioneta.agregarArma(fabricaDeArmas.crearCanionLaser());
		avioneta.setVuelo(new VueloDeIdaYVuelta(avioneta,new Point(0,-80)));
		avioneta.setPuntuacion(ValoresDeNaves.avionetaPuntuacion);
		
		return avioneta;
	}
	
	// Crea un bombardero en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. El mismo tiene una energía de 100, un tamaño de 7, 
	// velocidad igual a 7 y un cañón láser, un lanzacohetes y un lanzatorpedos 
	// dirigido. Su vuelo es en zig zag hacia abajo. Su puntuación por destrucción 
	// es de 30.
	public NaveEnemiga crearBombarderoEn(Point unaPosicion){

		NaveEnemiga bombardero = new NaveEnemiga(unaPosicion,ValoresDeNaves.bombarderoTamanio,escenarioActual,ValoresDeNaves.bombarderoVelocidad,ValoresDeNaves.bombarderoEnergia);
		bombardero.setIdentificacion("Bombardero");
		bombardero.setEquipo(equipoDeLaNave);
		bombardero.agregarArma(fabricaDeArmas.crearCanionLaser());
		bombardero.agregarArma(fabricaDeArmas.crearLanzaCohetes());
		ArmaDirigida lanzaTorpedos = fabricaDeArmas.crearLanzaTorpedos();
		lanzaTorpedos.setFlotaObjetivo(flotaEnemiga);
		bombardero.agregarArma(lanzaTorpedos);
		bombardero.setVuelo(new VueloEnZigZag(bombardero, ValoresDeNaves.bombarderoVueloAmplitud ,new Point(0,-1)));
		bombardero.setPuntuacion(ValoresDeNaves.bombarderoPuntuacion);
		bombardero.setBono(new BonoDeArmas(ValoresDeBonos.bonoDeArmasTamanio));
		
		return bombardero;
	}
	
	// Crea un explorador en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. El mismo tiene una energía de 1, un tamaño de 5, 
	// velocidad igual a 12 y ninguna arma. Su vuelo es 40 unidades hacia la derecha, 
	// luego dos círculos horarios con centro 20 unidades más abajo, y finalmente salida
	// hacia la derecha. Su puntuación por destrucción es de 50.
	public NaveEnemiga crearExploradorEn(Point unaPosicion){
		
		NaveEnemiga explorador = new NaveEnemiga(unaPosicion,ValoresDeNaves.exploradorTamanio,escenarioActual,ValoresDeNaves.exploradorVelocidad,ValoresDeNaves.exploradorEnergia);
		explorador.setIdentificacion("Explorador");
		explorador.setEquipo(equipoDeLaNave);
		VueloCompuesto vuelo = new VueloCompuesto(explorador);
		vuelo.agregarVuelo(new VueloEnLineaRecta(explorador,new Point(1,0)), ValoresDeNaves.exploradorVueloLongitudTrayectoria);
		VueloEnCirculos _vuelo = new VueloEnCirculos(explorador,new Point(0,-20),false);
		vuelo.agregarVuelo(_vuelo,2 * (_vuelo.trayectoriaPorPeriodo()));
		vuelo.agregarVuelo(new VueloEnLineaRecta(explorador,new Point(1,0)), ValoresDeNaves.exploradorVueloLongitudTrayectoria);
		explorador.setVuelo(vuelo);
		explorador.setPuntuacion(ValoresDeNaves.exploradorPuntuacion);
		
		return explorador;
	}
	
	// Crea un grupo de tres cazas en el escenario de la fábrica y con el equipo de 
	// la misma, en la posición recibida. El mismo tiene una energía de 30, un tamaño
	// de 6, velocidad igual a 10 y un lanzatorpedos no dirigido. Su vuelo es en V 
	// hacia abajo. Su puntuación por destrucción es de 30. Devuelve la colección de 
	// los cazas.
	public List<NaveEnemiga> crearGrupoCazaEn(Point unaPosicion){
		
		ArrayList<NaveEnemiga> cazas = new ArrayList<NaveEnemiga>();
		for(int i = 1 ; i <= ValoresDeNaves.cazaUnidadesPorFormacion ; i++){
			//Calculamos la posición para formar una V
			Point posicion = unaPosicion.sumarCon((new Point(0,10).multiplicar(i%2)).sumarCon(new Point(10,0).multiplicar(i - 2)));
			NaveEnemiga caza = new NaveEnemiga(posicion,ValoresDeNaves.cazaTamanio,escenarioActual,ValoresDeNaves.cazaVelocidad,ValoresDeNaves.cazaEnergia);
			caza.setIdentificacion("Caza");
			caza.setEquipo(equipoDeLaNave);
			caza.agregarArma(fabricaDeArmas.crearLanzaTorpedos());
			caza.setVuelo(new VueloEnLineaRecta(caza,new Point(0,-1)));
			caza.setPuntuacion(ValoresDeNaves.cazaPuntuacion);
			caza.setBono(new BonoDeEnergia(ValoresDeBonos.bonoDeEnergiaTamanio));
			cazas.add(caza);
		}
		
		return cazas;
	}
	
	// Crea un guía enemigo en el escenario de la fábrica y con el equipo de la misma,
	// en la posición recibida. El mismo tiene una energía de 1000, un tamaño de 15, 
	// velocidad igual a 5 y ninguna arma. Su vuelo es: entra 50 unidades hacia abajo 
	// y luego se mueve en pequeños círculos de centro: 5 unidades a la derecha y 
	// antihorario.
	public NaveGuia crearGuiaEnemigoEn(Point unaPosicion){
		
		NaveGuia guiaEnemigo = new  NaveGuia(unaPosicion,ValoresDeNaves.guiaEnemigoTamanio,escenarioActual,ValoresDeNaves.guiaEnemigoVelocidad,ValoresDeNaves.guiaEnemigoEnergia);
		guiaEnemigo.setIdentificacion("GuiaEnemigo");
		guiaEnemigo.setEquipo(equipoDeLaNave);
		guiaEnemigo.setComando(new ComandoGuiaEnemigo(guiaEnemigo));
		VueloCompuesto vuelo = new VueloCompuesto(guiaEnemigo);
		vuelo.agregarVuelo(new VueloEnLineaRecta(guiaEnemigo,new Point(0,-1)),ValoresDeNaves.guiaEnemigoVueloLineaRectaLongitudTrayectoria);
		VueloEnCirculos subVuelo = new VueloEnCirculos(guiaEnemigo,new Point(5,0),true);
		vuelo.agregarVuelo(subVuelo,ValoresDeNaves.guiaEnemigoVueloCirculosLongitudTrayectoria);
		guiaEnemigo.setVuelo(vuelo);
		
		return guiaEnemigo;
	}
	
	// Crea un helicóptero federal en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 1, un tamaño de 5 
	// y velocidad igual a 5. Su vuelo es: línea recta 30 unidades hacia abajo, un 
	// círculo antihorario con centro 10 unidades a la derecha, y salida hacia abajo. 
	// Su penalización por destrucción es de 200.
	public NaveCivil crearHelicopteroFederalEn(Point unaPosicion){
		
		NaveCivil helicopteroFederal = new NaveCivil(unaPosicion,ValoresDeNaves.helicopteroFederalTamanio,escenarioActual,ValoresDeNaves.helicopteroFederalVelocidad,ValoresDeNaves.helicopteroFederalEnergia);
		helicopteroFederal.setIdentificacion("HelicopteroFederal");
		helicopteroFederal.setEquipo(equipoDeLaNave);
		VueloCompuesto vuelo = new VueloCompuesto(helicopteroFederal);
		vuelo.agregarVuelo(new VueloEnLineaRecta(helicopteroFederal,new Point(0,-1)),ValoresDeNaves.helicopteroFederalVueloLongitudTrayectoria);
		VueloEnCirculos _vuelo = new VueloEnCirculos(helicopteroFederal,new Point(10,0),true);
		vuelo.agregarVuelo(_vuelo,2 * (_vuelo.trayectoriaPorPeriodo()));
		vuelo.agregarVuelo(new VueloEnLineaRecta(helicopteroFederal,new Point(0,-1)),ValoresDeNaves.helicopteroFederalVueloLongitudTrayectoria);
		helicopteroFederal.setVuelo(vuelo);
		helicopteroFederal.setPenalizacion(ValoresDeNaves.helicopteroFederalPenalizacion);
		
		return helicopteroFederal;
	}
	
	public void setEquipoDeLaNave(String nuevoEquipo){
		equipoDeLaNave = nuevoEquipo;
	}
	
	public void setEscenario(Escenario nuevoEscenario){
		
		escenarioActual = nuevoEscenario;
		
		if(fabricaDeArmas != null){
			fabricaDeArmas.setEscenario(nuevoEscenario);
		}
	}
	
	public void setFabricaDeArmas(FabricaDeArmas nuevaFabricaDeArmas){
		fabricaDeArmas = nuevaFabricaDeArmas;
		
	}
	
	public void setFlotaEnemiga(Flota nuevaFlota){
		flotaEnemiga = nuevaFlota;
	}	
}
