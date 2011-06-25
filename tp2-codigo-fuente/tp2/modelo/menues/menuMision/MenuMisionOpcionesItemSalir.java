package tp2.modelo.menues.menuMision;

import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuMision.FabricaDeDibujablesDelMenuMision;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MenuMisionOpcionesItemSalir extends MenuItem {
	
	public MenuMisionOpcionesItemSalir(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(285);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemSalirOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		
		this.getVentanaPrincipal().getControladorJuego().getAudioPartida().stop();
		this.getMenuDelItem().ocultar();
		this.getVentanaPrincipal().getControladorJuego().finalizarJuego();
		this.getMenuDelItem().getMenuPadre().getMenuPadre().getMenuPadre().mostrar();
		((MenuPrincipal)(this.getMenuDelItem().getMenuPadre().getMenuPadre().getMenuPadre())).getAudio().play();
	}
}