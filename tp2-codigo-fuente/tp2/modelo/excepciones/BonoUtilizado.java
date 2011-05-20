package tp2.modelo.excepciones;

public class BonoUtilizado extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public BonoUtilizado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public BonoUtilizado(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public BonoUtilizado(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public BonoUtilizado(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}