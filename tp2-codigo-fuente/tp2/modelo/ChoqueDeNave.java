package tp2.modelo;

// Esta clase define el comportamiento receptor de una nave en un 
// choque frente a los demás objetos del espacio.
public class ChoqueDeNave extends ChoqueDeObjetoEspacial {
	
	// Inicializa el comportamiento de la nave recibida.
	public ChoqueDeNave(Nave unaNave) {
		super((ObjetoEspacial) unaNave);
	}
	
	public ChoqueDeNave() {}
	
	@Override
	// Una nave se destruye cuando choca con una nave militar que no es aliada.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		Nave nave = (Nave) this.getObjeto();
		if(!nave.esAliadoDe(unaNaveMilitar)){
			nave.destruir();
		}
	}
	
	@Override
	// Una nave recibe el daño del proyectil con el que choca salvo que sea aliado.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		Nave nave = (Nave) this.getObjeto();
		if(!nave.esAliadoDe(unProyectil)){
			nave.recibirDanio(unProyectil.getDanio());
		}
	}
	
}
