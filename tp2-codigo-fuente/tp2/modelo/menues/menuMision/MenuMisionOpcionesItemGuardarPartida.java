package tp2.modelo.menues.menuMision;

import org.w3c.dom.Document;

import tp2.modelo.Partida;
import tp2.modelo.menues.MenuI;
import tp2.modelo.menues.MenuItem;
import tp2.persistencia.BuscadorDeArchivos;
import tp2.persistencia.GeneradorXml;
import tp2.persistencia.ManejadorPartidasGuardadas;
import tp2.vista.menues.VistaMenuItem;
import tp2.vista.menues.menuMision.FabricaDeDibujablesDelMenuMision;
import tp2.vista.ventanas.DimensionesDeVentana;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class MenuMisionOpcionesItemGuardarPartida extends MenuItem {
	
	public MenuMisionOpcionesItemGuardarPartida(VentanaPrincipal ventanaPrincipal, MenuI menuDelItem) {
		
		super(ventanaPrincipal, menuDelItem);
		
		// Establecemos el item sobre la pantalla con sus respectivas coordenadas de alineación.
		this.setX(DimensionesDeVentana.centroX);
		this.setY(245);
		
		this.setVistaMenuItem(new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemGuardarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenuMision.nuevaImagenItemGuardarPartidaOver()));
		this.getVistaMenuItem().setPosicionable(this);
	}

	@Override
	public void seleccionar() {
		
		Partida partida = this.getVentanaPrincipal().getControladorJuego().getPartida();
		int numeroDePartida = BuscadorDeArchivos.getArchivos(ManejadorPartidasGuardadas.getPathSaves(), "save").size() + 1;
		Document documento = GeneradorXml.generarPersistenciaDe(partida, "Partida", "Esta es una partida de Algo42.");
		GeneradorXml.grabar(documento, ManejadorPartidasGuardadas.getPathSaves() + String.format("/partida_%04d.save", numeroDePartida));
		
		partida.reanudar();
		this.getMenuDelItem().ocultar();
		this.getMenuDelItem().getMenuPadre().activarControl();
	}
}