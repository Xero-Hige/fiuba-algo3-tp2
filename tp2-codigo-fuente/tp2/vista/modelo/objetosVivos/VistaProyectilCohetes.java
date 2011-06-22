package tp2.vista.modelo.objetosVivos;

import tp2.vista.modelo.FabricaDeDibujablesDelModelo;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaProyectilCohetes extends Imagen {

	public VistaProyectilCohetes(ProyeccionSobreSuperficieDeDibujo proyeccion) {
			
		this.setImagenDiferente((Imagen) FabricaDeDibujablesDelModelo.nuevaImagenProyectilCohetes(proyeccion.getEscalaX()));
	}
}