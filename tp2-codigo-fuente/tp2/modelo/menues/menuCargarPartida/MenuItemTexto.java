package tp2.modelo.menues.menuCargarPartida;

import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuCargarPartida.FabricaDeDibujablesDelMenuCargarPartida;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;



public class MenuItemTexto extends MenuItem {
	
	private String texto;

	public MenuItemTexto(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem, String texto,int posicion) {
				
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(290);
		if (texto != null){
			this.texto = texto.split("\\s")[0];
		}
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde(texto),
				(Imagen) FabricaDeDibujablesDelMenuCargarPartida.nuevaImagenDesde(texto)));
		this.getVistaMenuItem().setPosicionable(this);
	}
	
	public void setPosicion(int y){
		this.setY(y);
	}
	
	@Override
	public void seleccionar() {
		
	}

	public String getTexto() {
		return this.texto;
	}
}
