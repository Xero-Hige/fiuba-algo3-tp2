package tp2.modelo.excepciones;

public class VueloAsignado extends RuntimeException {

	public VueloAsignado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VueloAsignado(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public VueloAsignado(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public VueloAsignado(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
