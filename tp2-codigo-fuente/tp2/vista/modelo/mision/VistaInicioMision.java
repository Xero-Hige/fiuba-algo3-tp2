package tp2.vista.modelo.mision;

import java.awt.Color;
import java.awt.Font;

import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;


public class VistaInicioMision extends TextoDinamico {

	private static TextoInicioMision textoInicioMision = new TextoInicioMision();
	private static Font fuente = new Font("Arial", Font.BOLD, 25);
	
	public VistaInicioMision() {
		super(textoInicioMision, Color.white, fuente);
		textoInicioMision.setNumeroMision(1);
	}
	
	public void setNumeroDeNivelDeMision(int nivel) {
		textoInicioMision.setNumeroMision(nivel);
	}
}
