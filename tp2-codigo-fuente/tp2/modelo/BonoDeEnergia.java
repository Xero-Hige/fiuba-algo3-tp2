package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.modelo.especificaciones.ValoresDeBonos;
import tp2.modelo.excepciones.BonoUtilizado;
import tp2.persistencia.IGuardable;

// Es un bono que al usarse, da las armas de la nave due�a del mismo a la que lo 
// haya usado.
public class BonoDeEnergia extends Bono {
	
	
	// Constructor
	// Inicializa el bono con el tama�o recibido.
	public BonoDeEnergia(double tamanio) {
		super(tamanio);
		this.setIdentificacion(ValoresDeBonos.bonoDeEnergiaIdentificacion);
	}
	
	public BonoDeEnergia() {
		super();
	}
	
	@Override
	// La nave recibida toma las armas de la enemiga que tir� el bono. Si el bono 
	// ya se us� levanta una excepci�n.
	public void entregarBonoA(NaveMilitar unaNaveMilitar) {
		if (this.fueUsado()){
			throw new BonoUtilizado("El bono ya ha sido utilizado previamente");
		}
		unaNaveMilitar.recuperarEnergiaEn(this.getNaveDuenia().getMaxEnergia());
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
