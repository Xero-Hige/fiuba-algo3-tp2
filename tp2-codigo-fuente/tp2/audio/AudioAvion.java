package tp2.audio;

import ar.uba.fi.algo3.titiritero.audio.Sonido;

public class AudioAvion extends Sonido {
	
	public AudioAvion() {
		
		this.setArchivoDeAudio("sonidos/jet-sound.wav");
		this.reproduccionEnBucle(true);
	}
}
