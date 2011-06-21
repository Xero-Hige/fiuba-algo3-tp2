package tp2.vista.modelo;

import tp2.modelo.Visible;
import tp2.modelo.especificaciones.ValoresDeBonos;
import tp2.modelo.especificaciones.ValoresDeNaves;
import tp2.vista.modelo.extras.VistaAgua;
import tp2.vista.modelo.extras.VistaExplosion;
import tp2.vista.modelo.objetosVivos.VistaAlgo42;
import tp2.vista.modelo.objetosVivos.VistaAvioneta;
import tp2.vista.modelo.objetosVivos.VistaBombardero;
import tp2.vista.modelo.objetosVivos.VistaBonoDeArmas;
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
		
		if (id == ValoresDeNaves.algo42Identificacion)
			return new VistaAlgo42(proyeccion);
		
		else if (id == ValoresDeNaves.avionetaIdentificacion) 
			return new VistaAvioneta(proyeccion);
		
		else if (id == ValoresDeNaves.bombarderoIdentificacion) 
			return new VistaBombardero(proyeccion);
			
		else if (id == ValoresDeNaves.cazaIdentificacion) 
			return new VistaCaza(proyeccion);
			
		else if (id == ValoresDeNaves.avionCivilIdentificacion) 
			return new VistaCivil(proyeccion);
				
		else if (id == ValoresDeNaves.exploradorIdentificacion) 
			return new VistaExplorador(proyeccion);
				
		else if (id == ValoresDeNaves.helicopteroFederalIdentificacion) 
			return new VistaHelicoptero(proyeccion);
		
		else if (id == ValoresDeNaves.guiaEnemigoIdentificacion) 
			return new VistaNaveGuia(proyeccion);
		
		
		// Bonus
		
		else if (id == ValoresDeBonos.bonoDeEnergiaIdentificacion) 
			return new VistaBonoDeEnergia(proyeccion);
		
		else if (id == ValoresDeBonos.bonoDeArmasIdentificacion) 
			return new VistaBonoDeArmas(proyeccion);
				
		
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
