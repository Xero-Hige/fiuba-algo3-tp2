package tp2.modelo;

import java.util.ArrayList;
import java.util.Collection;

import tp2.auxiliares.ParCadenaPosicion;

public class ParserDeNaves {

	public static Collection<Nave> fabricarNave(ParCadenaPosicion datoDeLaNave,
		FabricaDeNaves fabrica, Flota flotaMilitar) {
		Collection<Nave> naves = new ArrayList<Nave>();
		
		NaveEnemiga nave = fabrica.crearExploradorEn(datoDeLaNave.getPosicion());
		flotaMilitar.agregarNave(nave);
		naves.add(nave);
		
		return naves;
	}

}
