package tp2.modelo;

// Esta clase define el comportamiento receptor de una nave militar controlada 
// en un choque frente a los demás objetos del espacio.
public class ChoqueDeNaveMilitarControlada extends ChoqueDeNave {

	// Constructor
	public ChoqueDeNaveMilitarControlada(NaveMilitarControlada unaNaveMilitarControlada) {
		super(unaNaveMilitarControlada);
	}
	
	@Override
	// Una nave militar controlada puede recolectar los bonos al chocar con ellos.
	public void sufrirChoqueDeBono(Bono unBono) {
		
	}
}
