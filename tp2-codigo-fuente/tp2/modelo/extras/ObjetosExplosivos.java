package tp2.modelo.extras;

import java.util.HashSet;
import java.util.Set;

import tp2.modelo.Visible;
import tp2.modelo.especificaciones.ValoresDeNaves;

public class ObjetosExplosivos {
	
	private static Set<String> idsExplosivos;
	
	public static Boolean esExplosivo(Visible objeto){
		if(idsExplosivos == null){
			generarIdsExplosivos();
		}
		return idsExplosivos.contains(objeto.getIdentificacion());
	}
	
	private static void generarIdsExplosivos(){
		idsExplosivos = new HashSet<String>();
		idsExplosivos.add(ValoresDeNaves.algo42Identificacion);
		idsExplosivos.add(ValoresDeNaves.avionCivilIdentificacion);
		idsExplosivos.add(ValoresDeNaves.avionetaIdentificacion);
		idsExplosivos.add(ValoresDeNaves.bombarderoIdentificacion);
		idsExplosivos.add(ValoresDeNaves.cazaIdentificacion);
		idsExplosivos.add(ValoresDeNaves.exploradorIdentificacion);
		idsExplosivos.add(ValoresDeNaves.guiaEnemigoIdentificacion);
		idsExplosivos.add(ValoresDeNaves.helicopteroFederalIdentificacion);
	}

}
