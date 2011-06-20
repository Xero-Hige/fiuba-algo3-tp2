package tp2.vista.modelo.mision;

import ar.uba.fi.algo3.titiritero.vista.ObjetoDeTexto;

public class TextoInicioMision implements ObjetoDeTexto {

	private String txtMision = "Mision";
	private int numeroMision = 0;
	
	public void setNumeroMision(int numero) {
		numeroMision = numero;
	}
	
	@Override
	public String getTexto() {
		return txtMision + " " + numeroMision;
	}

}
