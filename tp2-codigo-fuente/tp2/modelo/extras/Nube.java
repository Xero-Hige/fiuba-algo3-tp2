package tp2.modelo.extras;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Nube implements Posicionable, ObjetoVivo {

	private int xIni;
	private int yIni;
	private int yFin;
	private int x;
	private int y;
	private int velocidad;
	
	public Nube (int posicionInicioX, int posicionInicioY, int posicionFinY, int velocidad) {
		
		this.xIni = posicionInicioX;
		this.yIni = posicionInicioY;
		this.yFin = posicionFinY;
		this.x = this.xIni;
		this.y = this.yIni;
		
		this.velocidad = velocidad;
	}
	
	@Override
	public void vivir() {
		
		if (this.y > this.yFin)
			this.y = this.yIni;
		
		this.y = this.y + this.velocidad;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

}
