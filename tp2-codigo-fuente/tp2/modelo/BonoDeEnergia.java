package tp2.modelo;

// Es un bono que al usarse, da las armas de la nave dueña del mismo a la que lo 
// haya usado.
public class BonoDeEnergia extends Bono {

	// Constructor
	// Inicializa el bono con el tamaño recibido.
	public BonoDeEnergia(double tamanio) {
		super(tamanio);
	}
	
	@Override
	// La nave recibida toma las armas de la enemiga que tiró el bono. Si el bono 
	// ya se usó levanta una excepción.
	public void entregarBonoA(NaveMilitar unaNaveMilitar) {
		
	}	
}
