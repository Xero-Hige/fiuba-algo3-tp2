package tp2.modelo.menues.menuMision;

import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuMision.FabricaDeDibujablesDelMenuMision;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MenuMisionOpcionesItemReanudar extends MenuItem {
	
	public MenuMisionOpcionesItemReanudar(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(205);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemReanudarOut(),
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemReanudarOver()));
		this.getVistaMenuItem().setPosicionable(this);
		this.getVistaMenuItem().itemOver();
	}

	@Override
	public void seleccionar() {
		
		this.getVentanaPrincipal().getControladorJuego().getPartida().reanudar();
		this.getMenuDelItem().ocultar();
		this.getMenuDelItem().getMenuPadre().activarControl();
	}
}