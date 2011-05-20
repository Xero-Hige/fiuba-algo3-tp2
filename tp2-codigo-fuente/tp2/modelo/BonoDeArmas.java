package tp2.modelo;

// Es un bono que da la energía máxima de la nave dueña a aquella que lo use.
public class BonoDeArmas extends Bono {

	// Constructor
	// Inicializa el bono con el tamaño recibido.
	public BonoDeArmas(double tamanio) {
		super(tamanio);
	}
	
	@Override
	// La nave recibida toma las armas de la enemiga que tiró el bono. Si el bono 
	// ya se usó levanta una excepción.
	public void entregarBonoA(Nave unaNave) {
		
	}
}
