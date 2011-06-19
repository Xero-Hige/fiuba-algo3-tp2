package tp2.modelo;

import tp2.auxiliares.ParCadenaPosicion;

public class ParserDeNaves {

	public static Nave fabricarNave(ParCadenaPosicion datoDeLaNave,
			FabricaDeNaves fabrica, Flota flota) {
		NaveEnemiga nave = fabrica.crearExploradorEn(datoDeLaNave.getPosicion());
		flota.agregarNave(nave);
		return nave;
	}

}
