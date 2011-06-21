package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuCreditos.MenuCreditos;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuPrincipalItemCreditos extends MenuItem {
	
	public MenuPrincipalItemCreditos(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(370);

		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		MenuCreditos menuCreditos = new MenuCreditos(this.getVentanaPrincipal(), this.getMenuDelItem());
		menuCreditos.mostrar();
	}
}
