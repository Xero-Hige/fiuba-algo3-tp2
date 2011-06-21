package tp2.modelo.menues.menuPrincipal;

import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuComoJugar.MenuComoJugar;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MenuPrincipalItemComoJugar extends MenuItem {
	
	public MenuPrincipalItemComoJugar(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(330);

		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemComoJugarOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemComoJugarOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		MenuComoJugar menuComoJugar = new MenuComoJugar(this.getVentanaPrincipal(), this.getMenuDelItem());
		menuComoJugar.mostrar();
	}
}
