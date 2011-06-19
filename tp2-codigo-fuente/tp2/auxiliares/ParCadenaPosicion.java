package tp2.auxiliares;

public class ParCadenaPosicion {
	
	private String cadena;
	private Point posicion;

	public ParCadenaPosicion(String cadena, Point posicion){
		this.cadena = cadena;
		this.posicion = posicion;
	}

	public String getCadena() {
		return cadena;
	}

	public Point getPosicion() {
		return posicion;
	}

}
