package tp2.modelo;

import tp2.modelo.excepciones.ComposicionIncompleta;


// Esta clase define el comportamiento receptor de un objeto espacial frente a los 
// demás. Cada método indica cómo se ve afectado el objeto espacial al chocar con
// un tipo particular de objeto.
// Considerando al objeto espacial como el objeto desde el cual todos heredan, 
// los demás comportamientos deberían heredar de éste, entendiendo las siguiente 
// reglas al definir comportamiento:
//	- Una nueva clase de comportamiento indica que el tipo de objeto se ve afectado 
//    de forma diferente a los demás.
//	- Un nuevo método indica que cierto tipo de objeto afecta de diferente manera 
//    a ciertos tipos de objetos.
public class ChoqueDeObjetoEspacial {

	private ObjetoEspacial objeto;
	
	// Inicializa el comportamiento del objeto recibido.
	public ChoqueDeObjetoEspacial(ObjetoEspacial unObjetoEspacial) {
		if(unObjetoEspacial == null){
			throw new ComposicionIncompleta("El comportamiento de choque no fue inicializado correctamente.");
		}
		this.objeto = unObjetoEspacial;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con un bono.
	public void sufrirChoqueDeBono(Bono unBono) {
		return;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con una nave.
	public void sufrirChoqueDeNave(Nave unaNave) {
		return;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con una nave civil.
	public void sufrirChoqueDeNaveCivil(NaveCivil unaNaveCivil)	{
		return;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con una nave militar.
	public void sufrirChoqueDeNaveMilitar(NaveMilitar unaNaveMilitar) {
		return;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con otro objeto espacial.
	public void sufrirChoqueDeObjetoEspacial(ObjetoEspacial unObjetoEspacial) {
		return;
	}
	
	// Por defecto, a un objeto espacial no le pasa nada cuando choca con un proyectil.
	public void sufrirChoqueDeProyectil(Proyectil unProyectil) {
		return;
	}

	protected ObjetoEspacial getObjeto() {
		return objeto;
	}
	
}
