package tp2.vista.menues.menuCreditos;

import java.util.ArrayList;

import tp2.vista.menues.VistaMenuI;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuCreditos extends Imagen implements VistaMenuI {

	public VistaMenuCreditos() {
		super((Imagen) FabricaDeDibujablesDelMenuCreditos.nuevaImagenFondoMenuCreditos());
	}
	
	@Override
	public ArrayList<Dibujable> getObjetosDibujables() {
		return null;
	}
}
