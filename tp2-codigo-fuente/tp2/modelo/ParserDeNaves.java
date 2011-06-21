package tp2.modelo;

import java.util.ArrayList;
import java.util.Collection;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;
import tp2.modelo.especificaciones.ValoresDeNaves;

public class ParserDeNaves {

	public static Collection<Nave> fabricarNave(ParCadenaPosicion datoDeLaNave,
		FabricaDeNaves fabrica, Flota flotaMilitar) {
		Collection<Nave> naves = new ArrayList<Nave>();
		Point posicion = datoDeLaNave.getPosicion();
		
		if(datoDeLaNave.getCadena().equals(ValoresDeNaves.avionCivilIdentificacion)){
			NaveCivil nave = fabrica.crearAvionCivilEn(posicion);
			naves.add(nave);
		}
		else if(datoDeLaNave.getCadena().equals(ValoresDeNaves.avionetaIdentificacion)){
			NaveEnemiga nave = fabrica.crearAvionetaEn(posicion);
			flotaMilitar.agregarNave(nave);
			naves.add(nave);
		}
		else if(datoDeLaNave.getCadena().equals(ValoresDeNaves.bombarderoIdentificacion)){
			NaveEnemiga nave = fabrica.crearBombarderoEn(posicion);
			flotaMilitar.agregarNave(nave);
			naves.add(nave);
		}
		else if(datoDeLaNave.getCadena().equals(ValoresDeNaves.exploradorIdentificacion)){
			NaveEnemiga nave = fabrica.crearExploradorEn(posicion);
			flotaMilitar.agregarNave(nave);
			naves.add(nave);
		}
		else if(datoDeLaNave.getCadena().equals(ValoresDeNaves.grupoCazaIdentificacion)){
			for(NaveEnemiga nave: fabrica.crearGrupoCazaEn(posicion)){
				flotaMilitar.agregarNave(nave);
				naves.add(nave);
			}
		}
		else if(datoDeLaNave.getCadena().equals(ValoresDeNaves.helicopteroFederalIdentificacion)){
			NaveCivil nave = fabrica.crearHelicopteroFederalEn(posicion);
			naves.add(nave);
		}
		
		return naves;
	}

}
