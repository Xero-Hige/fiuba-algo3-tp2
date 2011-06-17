package tp2.modelo;

import tp2.auxiliares.Point;
import tp2.modelo.especificaciones.ValoresDeArmas;

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
		Arma canionLaser = new Arma(new Point(0,0), escenarioActual, ValoresDeArmas.canionLaserVelocidad, ValoresDeArmas.canionLaserFrecuencia, new Point(0,-1), "CanionLaser");
		Proyectil laser = new Proyectil(new Point(0,0), ValoresDeArmas.canionLaserProyectilTamanio, ValoresDeArmas.canionLaserProyectilVelocidad, ValoresDeArmas.canionLaserProyectilDanio);
		canionLaser.setModeloDeProyectil(laser);
		return canionLaser;
	}
	
	// Crea un lanzacohetes (identificación: LanzaCohetes) que tiene carga 
	// inicial igual a 10, velocidad de disparo 50, frecuencia 2 y daño de 
	// proyectil 50. Devuelve el lanzacohetes, apuntando por defecto hacia 
	// abajo y posicionada en el origen.
	public ArmaLimitada crearLanzaCohetes() {
		ArmaLimitada lanzacohetes = new ArmaLimitada(new Point(0,0), escenarioActual, ValoresDeArmas.lanzaCohetesVelocidad, ValoresDeArmas.lanzaCohetesFrecuencia, new Point(0,-1), "LanzaCohetes");
		lanzacohetes.cargarCon(ValoresDeArmas.lanzaCohetesCantidadProyectiles);
		Proyectil cohete = new Proyectil(new Point(0,0), ValoresDeArmas.lanzaCohetesProyectilTamanio, ValoresDeArmas.lanzaCohetesProyectilVelocidad, ValoresDeArmas.lanzaCohetesProyectilDanio);
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
		ArmaDirigida lanzatorpedos = new ArmaDirigida(new Point(0,0), escenarioActual, ValoresDeArmas.lanzaTorpedosVelocidad, ValoresDeArmas.lanzaTorpedosFrecuencia, new Point(0,-1), "LanzaTorpedos");
		lanzatorpedos.cargarCon(ValoresDeArmas.lanzaTorpedosCantidadProyectiles);
		Proyectil torpedo = new Proyectil(new Point(0,0), ValoresDeArmas.lanzaTorpedosProyectilTamanio, ValoresDeArmas.lanzaTorpedosProyectilVelocidad, ValoresDeArmas.lanzaTorpedosProyectilDanio);
		lanzatorpedos.setModeloDeProyectil(torpedo);
		return lanzatorpedos;
	}

	public void setEscenario(Escenario nuevoEscenario) {
		escenarioActual = nuevoEscenario;
	}
}
