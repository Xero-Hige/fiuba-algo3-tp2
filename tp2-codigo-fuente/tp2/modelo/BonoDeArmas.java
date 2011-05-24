package tp2.modelo;

import java.util.Iterator;
import java.util.List;

import tp2.modelo.excepciones.BonoUtilizado;

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
	public void entregarBonoA(NaveMilitar unaNave) {
		if (this.fueUsado()){
			throw new BonoUtilizado("El bono ya ha sido utilizado previamente");
		}
		List<Arma> armas = naveDuenia.getArmas();
		Iterator<Arma> iter = armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next();
			unaNave.agregarArma(arma);
		}
		this.destruir();
	}	

}
