package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuPrincipalItemSalir extends MenuItem {
	
	public MenuPrincipalItemSalir(VentanaPrincipal ventanaPrincipal) {
		super(ventanaPrincipal);
		this.setX((500 / 2) - (234 / 2));
		this.setY(363);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemSalirOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		
	}
}
