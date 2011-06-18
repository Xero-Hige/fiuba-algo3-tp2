package tp2.vista.modelo;

import tp2.modelo.Visible;
import tp2.vista.modelo.extras.VistaExplosion;
import tp2.vista.modelo.objetosVivos.VistaAlgo42;
import tp2.vista.modelo.objetosVivos.VistaAvioneta;
import tp2.vista.modelo.objetosVivos.VistaBombardero;
import tp2.vista.modelo.objetosVivos.VistaCaza;
import tp2.vista.modelo.objetosVivos.VistaCivil;
import tp2.vista.modelo.objetosVivos.VistaExplorador;
import tp2.vista.modelo.objetosVivos.VistaHelicoptero;
import ar.uba.fi.algo3.titiritero.Dibujable;

/**
 * Clase que traduce un id a una vista, devolviendo dependiendo del
 * id, una vista que la represente.
 *
 */
public class ParserObjetoIdAVista {

	
	public static Dibujable getVista(Visible nuevoObjeto) {
		
		String id = nuevoObjeto.getIdentificacion();
		
		// Aeronaves
		
		if (id == "Algo42")
			return new VistaAlgo42();
		
		else if (id == "Avioneta") 
			return new VistaAvioneta();
		
		else if (id == "Bombardero") 
			return new VistaBombardero();
			
		else if (id == "Caza") 
			return new VistaCaza();
			
		else if (id == "AvionCivil") 
			return new VistaCivil();
				
		else if (id == "Explorador") 
			return new VistaExplorador();
				
		else if (id == "HelicopteroFederal") 
			return new VistaHelicoptero();
		
		
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
		
		else if (id == "Explosion"){
			return new VistaExplosion(nuevoObjeto);
		}
		
		// Si no se reconoce el id se devuelve null.
		return null;
	}
	
}
