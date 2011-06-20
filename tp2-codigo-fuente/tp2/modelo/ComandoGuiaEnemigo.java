package tp2.modelo;

import tp2.auxiliares.Point;

public class ComandoGuiaEnemigo implements ComandoDeNaves {

	private NaveGuia guiaEnemigo;
	private boolean navesDisparando;
	
	public ComandoGuiaEnemigo(NaveGuia guiaEnemigo) {
		this.guiaEnemigo = guiaEnemigo;
		this.navesDisparando = false;
	}
	
	@Override
	public void comandarNaves() {
		if(this.guiaEnemigo.estaDestruido()){
			this.guiaEnemigo.getFlota().iniciarRetiradaEnDireccion(new Point(0, 1));
		}
		int tiempoEscenario = (int) this.guiaEnemigo.getEscenario().getTiempo();
		if((tiempoEscenario / 2) % 2 != 0){
			if(!this.navesDisparando){
				this.navesDisparando = true;
				this.guiaEnemigo.getFlota().iniciarFuego();	
			}
		} else {
			if(this.navesDisparando){
				this.navesDisparando = false;
				this.guiaEnemigo.getFlota().detenerFuego();	
			}
		}
	}

}
