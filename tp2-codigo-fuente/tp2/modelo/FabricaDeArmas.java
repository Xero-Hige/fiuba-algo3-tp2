package tp2.modelo;

// La fábrica de armas puede crear las armas particulares del juego.
public class FabricaDeArmas {

	private Escenario escenarioActual;
		
	// Constructor
	public FabricaDeArmas(Escenario unEscenario) {
		
	}
	
	private void cambiarEscenarioA(Escenario otroEscenario) {
		
	}
	
	// Crea un cañón láser (identificación: CanonLaser) que tiene carga 
	// infinita, velocidad de disparo 100, daño de proyectil 10 y frecuencia 
	// de disparo 5. Devuelve el cañón, apuntando por defecto hacia abajo y 
	// posicionado en el origen.
	public Arma crearCanionLaser() {
		return null;
	}
	
	// Crea un lanzacohetes (identificación: LanzaCohetes) que tiene carga 
	// inicial igual a 10, velocidad de disparo 50, frecuencia 2 y daño de 
	// proyectil 50. Devuelve el lanzacohetes, apuntando por defecto hacia 
	// abajo y posicionada en el origen.
	public ArmaLimitada crearLanzaCohetes() {
		return null;
	}
	
	// Crea un lanzatorpedos (identificación: LanzaTorpedos) que tiene carga 
	// inicial igual a 5, velocidad de disparo 20, frecuencia 0,5 y daño de 
	// proyectil 150. Esta arma es opcionalmente dirigida, y se le puede 
	// asignar una flota objetivo para que cada vez que dispare un torpedo 
	// el mismo persiga a una nave de esa flota. Devuelve el lanzatorpedos, 
	// apuntando por defecto hacia abajo.
	public ArmaDirigida crearLanzaTorpedos() {
		return null;
	}

	public void setEscenario(Escenario nuevoEscenario) {
		escenarioActual = nuevoEscenario;
	}
}
