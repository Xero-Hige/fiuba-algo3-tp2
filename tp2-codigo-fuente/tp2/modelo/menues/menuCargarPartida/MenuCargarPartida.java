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
	
	
	MenuItemTexto cuadroDeTexto1 = null;
	MenuItemTexto cuadroDeTexto2 = null;
	MenuItemTexto cuadroDeTexto3 = null;
	MenuItemTexto cuadroDeTexto4 = null;
	MenuItemTexto cuadroDeTexto5 = null;
	
	List<MenuItemTexto> textos = new ArrayList<MenuItemTexto>();
	
	//Las posiciones donde se ponen cada uno de los items
	int[] posiciones = {105,155,200,246,296};
		
	public MenuCargarPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
	
		// Creamos la vista del menu principal
		this.setVistaMenu(new VistaMenuCargarPartida());
		this.getVistaMenu().setPosicionable(this);
		
		archivos = ManejadorPartidasGuardadas.getListaPartidasGuardadas();
		Iterator<String[]> iter = archivos.iterator();
		MenuCargarPartida a=this;
		//Agrego 2 vacias al principio
		for(int i=0;i<2;i++){
			textos.add(new MenuItemTexto(ventanaPrincipal,a,"", 0));
		}		
		//Agrego los elementos
		while (iter.hasNext()){
			String[] datos = iter.next();
			textos.add(new MenuItemTexto(ventanaPrincipal,a,datos[0]+" "+datos[1], 0));
		}
		//Agrego 3 por si no hay saves
		for(int i=0;i<3;i++){
			textos.add(new MenuItemTexto(ventanaPrincipal,a,"", 0));
		}
		
		setElementosDesde(0);		
		actualizarPosiciones();

	}
	
	private void actualizarPosiciones() {
		if (this.cuadroDeTexto1 == null){
			return;
		}
		
		this.cuadroDeTexto1.setPosicion(posiciones[0]);
		this.cuadroDeTexto2.setPosicion(posiciones[1]);
		this.cuadroDeTexto3.setPosicion(posiciones[2]);
		this.cuadroDeTexto4.setPosicion(posiciones[3]);
		this.cuadroDeTexto5.setPosicion(posiciones[4]);
	}

	private void setElementosDesde(int i) {
		if (this.cuadroDeTexto1 != null){
			this.removerItem(cuadroDeTexto1);
			this.removerItem(cuadroDeTexto2);
			this.removerItem(cuadroDeTexto3);
			this.removerItem(cuadroDeTexto4);
			this.removerItem(cuadroDeTexto5);	
		}		
		this.cuadroDeTexto1 = textos.get(i);
		this.cuadroDeTexto2 = textos.get(i+1);
		this.cuadroDeTexto3 = textos.get(i+2);
		this.cuadroDeTexto4 = textos.get(i+3);
		this.cuadroDeTexto5 = textos.get(i+4);
		this.agregarItem(cuadroDeTexto1);
		this.agregarItem(cuadroDeTexto2);
		this.agregarItem(cuadroDeTexto3);
		this.agregarItem(cuadroDeTexto4);
		this.agregarItem(cuadroDeTexto5);		
	}

	public void siguienteElemento(){
		if(archivoActual<archivos.size()-1){
			archivoActual++;
			setElementosDesde(archivoActual);		
			actualizarPosiciones();
		};
	}
	
	public void anteriorElemento(){
		if(archivoActual>0){
			archivoActual--;
			setElementosDesde(archivoActual);		
			actualizarPosiciones();
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

	public String getArchivoSeleccionado() {
		String directorio = ManejadorPartidasGuardadas.getPathSaves();
		return directorio+"/"+this.cuadroDeTexto3.getTexto()+".save";
	}
	
	@Override
	public void realizarAlOcultar() {}

	@Override
	public void realizarAlMostrar() {}
}
