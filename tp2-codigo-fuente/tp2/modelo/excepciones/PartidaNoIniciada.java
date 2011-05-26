package tp2.modelo.excepciones;

public class PartidaNoIniciada extends RuntimeException {

	public PartidaNoIniciada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PartidaNoIniciada(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public PartidaNoIniciada(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public PartidaNoIniciada(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
