package tp2.modelo;

public class PuntuacionPorPorcentaje implements Puntuacion {

	private Escenario escenario;
	private double porcentaje;
	
	public PuntuacionPorPorcentaje(Escenario escenario, double porcentaje) {
		super();
		this.escenario = escenario;
		this.porcentaje = porcentaje;
	}

	@Override
	public int getPuntuacion() {
		return (int)(this.escenario.getPuntuacion() * this.porcentaje);
	}

}
