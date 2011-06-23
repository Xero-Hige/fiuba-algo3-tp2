package tp2.control;

import java.awt.event.KeyEvent;

import tp2.auxiliares.Point;
import tp2.modelo.NaveMilitarControlada;

public class ControladorDelJugador {
	
	private static final int ACTIVADA = 1;
	private static final int DESACTIVADA = 0;

	private NaveMilitarControlada naveDelJugador;
	private int tecla_arriba;
	private int tecla_abajo;
	private int tecla_derecha;
	private int tecla_izquierda;
	private int direccion_horizontal;
	private int direccion_vertical;
	private Point direccionActual;

	public ControladorDelJugador(NaveMilitarControlada naveDelJugador) {
		this.naveDelJugador = naveDelJugador;
		this.direccion_horizontal = 0;
		this.direccion_vertical = 0;
		this.tecla_abajo = DESACTIVADA;
		this.tecla_arriba = DESACTIVADA;
		this.tecla_derecha = DESACTIVADA;
		this.tecla_izquierda = DESACTIVADA;
	}

	public void setNaveDelJugador(NaveMilitarControlada naveDelJugador) {
		this.naveDelJugador = naveDelJugador;
	}

	public void recibirTeclaPresionada(KeyEvent event) {
		switch (event.getKeyCode()) {
		case KeyEvent.VK_A:
			this.naveDelJugador.iniciarFuego();
			break;
		case KeyEvent.VK_UP:
			this.tecla_arriba = ACTIVADA;
			this.direccion_vertical = 1;
			break;
		case KeyEvent.VK_DOWN:
			this.tecla_abajo = ACTIVADA;
			this.direccion_vertical = -1;
			break;
		case KeyEvent.VK_RIGHT:
			this.tecla_derecha = ACTIVADA;
			this.direccion_horizontal = 1;
			break;
		case KeyEvent.VK_LEFT:
			this.tecla_izquierda = ACTIVADA;
			this.direccion_horizontal = -1;
			break;
		}
		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_LEFT:
			this.direccionActual = new Point(this.direccion_horizontal, this.direccion_vertical);
			this.naveDelJugador.setDireccionDeVuelo(this.direccionActual);
		}
	}
	
	public void recibirTeclaSoltada(KeyEvent event){
		switch (event.getKeyCode()) {
		case KeyEvent.VK_A:
			this.naveDelJugador.detenerFuego();
		case KeyEvent.VK_UP:
			this.tecla_arriba = DESACTIVADA;
			this.recalcularDireccionVertical();
			break;
		case KeyEvent.VK_DOWN:
			this.tecla_abajo = DESACTIVADA;
			this.recalcularDireccionVertical();
			break;
		case KeyEvent.VK_RIGHT:
			this.tecla_derecha = DESACTIVADA;
			this.recalcularDireccionHorizontal();
			break;
		case KeyEvent.VK_LEFT:
			this.tecla_izquierda = DESACTIVADA;
			this.recalcularDireccionHorizontal();
			break;
		}
		switch (event.getKeyCode()) {
		case KeyEvent.VK_UP:
		case KeyEvent.VK_DOWN:
		case KeyEvent.VK_RIGHT:
		case KeyEvent.VK_LEFT:
			this.direccionActual = new Point(this.direccion_horizontal, this.direccion_vertical);
			this.naveDelJugador.setDireccionDeVuelo(this.direccionActual);
		}
	}

	private void recalcularDireccionVertical() {
		if(this.tecla_arriba == ACTIVADA){
			this.direccion_vertical = 1;
		}
		else if(this.tecla_abajo == ACTIVADA){
			this.direccion_vertical = -1;
		}
		else {
			this.direccion_vertical = 0;
		}
	}
	
	private void recalcularDireccionHorizontal() {
		if(this.tecla_derecha == ACTIVADA){
			this.direccion_horizontal = 1;
		}
		else if(this.tecla_izquierda == ACTIVADA){
			this.direccion_horizontal = -1;
		}
		else {
			this.direccion_horizontal = 0;
		}
	}

}
