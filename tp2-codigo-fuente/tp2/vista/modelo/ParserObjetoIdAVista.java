package tp2.vista.modelo;

import tp2.modelo.Visible;
import tp2.vista.modelo.extras.VistaAgua;
import tp2.vista.modelo.extras.VistaExplosion;
import tp2.vista.modelo.objetosVivos.VistaAlgo42;
import tp2.vista.modelo.objetosVivos.VistaAvioneta;
import tp2.vista.modelo.objetosVivos.VistaBombardero;
import tp2.vista.modelo.objetosVivos.VistaBonoDeEnergia;
import tp2.vista.modelo.objetosVivos.VistaCaza;
import tp2.vista.modelo.objetosVivos.VistaCivil;
import tp2.vista.modelo.objetosVivos.VistaExplorador;
import tp2.vista.modelo.objetosVivos.VistaHelicoptero;
import tp2.vista.modelo.objetosVivos.VistaNaveGuia;
import tp2.vista.ventanas.ProyeccionSobreSuperficieDeDibujo;
import ar.uba.fi.algo3.titiritero.Dibujable;

/**
 * Clase que traduce un id a una vista, devolviendo dependiendo del
 * id, una vista que la represente.
 *
 */
public class ParserObjetoIdAVista {

	
	public static Dibujable getVista(Visible nuevoObjeto, ProyeccionSobreSuperficieDeDibujo proyeccion) {
		
		String id = nuevoObjeto.getIdentificacion();
		
		// Aeronaves
		
		if (id == "Algo42")
			return new VistaAlgo42(proyeccion);
		
		else if (id == "Avioneta") 
			return new VistaAvioneta(proyeccion);
		
		else if (id == "Bombardero") 
			return new VistaBombardero(proyeccion);
			
		else if (id == "Caza") 
			return new VistaCaza(proyeccion);
			
		else if (id == "AvionCivil") 
			return new VistaCivil(proyeccion);
				
		else if (id == "Explorador") 
			return new VistaExplorador(proyeccion);
				
		else if (id == "HelicopteroFederal") 
			return new VistaHelicoptero(proyeccion);
		
		else if (id == "GuiaEnemigo") 
			return new VistaNaveGuia(proyeccion);
		
		
		// Bonus
		
		else if (id == "BonusEnergia") 
			return new VistaBonoDeEnergia(proyeccion);
		
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
		
		
		// Extras
		
		else if (id == "Explosion"){
			return new VistaExplosion(nuevoObjeto);
		}
		else if (id == "Agua"){
			return new VistaAgua(nuevoObjeto);
		}
		
		// Si no se reconoce el id se devuelve null.
		return null;
	}
	
}
