package tp2.vista.ventanas;

import tp2.modelo.especificaciones.DimensionesDeVentana;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.vista.Ventana;

public class VentanaPruebaMision extends Ventana {

	private static final long serialVersionUID = -3826936990709548683L;
	private ControladorJuego controladorJuego;
	private Object controlKeyPressActivo;
	private Object controlMouseClickActivo;
	
	private static int anchoVentana = DimensionesDeVentana.ancho;
	private static int altoVentana = DimensionesDeVentana.alto;

	public VentanaPruebaMision(ControladorJuego unControladorJuego) {
		super(anchoVentana, altoVentana + DimensionesDeVentana.altoBarraDeVentana, unControladorJuego);
		ProyeccionSobreSuperficieDeDibujoStatic.setSuperficieDeDibujo(anchoVentana, altoVentana);
		this.setTitle("Algo42");
		this.setResizable(false);
		this.controladorJuego = unControladorJuego;
		this.controlKeyPressActivo = null;
		this.controlMouseClickActivo = null;
	}

}
