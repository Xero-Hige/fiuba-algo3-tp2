package tp2.vista.modelo.objetosVivos;

import tp2.modelo.ObjetoEspacial;
import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.vista.Circulo;

/**
 * Clase que traduce un id a una vista, devolviendo dependiendo del
 * id, una vista que la represente.
 *
 */
public class ParserObjetoIdAVista {

	
	public static Dibujable getVista(ObjetoEspacial objeto) {
		
		String id = objeto.getIdentificacion();
		
		// Aeronaves
		
//		if (id == "Algo42")
//			return new VistaAlgo42();
//		
//		else if (id == "Avioneta") 
//			return new VistaAvioneta();
//		
//		else if (id == "Bombardero") 
//			return new VistaBombardero();
//			
//		else if (id == "Caza") 
//			return new VistaCaza();
//			
//		else if (id == "AvionCivil") 
//			return new VistaCivil();
//				
//		else if (id == "Explorador") 
//			return new VistaExplorador();
//				
//		else if (id == "HelicopteroFederal") 
//			return new VistaHelicoptero();
		
		
		// Bonus extras
		
//		else if (id == "BonusEnergia") 
//			return null;
//		
//		else if (id == "BonusArmaLaser") 
//			return null;
//		
//		else if (id == "BonusArmaCohete") 
//			return null;
//		
//		else if (id == "BonusArmaTorpedoSimple") 
//			return null;
//		
//		else if (id == "BonusArmaTorpedoRastreador") 
//			return null;
//		
//		else if (id == "BonusArmaTorpedoAdaptable") 
//			return null;
		
		// Si no se reconoce el id se devuelve por defecto un Circulo de tamaño
		// adecuado.
		return new Circulo((int)(objeto.getTamanio() * 2 * 10));
	}
	
}
