package tp2.modelo.excepciones;

public class ObjetoDesconocido extends RuntimeException {

	public ObjetoDesconocido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObjetoDesconocido(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjetoDesconocido(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ObjetoDesconocido(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
