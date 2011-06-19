package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaAvioneta  extends Imagen {

	public VistaAvioneta(ProyeccionSobreSuperficieDeDibujo proyeccion) {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenAvioneta(proyeccion.getEscalaX()));
	}
}