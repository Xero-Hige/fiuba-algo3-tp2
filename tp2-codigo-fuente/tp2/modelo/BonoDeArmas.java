package tp2.modelo;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.modelo.excepciones.BonoUtilizado;
import tp2.persistencia.IGuardable;

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
		List<Arma> armas = this.getNaveDuenia().getArmas();
		Iterator<Arma> iter = armas.iterator();
		while(iter.hasNext()){
			Arma arma = iter.next();
			unaNave.agregarArma(arma);
		}
		this.destruir();
	}

	@Override
	public Element guardar(Element contenedor) {
		
		super.guardar(contenedor);
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		super.cargar(atributos);
		return this;
	}

}
