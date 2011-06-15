package tp2.vista.menues;

import java.util.ArrayList;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenu extends Imagen implements VistaMenuI {

	public ArrayList<Dibujable> objetosDibujables = new ArrayList<Dibujable>();
	
	public VistaMenu() {}
	
	public VistaMenu(Imagen unaImagen) {
		super(unaImagen);
	}
	
	@Override
	public ArrayList<Dibujable> getObjetosDibujables() {
		return this.objetosDibujables;
	}
	
	@Override
	public void agregarObjetoDibujable(Dibujable unObjetoDibujable) {
		this.objetosDibujables.add(unObjetoDibujable);
	}

}
