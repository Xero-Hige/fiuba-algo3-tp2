package tp2.vista.menues;

import java.util.Map;
import tp2.control.menu.ControlKeyPressMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen {

	private VentanaPrincipal ventanaPrincipal;
	private Map<VistaMenuItem,MenuI> mapDeItemsDelMenu;
	private VistaMenuItem itemActivo;
	
	public VistaMenuPrincipal(VentanaPrincipal ventanaPrincipal, Imagen imagen) {
		super(imagen);
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaPrincipal.setControlKeyPressActivo(new ControlKeyPressMenuPrincipal(this));
		this.inicializarMenu();
	}
	
	private void inicializarMenu() {
		
		VistaMenuItem itemNuevaPartida = new VistaMenuItem(
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOut(),
				(Imagen) FabricaDeDibujablesDelMenu.nuevaImagenItemNuevaPartidaOver());
		itemNuevaPartida.setPosicionable(new MenuNuevaPartida());
		this.mapDeItemsDelMenu.put(itemNuevaPartida,(MenuI) itemNuevaPartida.getPosicionable());
		
//		this.mapDeItemsDelMenu.put(new VistaMenuItem(
//				FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOut(),
//				FabricaDeDibujablesDelMenu.nuevaImagenItemCargarPartidaOver()),
//				new MenuCargarPartida());
//		
//		this.mapDeItemsDelMenu.put(new VistaMenuItem(
//				FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOut(),
//				FabricaDeDibujablesDelMenu.nuevaImagenItemCreditosOver()),
//				new MenuCreditos());
//		
//		this.mapDeItemsDelMenu.put(new VistaMenuItem(
//				FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOut(),
//				FabricaDeDibujablesDelMenu.nuevaImagenItemSalirOver()),
//				new MenuCreditos());
//		
		
		itemActivo = itemNuevaPartida;
		this.ventanaPrincipal.getControladorJuego().agregarDibujable(itemNuevaPartida);
	}
	
	public void moverSeleccionParaArriba() {
		
	}
	
	public void moverSeleccionParaAbajo() {
		
	}
	
	public void seleccionarItem() {
		
	}
	
	public void volverAMi() {
		
	}
}