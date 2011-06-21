package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaNaveGuia extends Imagen {

	public VistaNaveGuia(ProyeccionSobreSuperficieDeDibujo proyeccion) {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenNaveGuia(proyeccion.getEscalaX()));
	}
}
