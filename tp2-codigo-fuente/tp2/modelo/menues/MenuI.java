package tp2.modelo.menues;

import java.util.ArrayList;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.vista.MouseClickController;

public interface MenuI {

	public KeyPressedObservador getControlKeyPressed();
	public MouseClickController getControlMouseClick();
	public ArrayList<Dibujable> getObjetosDibujablesPropios();
	public void entrarEnEscena();
}
