package tp2.modelo.excepciones;

public class VueloIniciado extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public VueloIniciado() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VueloIniciado(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	public VueloIniciado(String arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	public VueloIniciado(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}
	
}
