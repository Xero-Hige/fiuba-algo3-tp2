package tp2.vista.modelo.objetosVivos;

import ar.uba.fi.algo3.titiritero.Dibujable;

/**
 * Clase que traduce un id a una vista, devolviendo dependiendo del
 * id, una vista que la represente.
 *
 */
public class ParserObjetoIdAVista {

	
	public static Dibujable getVista(String id) {
		
		// Aeronaves
		
		if (id == "algo42")
			return new VistaAlgo42();
		
		else if (id == "avioneta") 
			return new VistaAvioneta();
		
		else if (id == "bombardero") 
			return new VistaBombardero();
			
		else if (id == "caza") 
			return new VistaCaza();
			
		else if (id == "civil") 
			return new VistaCivil();
				
		else if (id == "explorador") 
			return new VistaExplorador();
				
		else if (id == "helicoptero") 
			return new VistaHelicoptero();
		
		
		// Bonus extras
		
		else if (id == "bonusEnergia") 
			return null;
		
		else if (id == "bonusArmaLaser") 
			return null;
		
		else if (id == "bonusArmaCohete") 
			return null;
		
		else if (id == "bonusArmaTorpedoSimple") 
			return null;
		
		else if (id == "bonusArmaTorpedoRastreador") 
			return null;
		
		else if (id == "bonusArmaTorpedoAdaptable") 
			return null;
		
		// Si no se reconoce el id se devuelve por defecto la vista
		// de una avioneta.
		return new VistaAvioneta();
	}
	
}
