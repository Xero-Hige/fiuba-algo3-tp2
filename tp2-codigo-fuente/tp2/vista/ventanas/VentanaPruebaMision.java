package tp2.vista.ventanas;

import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPruebaMision extends Ventana {

	private ControladorJuego controladorJuego;
	private Object controlKeyPressActivo;
	private Object controlMouseClickActivo;

	public VentanaPruebaMision(ControladorJuego unControladorJuego) {
		super(500, 530, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);
		this.controladorJuego = unControladorJuego;
		this.controlKeyPressActivo = null;
		this.controlMouseClickActivo = null;
	}

}
