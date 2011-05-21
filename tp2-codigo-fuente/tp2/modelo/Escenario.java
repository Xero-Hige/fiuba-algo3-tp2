package tp2.modelo;

import java.awt.Rectangle;
import java.util.*;

// El escenario es el lugar en donde viven todos los objetos espaciales que 
// pueden actuar e interactuar entre sí. Un objeto de esta clase puede simular 
// la vida de dichos objetos a lo largo del tiempo, y ellos a la vez pueden 
// comunicarse con él.
public class Escenario {

	// Es el área rectangular asignada de combate.
	private Rectangle areaDeCombate;
	// los objetos tienen un id para interactuar entre sí en un único sentido 
	// (y que no existan colisiones dobles).
	private int proximoId;
	// Es un diccionario, que tiene como clave a los objetos y como valor el id 
	// del mismo.
	private Map<ObjetoEspacial,String> objetos;
	// La puntuación lograda en dicho escenario.
	private int puntuacion;
	

	// Constructor
	// Crea un nuevo escenario cuya área de combate está definida por el
	// rectángulo recibido. 
	public Escenario(Rectangle areaDeCombate) {
		
	}
	
	// Agrega un objeto al escenario, el cual ya tiene asignado dicho escenario.
	// El mismo debe estar preparado para actuar cuando sea necesario, de lo 
	// contrario se corre el riesgo de que se levante una excepción en el 
	// futuro. Si el objeto no tiene asignado este escenario, entonces se 
	// levanta una excepción. Si el objeto ya estaba agregado al escenario, no 
	// pasa nada.
	public void agregarObjeto(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Borra definitivamente al objeto del escenario. Si el objeto no tiene 
	// asignado este escenario, entonces se levanta una excepción. 
	public void borrarObjeto(ObjetoEspacial unObjetoEspacial) {
		
	}
	
	// Devuelve si el objeto recibido se encuentra en el escenario.
	public boolean contieneObjeto(ObjetoEspacial unObjetoEspacial) {
		return false;
	}
	
	// Devuelve si el objeto se encuentra dentro del área de combate.
	public boolean tieneEnCombateA(ObjetoEspacial unObjetoEspacial) {
		return false;
	}
	
	// Hace que avance el tiempo, y le ordena a todos los objetos 
	// pertenecientes al escenarios que actúen durante dicho tiempo. En el caso 
	// que algún objeto no tenga pueda actuar y tire una excepción, se levantará
	// la misma.
	public void avanzarTiempoEn(double unTiempo) {
		
	}
	
	// Agrega o quita (si la diferencia es negativa) la cantidad de puntos 
	// recibida a la puntuación actual del escenario. La puntuación se mantiene 
	// mínimamente en cero.
	public void modificarPuntuacionEn(int unaDiferencia) {
		
	}
	
	// Cambia el área de combate al rectángulo recibido.
	public void setAreaDeCombate(Rectangle nuevaArea) {
		
	}
	
	// Devuelve un diccionario, que tiene como clave a los objetos y como valor  
	// el id del mismo.
	public Map<ObjetoEspacial,String> getObjetos() {
		return null;
	}
	
	// Recibe la referencia a un objeto del escenario. Devuelve una colección 
	// de aquellos otros objetos que están colisionando con el mismo y que 
	// fueron agregados al escenario después de este (es decir, detecta 
	// colisiones en un solo sentido).
	public List<ObjetoEspacial> getObjetosEnColisionCon(ObjetoEspacial unObjetoEspacial) {
		return null;
	}
	
	public int getPuntuacion() {
		return 0;
	}
	
}
