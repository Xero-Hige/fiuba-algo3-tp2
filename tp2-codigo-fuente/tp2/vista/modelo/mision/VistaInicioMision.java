package tp2.vista.modelo.mision;

import java.awt.Color;
import java.awt.Font;

import tp2.modelo.extras.InicioMision;

import ar.uba.fi.algo3.titiritero.vista.TextoDinamico;


public class VistaInicioMision extends TextoDinamico {

	private static TextoInicioMision textoInicioMision = new TextoInicioMision();
	private static Font fuente = new Font("Arial", Font.BOLD, 25);
	private int cantidadDeCiclosVisible = 200;
	private int ciclosCorridos;
	private boolean enEscena;
	private boolean salioDeEscena;
	
	public VistaInicioMision() {
		super(textoInicioMision, Color.white, fuente);
		this.setPosicionable(new InicioMision());
		ciclosCorridos = cantidadDeCiclosVisible;
		enEscena = true;
		salioDeEscena = false;
	}
	
	public void setNumeroDeMision(int nivel) {
		textoInicioMision.setNumeroMision(nivel);
	}
	
	public void correrCiclo() {
		ciclosCorridos -= 1;
		
		if (ciclosCorridos <= 0) {
			enEscena = false;
		}
	}
	
	public boolean enEscena() {
		return enEscena;		
	}
	
	public void salirDeEscena() {
		salioDeEscena = true;
	}
	
	public boolean salioDeEscena() {
		return salioDeEscena;
	}
}
