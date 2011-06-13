package tp2.vista.menues;

import java.util.ArrayList;

import tp2.vista.menues.menuPrincipal.VistaMenuItem;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;

public interface VistaMenuI {

	public void setPosicionable(Posicionable unPosicionable);
	public ArrayList<Dibujable> getObjetosDibujables();
	public ArrayList<VistaMenuItem> getItemsDelMenu();
	
}
