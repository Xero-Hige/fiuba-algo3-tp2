package tp2.modelo;

import java.util.Map;

import org.w3c.dom.Element;
import org.w3c.dom.Node;

import tp2.persistencia.GeneradorXml;
import tp2.persistencia.IGuardable;
import tp2.persistencia.ReconstructorDesdeXml;

/**
 * @author Martinez, Awad, Rossi: 
 * Clase que contiene un arma vinculada a su probabilidad de ser
 * elegida para ser utilizada.
 */ 
public class ArmaConProbabilidad implements IGuardable {
	
	private Arma arma;
	private double pesoProbabilidad;
	
	public ArmaConProbabilidad(Arma arma, double pesoProbabilidad) {
		this.arma = arma;
		this.pesoProbabilidad = pesoProbabilidad;
	}
	
	public void actuarDurante(double unTiempo){
		this.arma.actuarDurante(unTiempo);
	}

	public Arma getArma() {
		return arma;
	}

	public double getPesoProbabilidad() {
		return pesoProbabilidad;
	}
	
	@Override
	public Element guardar(Element contenedor) {
		
		contenedor.appendChild(GeneradorXml.generarElementoDe(arma, "arma"));
		contenedor.appendChild(GeneradorXml.generarElementoDe(pesoProbabilidad, "pesoProbabilidad"));
		return contenedor;
	}

	@Override
	public IGuardable cargar(Map<String, Node> atributos) {
		
		this.arma = (Arma) ReconstructorDesdeXml.generarObjeto(atributos.get("arma"));
		this.pesoProbabilidad = (Double) ReconstructorDesdeXml.generarObjeto(atributos.get("pesoProbabilidad"));
		return this;
	}
	
}
