package tp2.vista.menues.menuCargarPartida;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

import tp2.persistencia.BuscadorDeArchivos;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Imagen;


public class FabricaDeDibujablesDelMenuCargarPartida {
	
	private static boolean imagenesCargadas = false;
	
	private static void cargarImagenes() {
		ImagenFondoCargarPartida.nuevaImagen();
		imagenesCargadas = true;
	}
	
	public static void comprobarCargaDeImagenes() {
		
		if(!imagenesCargadas){
			cargarImagenes();
		}
	}
	
	public static Dibujable nuevaImagenFondoCargarPartida() {
		comprobarCargaDeImagenes();
		return ImagenFondoCargarPartida.nuevaImagen();
	}

	public static Imagen nuevaImagenDesde(String texto) {
		Imagen i = new Imagen();
		
		String directorioActual = BuscadorDeArchivos.getPathDirectoriActual();
		
		Image imagen = null;
		try {
			imagen = ImageIO.read(new FileInputStream(directorioActual+"/src/tp2/vista/imagenes/extras/eleccion.png"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		Graphics graficos = imagen.getGraphics();
		graficos.drawImage(imagen, 0, 0, null);
		graficos.setFont(new Font("Arial", Font.BOLD, 13));
		graficos.drawString(texto, 3, 22);
		graficos.dispose();

        i.setImagen(imagen);
		return i;
	}
}