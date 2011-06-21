package tp2.vista.menues.menuMision;

import tp2.vista.menues.VistaMenu;
import tp2.vista.menues.estados.FabricaDeDibujablesDeEstados;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class VistaMenuMision extends VistaMenu  {

	public VistaMenuMision() {
		super((Imagen) FabricaDeDibujablesDeEstados.nuevaImagenFondoIniciandoNuevaPartida());
	}	
}
