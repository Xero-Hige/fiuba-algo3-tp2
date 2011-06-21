package tp2.modelo.menues.menuCargarPartida;

import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuCargarPartida.FabricaDeDibujablesDelMenuCargarPartida;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;



public class MenuItemTexto extends MenuItem {
	
	public MenuItemTexto(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem, String texto) {
				
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(290);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde(texto),
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde("-"+texto+"")));
		this.getVistaMenuItem().setPosicionable(this);
	}

	public void cambiarTexto(String nuevoTexto){
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde(nuevoTexto),
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde("-"+nuevoTexto+"")));
		this.getVistaMenuItem().setPosicionable(this);
	}
	
	@Override
	public void seleccionar() {
		
	}
}
