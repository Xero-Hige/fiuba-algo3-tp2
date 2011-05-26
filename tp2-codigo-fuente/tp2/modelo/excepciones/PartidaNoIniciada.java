package tp2.modelo.excepciones;

public class JuegoNoIniciado extends RuntimeException {

	public JuegoNoIniciado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JuegoNoIniciado(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public JuegoNoIniciado(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public JuegoNoIniciado(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
