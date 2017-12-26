package ec.app.interfaz;

public interface validar {
	
	static final String PATRON_PLACA = "[a-zA-Z]{3}[-][0-9]{4}";
	static final String PATRON_FECHA = "[0-9]{2}[/][0-9]{2}[/][0-9]{4}";
	static final String PATRON_HORA = "[0-9]{2}[:][0-9]{2}";

	boolean  validarEstructura(String var, String patron);
}
