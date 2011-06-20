package tp2.modelo;

import java.util.ArrayList;
import java.util.Collection;

import tp2.auxiliares.ParCadenaPosicion;
import tp2.auxiliares.Point;

public class ParserDeNaves {

	public static Collection<Nave> fabricarNave(ParCadenaPosicion datoDeLaNave,
		FabricaDeNaves fabrica, Flota flotaMilitar) {
		Collection<Nave> naves = new ArrayList<Nave>();
		Point posicion = datoDeLaNave.getPosicion();
		
		if(datoDeLaNave.getCadena().equals("Avioneta")){
			NaveEnemiga nave = fabrica.crearAvionetaEn(posicion);
			flotaMilitar.agregarNave(nave);
			naves.add(nave);
		}
		if(datoDeLaNave.getCadena().equals("Explorador")){
			NaveEnemiga nave = fabrica.crearExploradorEn(posicion);
			flotaMilitar.agregarNave(nave);
			naves.add(nave);
		}
		else if(datoDeLaNave.getCadena().equals("Cazas")){
			for(NaveEnemiga nave: fabrica.crearGrupoCazaEn(posicion)){
				flotaMilitar.agregarNave(nave);
				naves.add(nave);
			}
		}
		
		return naves;
	}

}
