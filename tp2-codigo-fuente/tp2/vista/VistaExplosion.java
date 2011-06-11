package tp2.vista;

import ar.uba.fi.algo3.titiritero.Dibujable;
import ar.uba.fi.algo3.titiritero.Posicionable;
import ar.uba.fi.algo3.titiritero.SuperficieDeDibujo;

public class VistaExplosion implements Dibujable {
	
	private Posicionable posicionable;
	private Dibujable dibujo;
	
	public VistaExplosion(Posicionable explosion) {
		this.dibujo = FabricaDeDibujables.nuevoDibujoDeExplosion();
		this.posicionable = explosion;
		this.dibujo.setPosicionable(posicionable);
	}

	@Override
	public void dibujar(SuperficieDeDibujo superficie) {
		this.dibujo.dibujar(superficie);		
	}

	public Posicionable getPosicionable() {
		return posicionable;
	}

	public void setPosicionable(Posicionable posicionable) {
		this.posicionable = posicionable;
		this.dibujo.setPosicionable(posicionable);
	}
	
}
