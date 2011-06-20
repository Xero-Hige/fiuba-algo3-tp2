package tp2.vista.modelo.mision;

import tp2.vista.ventanas.DimensionesDeVentana;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

public class TextoPuntuacion implements ObjetoDeTexto, Posicionable {

	private int x;
	private int y;
	private String txtPuntuacion = "Puntos:";
	private int puntaje = 0;
	
	public TextoPuntuacion() {
		this.x = DimensionesDeVentana.ancho - 90;
		this.y = 19;
	}
	
	public void setPuntaje(int nuevoPuntaje) {
		puntaje = nuevoPuntaje;
	}
	
	@Override
	public String getTexto() {
		
		String format = String.format("%%0%dd", 4); 
		return txtPuntuacion + " " + String.format(format, puntaje);
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}
}