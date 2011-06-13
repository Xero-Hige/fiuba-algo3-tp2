package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuPrincipalItemCargarPartida extends MenuItem {
	
	public MenuPrincipalItemCargarPartida(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		this.setX((500 / 2) - (234 / 2));
		this.setY(283);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCargarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCargarPartidaOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		
	}
}
