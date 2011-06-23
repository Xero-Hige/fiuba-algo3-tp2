package tp2.vista.modelo;

import tp2.modelo.Visible;
import tp2.modelo.especificaciones.*;
import tp2.vista.modelo.extras.*;
import tp2.vista.modelo.objetosVivos.*;
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
		
		if (id.equals(ValoresDeNaves.algo42Identificacion))
			return new VistaAlgo42(proyeccion);
		
		else if (id.equals(ValoresDeNaves.avionetaIdentificacion)) 
			return new VistaAvioneta(proyeccion);
		
		else if (id.equals(ValoresDeNaves.bombarderoIdentificacion)) 
			return new VistaBombardero(proyeccion);
			
		else if (id.equals(ValoresDeNaves.cazaIdentificacion)) 
			return new VistaCaza(proyeccion);
			
		else if (id.equals(ValoresDeNaves.avionCivilIdentificacion)) 
			return new VistaCivil(proyeccion);
				
		else if (id.equals(ValoresDeNaves.exploradorIdentificacion)) 
			return new VistaExplorador(proyeccion);
				
		else if (id.equals(ValoresDeNaves.helicopteroFederalIdentificacion)) 
			return new VistaHelicoptero(proyeccion);
		
		else if (id.equals(ValoresDeNaves.guiaEnemigoIdentificacion)) 
			return new VistaNaveGuia(proyeccion);
		
		
		// Proyectiles
		
		else if (id.equals(ValoresDeArmas.laserIdentificacion)) 
			return new VistaProyectilLaser(proyeccion);
		
		else if (id.equals(ValoresDeArmas.coheteIdentificacion)) 
			return new VistaProyectilCohetes(proyeccion);
		
		else if (id.equals(ValoresDeArmas.torpedoIdentificacion)) 
			return new VistaProyectilTorpedos(proyeccion);
		
		
		// Bonus
		
		else if (id.equals(ValoresDeBonos.bonoDeEnergiaIdentificacion)) 
			return new VistaBonoDeEnergia(proyeccion);
		
		else if (id.equals(ValoresDeBonos.bonoDeArmasIdentificacion)) 
			return new VistaBonoDeArmas(proyeccion);
				
		
		// Extras
		
		else if (id.equals("Explosion")){
			return new VistaExplosion(nuevoObjeto);
		}

		// Si no se reconoce el id se devuelve null.
		return null;
	}
	
}
