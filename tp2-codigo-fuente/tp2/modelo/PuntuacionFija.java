package tp2.modelo;

public class PuntuacionFija implements Puntuacion {
	
	private int puntuacion;

	public PuntuacionFija(int puntuacion) {
		super();
		this.puntuacion = puntuacion;
	}

	@Override
	public int getPuntuacion() {
		return this.puntuacion;
	}

}
