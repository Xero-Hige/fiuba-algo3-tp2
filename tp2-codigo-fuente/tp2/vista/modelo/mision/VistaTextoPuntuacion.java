package tp2.vista.modelo.mision;

import java.awt.Color;
import java.awt.Font;
import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;


public class VistaTextoPuntuacion extends TextoDinamico  {

	private static TextoPuntuacion textoPuntuacion = new TextoPuntuacion();
	private static Font fuente = new Font("Arial", Font.PLAIN, 12);
	
	public VistaTextoPuntuacion() {
		super(textoPuntuacion, Color.WHITE, fuente);
		
		this.setPosicionable(new TextoPuntuacion());	
	}
	
	public void setPuntaje(int nuevoPuntaje) {
		VistaTextoPuntuacion.textoPuntuacion.setPuntaje(nuevoPuntaje);
	}
}
