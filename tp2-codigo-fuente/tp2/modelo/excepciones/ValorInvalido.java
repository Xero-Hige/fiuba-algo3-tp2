package tp2.modelo.excepciones;

public class ValorInvalido extends RuntimeException {

	public ValorInvalido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ValorInvalido(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ValorInvalido(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ValorInvalido(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;
}
