package tp2.modelo.menues.menuPrincipal;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.uba.fi.algo3.titiritero.vista.Imagen;
import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.modelo.menues.menuNuevaPartida.MenuNuevaPartida;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuPrincipal.FabricaDeDibujablesDelMenuPrincipal;
import tp2.vista.ventanas.DimensionesDeVentana;
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
		
		Escenario escenario = new Escenario(new Rectangle(140, 140));
		Mision mision = new Mision(escenario);
		
		Map<Double, Collection<ParCadenaPosicion>> datos = new HashMap<Double, Collection<ParCadenaPosicion>>();
		ParCadenaPosicion par = new ParCadenaPosicion("asdf Falta hacer parser", new Point(40, 100));
		for(int i = 0; i < 30; i++){
			Collection<ParCadenaPosicion> lista = new ArrayList<ParCadenaPosicion>();
			lista.add(par);
			datos.put((double)i, lista);
		}
		mision.generar(datos);
		this.getVentanaPrincipal().getControladorJuego().setMision(mision);
		
//		menuNuevaPartida.mostrar();
	}
}
