package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaHelicoptero  extends Imagen {

	public VistaHelicoptero() {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenHelicoptero());
	}
}