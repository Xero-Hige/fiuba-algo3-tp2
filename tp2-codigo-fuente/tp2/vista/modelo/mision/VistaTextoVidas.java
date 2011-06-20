package tp2.vista.modelo.mision;

import java.awt.Color;
import java.awt.Font;

import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;

public class VistaTextoVidas extends TextoDinamico  {

	private static TextoVidas textoVidas = new TextoVidas();
	private static Font fuente = new Font("Arial", Font.PLAIN, 12);
	
	public VistaTextoVidas() {
		super(textoVidas, Color.WHITE, fuente);
		
		this.setPosicionable(new TextoVidas());	
	}
	
	public void setVidas(int cantidadVidas) {
		VistaTextoVidas.textoVidas.setVidas(cantidadVidas);
	}
}
