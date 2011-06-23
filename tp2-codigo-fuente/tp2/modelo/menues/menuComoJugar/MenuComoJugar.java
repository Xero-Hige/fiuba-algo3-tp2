package tp2.modelo.menues.menuComoJugar;

import tp2.control.menues.menuComoJugar.ControlKeyPressMenuComoJugar;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuComoJugar.VistaMenuComoJugar;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuComoJugar extends Menu {
	
	public MenuComoJugar(VentanaPrincipal ventanaPrincipal, MenuI menuPadre){
		
		super(ventanaPrincipal, menuPadre);

		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuComoJugar());
		this.getVistaMenu().setPosicionable(this);
	}

	@Override
	public void resetear() {}
	
	@Override
	public void activarControl() {

		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuComoJugar(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
	
	@Override
	public void realizarAlOcultar() {}

	@Override
	public void realizarAlMostrar() {}
}
