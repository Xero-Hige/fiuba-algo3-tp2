package tp2.vista.menues;

import java.util.ArrayList;

import tp2.control.menu.ControlKeyPressMenuPrincipal;
import tp2.modelo.menues.*;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen {

	// Guardamos una referencia a la ventana en la que estamos.
	private VentanaPrincipal ventanaPrincipal;
	// En esta guardamos todos los objetos dibujables que contiene el menú.
	private ArrayList<Dibujable> objetosDibujablesDelMenu;
	// En esta guardamos solamente los objetos que son items del menú.
	private ArrayList<VistaMenuItem> itemsDelMenu;
	
	public VistaMenuPrincipal(VentanaPrincipal ventanaPrincipal, Imagen imagen) {
		super(imagen);
		objetosDibujablesDelMenu = new ArrayList<Dibujable>();
		this.itemsDelMenu = new ArrayList<VistaMenuItem>();
		this.ventanaPrincipal = ventanaPrincipal;
		this.inicializar();
	}
	
	private void inicializar() {
		
		// Item para opción "Nueva Partida"
		VistaMenuItem VistaItemNuevaPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOver());
		VistaItemNuevaPartida.setPosicionable(new MenuItemNuevaPartida());
		objetosDibujablesDelMenu.add(VistaItemNuevaPartida);
		itemsDelMenu.add(VistaItemNuevaPartida);
		VistaItemNuevaPartida.itemOver();
		
		// Item para opción "Cargar Partida"
		VistaMenuItem VistaItemCargarPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOver());
		VistaItemCargarPartida.setPosicionable(new MenuItemCargarPartida());
		objetosDibujablesDelMenu.add(VistaItemCargarPartida);
		itemsDelMenu.add(VistaItemCargarPartida);
		
		// Item para opción "Créditos"
		VistaMenuItem VistaItemCreditos = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOver());
		VistaItemCreditos.setPosicionable(new MenuItemCreditos());
		objetosDibujablesDelMenu.add(VistaItemCreditos);
		itemsDelMenu.add(VistaItemCreditos);
		
		// Item para opción "Salir"
		VistaMenuItem VistaItemSalir = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOver());
		VistaItemSalir.setPosicionable(new MenuItemSalir());
		objetosDibujablesDelMenu.add(VistaItemSalir);
		itemsDelMenu.add(VistaItemSalir);
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.ventanaPrincipal.setControlKeyPressActivo(new ControlKeyPressMenuPrincipal(this.itemsDelMenu));
		this.ventanaPrincipal.activarKeyPressObservador();
	}
	
	public ArrayList<Dibujable> getObjetosDibujablesPropios() {
		return this.objetosDibujablesDelMenu;
	}
	
	public void volverAMi() {
		
	}
}