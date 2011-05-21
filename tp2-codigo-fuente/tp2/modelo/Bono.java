package tp2.modelo;

// Clase abstracta. Define cómo debe comportarse un bono, pero esta clase no tiene 
// ningún método concreto (salvo getters y setters). Cada tipo de bono debe heredar 
// de esta clase y definir el comportamiento del bono al usarse.
public abstract class Bono extends ObjetoVolador {

	private Nave naveDuenia;
	
	// Constructor
	// Inicializa el bono con el tamaño recibido.
	public Bono(double tamanio) {
		super(null, tamanio, null, 0);
		
	}
		
	// Hace actuar al objeto volador en el escenario durante el tiempo específicado, 
	// haciendo que el mismo vuele durante ese tiempo. Si no tiene escenario o vuelo,
	// se levanta una excepción.
	public void actuarDurante(double tiempo) {
		
	}

	// En su implementación, el bono receptor debe darle a la nave la bonificación 
	// que tenga y luego autodestruirse (cada bono se usa una sola vez).
	public abstract void entregarBonoA(Nave unaNave);
	
	// Devuelve si el bono ya ha sido usado previamente.
	public boolean fueUsado() {
		return false;
	}
	
	// Hace sufrir al objeto recibido los efectos de chocar un bono, según su 
	//comportamiento.
	public void responderChoqueDe(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	public Nave getNaveDuenia() {
		return null;
	}
	
	// Asigna al bono la nave enemiga que es dueño del mismo.
	public void setNaveDuenia(Nave nuevaNaveDuenia) {
		
	}
	
}
