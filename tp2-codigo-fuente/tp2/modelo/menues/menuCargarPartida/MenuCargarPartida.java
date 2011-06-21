package tp2.modelo.menues.menuCargarPartida;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tp2.control.menues.menuCargarPartida.ControlKeyPressMenuCargarPartida;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.persistencia.ManejadorPartidasGuardadas;
import tp2.vista.menues.menuCargarPartida.VistaMenuCargarPartida;
import tp2.vista.ventanas.VentanaPrincipal;

public class MenuCargarPartida extends Menu  {
	
	List<String[]> archivos;
	int archivoActual = 0;
	MenuItemTexto cuadroDeTexto = null;
	List<MenuItemTexto> textos = new ArrayList<MenuItemTexto>();
		
	public MenuCargarPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
	
		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuCargarPartida());
		this.getVistaMenu().setPosicionable(this);
		
		archivos = ManejadorPartidasGuardadas.getListaPartidasGuardadas();
		Iterator<String[]> iter = archivos.iterator();
		MenuCargarPartida a=this;
		while (iter.hasNext()){
			String[] datos = iter.next();
			textos.add(new MenuItemTexto(ventanaPrincipal,a,datos[0]+" "+datos[1]));
		}
		
		this.cuadroDeTexto = textos.get(0);
		this.agregarItem(cuadroDeTexto);
	}
	
	public void siguienteElemento(){
		if(archivoActual<archivos.size()-1){
			archivoActual++;
			this.removerItem(cuadroDeTexto);
			cuadroDeTexto = textos.get(archivoActual);
			this.agregarItem(cuadroDeTexto);
		};
	}
	
	public void anteriorElemento(){
		if(archivoActual>0){
			archivoActual--;
			this.removerItem(cuadroDeTexto);
			cuadroDeTexto = textos.get(archivoActual);
			this.agregarItem(cuadroDeTexto);
		}
	}	
	

	@Override
	public void activarControl() {
		
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú principal.
		this.setControlKeyPress(new ControlKeyPressMenuCargarPartida(this));
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}

	@Override
	public void resetear() {
		// TODO Auto-generated method stub
		
	}
}
