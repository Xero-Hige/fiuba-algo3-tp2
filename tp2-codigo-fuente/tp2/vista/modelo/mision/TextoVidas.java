package tp2.vista.modelo.mision;

import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;


public class TextoVidas implements ObjetoDeTexto, Posicionable {

	private int x;
	private int y;
	private String txtVidas = "Vidas:";
	private int vidas = 0;
	
	public TextoVidas() {
		this.x = 20;
		this.y = 19;
	}
	
	public void setVidas(int cantidadVidas) {
		vidas = cantidadVidas;
	}
	
	@Override
	public String getTexto() {
		
		return txtVidas + " " + vidas;
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