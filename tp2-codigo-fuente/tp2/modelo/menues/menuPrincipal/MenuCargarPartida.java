package tp2.modelo.menues.menuCargarPartida;

import java.util.List;

import tp2.control.menues.menuCargarPartida.ControlKeyPressMenuCargarPartida;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.persistencia.ManejadorPartidasGuardadas;
import tp2.vista.menues.menuCargarPartida.VistaMenuCargarPartida;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuCargarPartida extends Menu  {
	
	List<String[]> archivos;
	int archivoActual = -1;
	MenuItemTexto cuadroDeTexto = null;
		
	public MenuCargarPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
	
		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuCargarPartida());
		this.getVistaMenu().setPosicionable(this);
		
		archivos = ManejadorPartidasGuardadas.getListaPartidasGuardadas();
		this.cuadroDeTexto = new MenuItemTexto(this.getVentanaPrincipal(), this,"");
		
		siguienteElemento();
	}
	
	private void recargarCuadroTexto(String texto) {
		this.cuadroDeTexto.cambiarTexto(texto);
	}

	private String[] getArchivoActual() {
		return archivos.get(archivoActual);
	}

	public void siguienteElemento(){
		if(archivoActual<archivos.size()-1){
			archivoActual++;
		}
		
		//Exception
		
		String[] texto = getArchivoActual();
		this.recargarCuadroTexto(texto[0]+" "+texto[1]);
		this.agregarItem(cuadroDeTexto);
	}
	
	public void anteriorElemento(){
		if(archivoActual>0){
			archivoActual--;
		}
		String[] texto = getArchivoActual();
		this.recargarCuadroTexto(texto[0]+" "+texto[1]);
		this.agregarItem(cuadroDeTexto);
	}
	
	public void resetear() {
		
		//Todo
	}
	
	@Override
	public void activarControl() {
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuCargarPartida(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
}
