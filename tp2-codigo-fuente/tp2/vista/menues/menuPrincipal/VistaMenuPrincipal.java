package tp2.vista.menues.menuPrincipal;

import java.util.ArrayList;
import tp2.vista.menues.VistaMenuI;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class VistaMenuPrincipal extends Imagen implements VistaMenuI {

	// En esta guardamos todos los objetos dibujables que contiene el menú.
	private ArrayList<Dibujable> objetosDibujablesDelMenu;

	
	public VistaMenuPrincipal() {
		
		super((Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenFondoMenuPrincipal());
		objetosDibujablesDelMenu = new ArrayList<Dibujable>();
	}
	
	public ArrayList<Dibujable> getObjetosDibujables() {
		return this.objetosDibujablesDelMenu;
	}
}