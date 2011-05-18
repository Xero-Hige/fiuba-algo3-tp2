package tp2.modelo;

// Esta clase define el comportamiento receptor de una nave en un 
// choque frente a los demás objetos del espacio.
public class ChoqueDeNave extends ChoqueDeObjetoEspacial {
	
	public ChoqueDeNave(Nave unaNave) {
		super(unaNave);
	}
	
	@Override
	// Una nave civil se destruye cuando choca con una nave militar que no es aliada.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {

	}
	
	@Override
	// Una nave civil recibe el daño del proyectil con el que choca salvo que sea aliado.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		
	}
	
}
