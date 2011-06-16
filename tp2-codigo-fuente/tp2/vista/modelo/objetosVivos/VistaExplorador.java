package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaExplorador  extends Imagen {

	public VistaExplorador() {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenExplorador());
	}
}