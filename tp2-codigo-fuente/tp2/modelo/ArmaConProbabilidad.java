package tp2.modelo;

/**
 * @author Martinez, Awad, Rossi: 
 * Clase que contiene un arma vinculada a su probabilidad de ser
 * elegida para ser utilizada.
 */ 
public class ArmaConProbabilidad {
	
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
	
}
