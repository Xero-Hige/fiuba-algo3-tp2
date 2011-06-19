package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaBombardero  extends Imagen {

	public VistaBombardero(ProyeccionSobreSuperficieDeDibujo proyeccion) {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenBombardero(proyeccion.getEscalaX()));
	}
}