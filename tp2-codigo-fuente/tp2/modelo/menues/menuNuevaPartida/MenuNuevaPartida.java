package tp2.modelo.menues.menuNuevaPartida;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ar.uba.fi.algo3.titiritero.Dibujable;
import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.control.menues.menuNuevaPartida.ControlKeyPressMenuNuevaPartida;
import tp2.modelo.Escenario;
import tp2.modelo.Mision;
import tp2.modelo.menues.Menu;
import tp2.modelo.menues.MenuI;
import tp2.vista.menues.menuNuevaPartida.VistaMenuNuevaPartida;
import tp2.vista.modelo.mision.VistaBarraDeEstado;
import tp2.vista.ventanas.VentanaPrincipal;


public class MenuNuevaPartida extends Menu {

	public MenuNuevaPartida(VentanaPrincipal ventanaPrincipal, MenuI menuPadre) {
		super(ventanaPrincipal, menuPadre);
		
		// Creamos y mostramos la vista de creación de partida en proceso.
		VistaMenuNuevaPartida vistaIniciandoPartida = new VistaMenuNuevaPartida();
		
		this.setVistaMenu(vistaIniciandoPartida);
		this.getVistaMenu().setPosicionable(this);
	}
	
	@Override
	public void resetear() {
		// TODO Auto-generated method stub
	}

	@Override
	public void activarControl() {
		// Activamos al observador del teclado y lo seteamos para que use el controlador
		// del menú creditos.
		this.setControlKeyPress(new ControlKeyPressMenuNuevaPartida());
		this.getVentanaPrincipal().setControlKeyPressActivo(this.getControlKeyPress());
	}
	
	@Override
	public void mostrar() {
		
		// Mostramos pantalla de cargando nueva partida
		this.getVentanaPrincipal().agregarObjetoDibujable((Dibujable) this.getVistaMenu());
		this.getVentanaPrincipal().agregarObjetosDibujables(this.getVistaMenu().getObjetosDibujables());

		// Cargamos la nueva partida
		this.iniciarNuevaPartida();
		
		// Removemos la pantalla de cargando nueva partida
		this.getVentanaPrincipal().removerObjetoDibujable((Dibujable) this.getVistaMenu());
		this.getVentanaPrincipal().removerObjetosDibujables(this.getVistaMenu().getObjetosDibujables());
	}
	
	public void iniciarNuevaPartida() {
		
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
		
		
		VistaBarraDeEstado vistaBarraDeEstado = new VistaBarraDeEstado();
		this.getVentanaPrincipal().agregarObjetoDibujable(vistaBarraDeEstado);
		
		for(Dibujable objetoDibujable: vistaBarraDeEstado.getObjetosDibujablesDeLaVista()){
			this.getVentanaPrincipal().agregarObjetoDibujable(objetoDibujable);
		}
		
		vistaBarraDeEstado.setPuntaje(100);
	}
}
