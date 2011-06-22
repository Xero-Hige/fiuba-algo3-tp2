package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.auxiliares.Point;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

public class ComandoGuiaEnemigo implements ComandoDeNaves, IGuardable {

	private NaveGuia guiaEnemigo;
	private boolean navesDisparando;
	
	public ComandoGuiaEnemigo(NaveGuia guiaEnemigo) {
		this.guiaEnemigo = guiaEnemigo;
		this.navesDisparando = false;
	}
	
	public ComandoGuiaEnemigo() {
		super();
	}
	
	@Override
	public void comandarNaves() {
		if(this.guiaEnemigo.estaDestruido()){
			this.guiaEnemigo.getFlota().iniciarRetiradaEnDireccion(new Point(0, 1));
		}
		int tiempoEscenario = (int) this.guiaEnemigo.getEscenario().getTiempo();
		if((tiempoEscenario / 2) % 2 != 0){
			if(!this.navesDisparando){
				this.navesDisparando = true;
				this.guiaEnemigo.getFlota().iniciarFuego();	
			}
		} else {
			if(this.navesDisparando){
				this.navesDisparando = false;
				this.guiaEnemigo.getFlota().detenerFuego();	
			}
		}
	}

	@Override
	public Element guardar(Element contenedor) {
		contenedor.appendChild(GeneradorXml.generarElementoDe(guiaEnemigo, "guiaEnemigo"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(navesDisparando, "navesDisparando"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		this.guiaEnemigo = (NaveGuia) ReconstructorDesdeXml.generarObjeto(atributos.get("guiaEnemigo"));
		this.navesDisparando = (Boolean) ReconstructorDesdeXml.generarObjeto(atributos.get("navesDisparando"));
		return this;
	}

}
