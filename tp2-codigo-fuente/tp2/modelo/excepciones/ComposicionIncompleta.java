package tp2.modelo.excepciones;

public class ComposicionIncompleta extends RuntimeException {
	
	public ComposicionIncompleta() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ComposicionIncompleta(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ComposicionIncompleta(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ComposicionIncompleta(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
