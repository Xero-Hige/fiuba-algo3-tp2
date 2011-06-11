package tp2.vista.ventanas;

import tp2.modelo.menues.MenuPrincipal;
import tp2.vista.menues.VistaMenuPrincipal;
import ar.uba.fi.algo3.titiritero.ControladorJuego;
import ar.uba.fi.algo3.titiritero.KeyPressedObservador;
import ar.uba.fi.algo3.titiritero.vista.Ventana;


public class VentanaPrincipal extends Ventana {

	private static final long serialVersionUID = 1L;
	private ControladorJuego controladorJuego;
	private KeyPressedObservador controlKeyPressActivo;
		
	public VentanaPrincipal(ControladorJuego unControladorJuego) {
		
		super(500,500, unControladorJuego);
		this.setTitle("Algo42");
		this.setResizable(false);
		this.controladorJuego = unControladorJuego;
		this.controlKeyPressActivo = null;
		this.abrirMenuPrincipal();
	}
		
//		// PRUEBA DE AGREGAR UN OBJETO VIVO AL ESCENARIO
//		
//		Escenario escenario = new Escenario(new Rectangle(500, 500));
//		FabricaDeNaves fabrica = new FabricaDeNaves(escenario, "asdf", null);
//		List<Nave> naves = new ArrayList<Nave>();
//		naves.add(fabrica.crearAvionetaEn(new Point(30, 90)));
//		naves.add(fabrica.crearBombarderoEn(new Point(15, 50)));
//		naves.add(fabrica.crearExploradorEn(new Point(-15, 45)));
//		//naves.add(fabrica.crearAlgo42En(new Point(15, 10)));
//		
//		List<Circulo> vistas = new ArrayList<Circulo>();
//		for(Nave nave: naves){
//			Circulo circulo = new Circulo((int) (nave.getTamanio() * 5));
//			circulo.setPosicionable(nave);
//			vistas.add(circulo);
//			unControladorJuego.agregarDibujable(circulo);
//			unControladorJuego.agregarObjetoVivo(nave);
//		}
	
	/** Abre el menú principal del juego. */
	public void abrirMenuPrincipal() {
		
		MenuPrincipal menuPrincipal = new MenuPrincipal();
		VistaMenuPrincipal vistaMenuPrincipal = new VistaMenuPrincipal(this);
		vistaMenuPrincipal.setPosicionable(menuPrincipal);
		this.controladorJuego.agregarDibujable(vistaMenuPrincipal);	
		this.controladorJuego.agregarKeyPressObservador(this.controlKeyPressActivo);
	}
	
	/** Cierra el menú principal y abre el menú para una nueva partida. */
	public void abrirMenuNuevaPartida() {
		
	}
	
	/** Cierra el menú principal y abre el menú para cargar una partida salvada. */
	public void abrirMenuCargarPartida() {
		
	}
	
	/** Muestra los créditos del juego. */
	public void abrirMenuCreditos() {
		
	}
	
	/** Cierra el juego. */
	public void salirDelJuego() {
	
	}
	
	public ControladorJuego getControladorJuego() {
		return this.controladorJuego;
	}
	
	public void setControlKeyPressActivo(KeyPressedObservador controlKeyPressActivo) {
		this.controlKeyPressActivo = controlKeyPressActivo;
	}
}