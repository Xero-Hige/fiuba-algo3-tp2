package tp2.modelo.test;

import static org.junit.Assert.*;

import java.awt.Rectangle;

import org.junit.Before;
import org.junit.Test;

import tp2.auxiliares.Point;
import tp2.modelo.Escenario;
import tp2.modelo.Nave;
import tp2.modelo.VueloEnLineaRecta;

public class VueloEnLineaRectaTest {

	private Escenario escenario;
	private Point direccion;
	private int velocidad;
	private Nave objetoVolador;
	private VueloEnLineaRecta vuelo;

	@Before
	public void setUp() throws Exception {
		escenario = new Escenario(new Rectangle());
		// Inicializamos los valores
		direccion = new Point(5.5, 8);
		velocidad = 15;
		objetoVolador = new Nave(new Point(10, 3), 1, escenario, velocidad, 1);
		vuelo = new VueloEnLineaRecta(objetoVolador, direccion);
	}

	@Test
	public void testAvanzarDurante() {
		vuelo.iniciar();
		// Probamos que el vuelo siga la dirección especificada, y que la
		// longitud del desplazamiento sea correcta
		boolean falloDireccion = false;
		boolean falloLongitud = false;
		for(double tiempo = 0; tiempo <= 2; tiempo += 0.01){
			Point desplazamiento = vuelo.avanzarDurante(tiempo);
			if(Math.abs(desplazamiento.distance(0, 0) - (velocidad * tiempo)) > 1e-10){
				falloLongitud = true;
			}
			if(Math.abs(desplazamiento.getX() * direccion.getY() - direccion.getX() * desplazamiento.getY()) > 1e-10){
				falloDireccion = true;
			}
		}
		// Capturamos los fallos
		assertFalse(falloLongitud);
		assertFalse(falloDireccion);
	}

}
