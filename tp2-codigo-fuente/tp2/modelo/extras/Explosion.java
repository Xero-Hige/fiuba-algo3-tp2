package tp2.modelo.extras;

import ar.uba.fi.algo3.titiritero.ObjetoVivo;
import ar.uba.fi.algo3.titiritero.Posicionable;

public class Explosion  implements Posicionable, ObjetoVivo {

	private int x;
	private int y;
	private int velocidad;
	
	public Explosion (int x, int y, int velocidad) {
		
		this.x = x;
		this.y = y;
		this.velocidad = velocidad;
	}
	
	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void vivir() {
		this.y = this.y + this.velocidad;
	}

}