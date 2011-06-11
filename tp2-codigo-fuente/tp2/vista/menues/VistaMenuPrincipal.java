package tp2.vista.menues;

import tp2.control.menu.ControlKeyPressMenuPrincipal;
import tp2.vista.ventanas.VentanaPrincipal;
import ar.uba.fi.algo3.titiritero.vista.Imagen;

public class VistaMenuPrincipal extends Imagen {

	private VentanaPrincipal ventanaPrincipal;
	
	public VistaMenuPrincipal(VentanaPrincipal ventanaPrincipal) {
		this.setNombreArchivoImagen("../imagenes/menues/menu-principal-fondo.jpg");
		this.ventanaPrincipal = ventanaPrincipal;
		this.ventanaPrincipal.setControlKeyPressActivo(new ControlKeyPressMenuPrincipal(this));
	}
	
	public void moverSeleccionParaArriba() {
		
	}
	
	public void moverSeleccionParaAbajo() {
		
	}
	
	public void seleccionarItem() {
		
	}
	
}
