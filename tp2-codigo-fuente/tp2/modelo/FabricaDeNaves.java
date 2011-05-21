package tp2.modelo;

import tp2.auxiliares.Point;

// La fábrica de armas puede crear las naves particulares del juego.
public class FabricaDeNaves {

	private Escenario escenarioActual;
	private String equipoDeLaNave;
	private Flota flotaEnemiga;
	private FabricaDeArmas fabricaDeArmas;
	
	// Constructor
	public FabricaDeNaves(Escenario unEscenario,String unEquipo, Flota unaFlotaEnemiga){
		
	}
	
	// Crea un Algo42 en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 500, 
	// un tamaño de 7, velocidad igual a 25 y un cañón láser. Su vuelo es en 
	// zig zag hacia abajo. Su vuelo (inicialmente quieto) y disparos pueden 
	// controlarse y puede adquirir bonos de otras naves.
	public NaveMilitarControlada crearAlgo42En(Point unaPosicion){
		return null;
	}
	
	// Crea un avión civil en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 1, un tamaño 
	// de 5 y velocidad igual a 5. Su vuelo es en línea recta hacia abajo. Su 
	// penalización por destrucción es de 300.
	public NaveCivil crearAvionCivilEn(Point unaPosicion){
		return null;
	}
	
	// Crea una avioneta en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. La misma tiene una energía de 10, un tamaño de 3, 
	// velocidad igual a 15 y un cañón láser. Su vuelo es de ida 80 unidades hacia 
	// abajo, y luego de vuelta hacia arriba. Su puntuación por destrucción es de 20.
	public NaveEnemiga crearAvionetaEn(Point unaPosicion){
		return null;
	}
	
	// Crea un bombardero en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. El mismo tiene una energía de 100, un tamaño de 7, 
	// velocidad igual a 7 y un cañón láser, un lanzacohetes y un lanzatorpedos 
	// dirigido. Su vuelo es en zig zag hacia abajo. Su puntuación por destrucción 
	// es de 30.
	public NaveEnemiga crearBombarderoEn(Point unaPosicion){
		return null;
	}
	
	// Crea un explorador en el escenario de la fábrica y con el equipo de la misma, 
	// en la posición recibida. El mismo tiene una energía de 1, un tamaño de 5, 
	// velocidad igual a 12 y ninguna arma. Su vuelo es 40 unidades hacia la derecha, 
	// luego dos círculos horarios con centro 20 unidades más abajo, y finalmente salida
	// hacia la derecha. Su puntuación por destrucción es de 50.
	public NaveEnemiga crearExploradorEn(Point unaPosicion){
		return null;
	}
	
	// Crea un grupo de tres cazas en el escenario de la fábrica y con el equipo de 
	// la misma, en la posición recibida. El mismo tiene una energía de 30, un tamaño
	// de 6, velocidad igual a 10 y un lanzatorpedos no dirigido. Su vuelo es en V 
	// hacia abajo. Su puntuación por destrucción es de 30. Devuelve la colección de 
	// los cazas.
	public NaveEnemiga[] crearGrupoCazaEn(Point unaPosicion){
		return null;
	}
	
	// Crea un guía enemigo en el escenario de la fábrica y con el equipo de la misma,
	// en la posición recibida. El mismo tiene una energía de 1000, un tamaño de 15, 
	// velocidad igual a 5 y ninguna arma. Su vuelo es: entra 50 unidades hacia abajo 
	// y luego se mueve en pequeños círculos de centro: 5 unidades a la derecha y 
	// antihorario.
	public NaveGuia crearGuiaEnemigoEn(Point unaPosicion){
		return null;
	}
	
	// Crea un helicóptero federal en el escenario de la fábrica y con el equipo de la 
	// misma, en la posición recibida. El mismo tiene una energía de 1, un tamaño de 5 
	// y velocidad igual a 5. Su vuelo es: línea recta 30 unidades hacia abajo, un 
	// círculo antihorario con centro 10 unidades a la derecha, y salida hacia abajo. 
	// Su penalización por destrucción es de 200.
	public NaveCivil crearHelicopteroFederalEn(Point unaPosicion){
		return null;
	}
	
	public void setEquipoDeLaNave(String nuevoEquipo){

	}
	
	protected void setEscenario(Escenario nuevoEscenario){
		
	}
	
	public void setFabricaDeArmas(FabricaDeArmas nuevaFabricaDeArmas){
		
	}
	
	protected void setFlotaEnemiga(Flota nuevaFlota){
		
	}	
}
