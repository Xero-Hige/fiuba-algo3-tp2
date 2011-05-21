package tp2.modelo;

// Esta clase define el comportamiento receptor de un proyectil en un choque 
// frente a los demás objetos del espacio.
public class ChoqueDeProyectil extends ChoqueDeObjetoEspacial {

	// Inicializa el comportamiento del proyectil recibido.
	public ChoqueDeProyectil(Proyectil unProyectil) {
		super((ObjetoEspacial)unProyectil);
	}
	
	@Override
	// Un proyectil se destruye cuando choca con una nave.
	public void sufrirChoqueDeNave(Nave unaNave) {
		Proyectil objeto = (Proyectil) this.getObjeto();
		if(!objeto.esAliadoDe(unaNave)){
			objeto.destruir();
		}
	}

	@Override
	// Un proyectil se destruye cuando choca con una nave civil.
	public void sufrirChoqueDeNaveCivil(NaveCivil unaNaveCivil) {
		this.sufrirChoqueDeNave((Nave) unaNaveCivil);
	}

	@Override
	// Un proyectil se destruye cuando choca con una nave militar.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		this.sufrirChoqueDeNave((Nave) unaNaveMilitar);
	}
}
