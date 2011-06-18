package tp2.modelo.menues.menuPrincipal;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.modelo.especificaciones.DimensionesDeVentana;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuNuevaPartida.MenuNuevaPartida;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuPrincipalItemNuevaPartida extends MenuItem {
	
	public MenuPrincipalItemNuevaPartida(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(250);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenuPrincipal.nuevaImagenItemNuevaPartidaOver()));
		this.getVistaMenuItem().setPosicionable(this);
		this.getVistaMenuItem().itemOver();
	}

	@Override
	public void seleccionar() {
		MenuNuevaPartida menuNuevaPartida = new MenuNuevaPartida(this.getVentanaPrincipal(), this.getMenuDelItem());
		menuNuevaPartida.mostrar();
	}
}
