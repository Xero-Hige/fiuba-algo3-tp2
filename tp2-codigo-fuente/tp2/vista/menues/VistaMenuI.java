package tp2.vista.menues;

import java.util.ArrayList;


import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;

public interface VistaMenuI {

	public void setPosicionable(Posicionable unPosicionable);
	public ArrayList<Dibujable> getObjetosDibujables();
	public void agregarObjetoDibujable(Dibujable unObjetoDibujable);
	
}
