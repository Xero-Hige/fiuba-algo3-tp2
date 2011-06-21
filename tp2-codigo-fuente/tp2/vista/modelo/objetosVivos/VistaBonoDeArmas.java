package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaBonoDeArmas extends Imagen {

	public VistaBonoDeArmas(ProyeccionSobreSuperficieDeDibujo proyeccion) {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenBonoDeArmas(proyeccion.getEscalaX()));
	}
}
