package tp2.control.menues.menuCargarPartida;

import java.awt.event.KeyEvent;

import org.w3c.dom.Document;

import tp2.modelo.Partida;
import tp2.modelo.menues.menuCargarPartida.MenuCargarPartida;
import tp2.modelo.menues.menuPrincipal.MenuPrincipal;
import tp2.persistencia.ReconstructorDesdeXml;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;

public class ControlKeyPressMenuCargarPartida implements KeyPressedObservador {

	private MenuCargarPartida menuCargarPartida;
	
	public ControlKeyPressMenuCargarPartida(MenuCargarPartida menuCargarPartida) {
		this.menuCargarPartida = menuCargarPartida;
	}

	public void keyPressed(KeyEvent event) {
		
		switch(event.getKeyCode()) {
						
			// Se presiona backspace, por lo que se vuelve al menu padre.	
			case KeyEvent.VK_V:
				this.menuCargarPartida.getMenuPadre().mostrar();
				this.menuCargarPartida.ocultar();				
				break;
				
			case KeyEvent.VK_DOWN:
				this.menuCargarPartida.ocultar();
				this.menuCargarPartida.siguienteElemento();
				this.menuCargarPartida.mostrar();
				break;
				
			// Se presiona flecha hacia arriba.	
			case KeyEvent.VK_UP:
				this.menuCargarPartida.ocultar();
				this.menuCargarPartida.anteriorElemento();
				this.menuCargarPartida.mostrar();
				break;
				
			// Se presiona enter, por lo que se selecciona la opci�n del item actual.	
			case KeyEvent.VK_ENTER:
				String path = this.menuCargarPartida.getArchivoSeleccionado();
				System.out.println(path);
				Document documento = ReconstructorDesdeXml.cargar(path);
				Partida partida = (Partida) ReconstructorDesdeXml.recuperarPersistenciaDe(documento);
				this.menuCargarPartida.getVentanaPrincipal().getControladorJuego().iniciarJuego(partida);
				((MenuPrincipal)(this.menuCargarPartida.getMenuPadre())).getAudio().stop();
				((MenuPrincipal)(this.menuCargarPartida.getMenuPadre())).getAudio().rebobinar();
				break;
		}	
	}

	@Override
	public void keyRelease(KeyEvent arg0) {		
	}

}
