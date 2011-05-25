package tp2.modelo;

import tp2.auxiliares.Point;

// La fábrica de armas puede crear las armas particulares del juego.
public class FabricaDeArmas {

	private Escenario escenarioActual;
		
	// Constructor
	public FabricaDeArmas(Escenario unEscenario) {
		escenarioActual = unEscenario;
	}
	
	// Crea un cañón láser (identificación: CanonLaser) que tiene carga 
	// infinita, velocidad de disparo 100, daño de proyectil 10 y frecuencia 
	// de disparo 5. Devuelve el cañón, apuntando por defecto hacia abajo y 
	// posicionado en el origen.
	public Arma crearCanionLaser() {
		Arma canionLaser = new Arma(new Point(0,0),escenarioActual,100,5,new Point(0,-1),"CanonLaser");
		Proyectil laser = new Proyectil(new Point(0,0),0.1,0,10);
		canionLaser.setModeloDeProyectil(laser);
		return canionLaser;
	}
	
	// Crea un lanzacohetes (identificación: LanzaCohetes) que tiene carga 
	// inicial igual a 10, velocidad de disparo 50, frecuencia 2 y daño de 
	// proyectil 50. Devuelve el lanzacohetes, apuntando por defecto hacia 
	// abajo y posicionada en el origen.
	public ArmaLimitada crearLanzaCohetes() {
		ArmaLimitada lanzacohetes = new ArmaLimitada(new Point(0,0),escenarioActual,50,2,new Point(0,-1),"LanzaCohetes");
		lanzacohetes.cargarCon(10);
		Proyectil cohete = new Proyectil(new Point(0,0),0.5,0,50);
		lanzacohetes.setModeloDeProyectil(cohete);
		return lanzacohetes;
	}
	
	// Crea un lanzatorpedos (identificación: LanzaTorpedos) que tiene carga 
	// inicial igual a 5, velocidad de disparo 20, frecuencia 0,5 y daño de 
	// proyectil 150. Esta arma es opcionalmente dirigida, y se le puede 
	// asignar una flota objetivo para que cada vez que dispare un torpedo 
	// el mismo persiga a una nave de esa flota. Devuelve el lanzatorpedos, 
	// apuntando por defecto hacia abajo.
	public ArmaDirigida crearLanzaTorpedos() {
		ArmaDirigida lanzatorpedos = new ArmaDirigida(new Point(0,0),escenarioActual,20,0.5,new Point(0,-1),"LanzaTorpedos");
		lanzatorpedos.cargarCon(5);
		Proyectil torpedo =new Proyectil(new Point(0,0),0.1,0,150);
		lanzatorpedos.setModeloDeProyectil(torpedo);
		return lanzatorpedos;
	}

	public void setEscenario(Escenario nuevoEscenario) {
		escenarioActual = nuevoEscenario;
	}
}
