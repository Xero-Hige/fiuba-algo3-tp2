package tp2.modelo.menues;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.vista.MouseClickController;

public class MenuNuevaPartida implements MenuI, Posicionable {

	private int x;
	private int y;
	
	public MenuNuevaPartida() {
		this.x = ((500 / 2) - (234 / 2));
		this.y = 243;
	}
	
	@Override
	public void entrarEnEscena() {
		// TODO Auto-generated method stub
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
	public KeyPressedObservador getControlKeyPressed() {
		return null;
	}

	@Override
	public MouseClickController getControlMouseClick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Dibujable> getObjetosDibujablesPropios() {
		// TODO Auto-generated method stub
		return null;
	}
}
