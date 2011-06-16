package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaCivil  extends Imagen {

	public VistaCivil() {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenCivil());
	}
}