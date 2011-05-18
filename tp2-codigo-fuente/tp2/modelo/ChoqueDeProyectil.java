package tp2.modelo;

// Esta clase define el comportamiento receptor de un proyectil en un choque 
// frente a los demás objetos del espacio.
public class ChoqueDeProyectil extends ChoqueDeObjetoEspacial {

	// Constructor
	public ChoqueDeProyectil(Proyectil unProyectil) {
		super(unProyectil);
	}
	
	@Override
	// Un proyectil se destruye cuando choca con una nave.
	public void sufrirChoqueDeNave(Nave unaNave) {
		
	}
}
