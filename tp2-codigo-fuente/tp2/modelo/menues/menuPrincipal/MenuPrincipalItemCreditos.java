package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuCreditos.MenuCreditos;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuPrincipalItemCreditos extends MenuItem {

	private MenuI menuActual;
	
	public MenuPrincipalItemCreditos(VentanaPrincipal ventanaPrincipal, MenuI menuActual) {
		super(ventanaPrincipal);
		this.setX((500 / 2) - (234 / 2));
		this.setY(323);
		this.menuActual = menuActual;
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemCreditosOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		MenuCreditos menuCreditos = new MenuCreditos(this.getVentanaPrincipal(), this.menuActual);
		menuCreditos.mostrar();
	}
}