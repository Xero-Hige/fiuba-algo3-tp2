package tp2.modelo;

// El juego en sí. Se encarga de iniciar los diferentes escenarios en cada nivel, 
// y de crear las flotas enemigas (y la del Algo42) cada vez que es necesario.
public abstract class Juego {

	private Escenario escenario;
	private FabricaDeNaves fabricaJugador, fabricaEnemiga;
	private Flota flotaEnemiga, flotaAliada;
	private Nave naveJugador;
	private Integer nivel;
	
	// Constructor
	public Juego() {
		
	}
	
	private void cambiarEscenarioA(Escenario nuevoEscenario) {
		
	}
	
	private void cambiarFabricaEnemigaA(FabricaDeNaves nuevoFabricaEnemiga) {
		
	}
	
	private void cambiarFabricaJugadorA(FabricaDeNaves nuevoFabricaJugador) {
		
	}
	
	private void cambiarFlotaAliadaA(Flota nuevaFlotaAliada) {
		
	}
	
	private void cambiarFlotaEnemigaA(Flota nuevaFlotaEnemiga) {
		
	}
	
	// Crea un Algo42
	public void crearNaveJugador() {
		
	}
	
	// "Crea una nueva flota enemiga. Este método se llama cada vez que comienza 
	// un nivel, y cada vez que se destruye al guía enemigo. La implementación de 
	// este método debería depender de cada nivel (escenario), y podría variar entre 
	// flota y flota del mismo nivel. Lo que sí se debe respetar es que cada flota 
	// tenga al menos 15 naves.
	public abstract void iniciarRonda();
	
	// Empieza un nuevo nivel. Se crea un nuevo escenario, la nave del jugador con 
	// su flota y se inicia la primera ronda del nivel.
	public void nuevoNivel() {
		
	}
	
	// Hace avanzar el tiempo en el escenario del juego. Si se llegó a los 1000 puntos,
	// se avanza al siguiente nivel. Si se destruyó al guía enemigo, se inicia una nueva
	// ronda, mientras las naves de la flota anterior viajan abandonando el escenario.
	public void simularDurante(Integer unTiempo) {
		
	}
	
	public Escenario getEscenario() {
		return this.escenario;
	}
	
	public FabricaDeNaves getFabricaEnemiga() {
		return this.fabricaEnemiga;
	}
	
	public FabricaDeNaves getFabricaJugador() {
		return this.fabricaJugador;
	}
	
	public Flota getFlotaAliada() {
		return this.flotaAliada;
	}
	
	public Flota getFlotaEnemiga() {
		return this.flotaEnemiga;
	}
}
