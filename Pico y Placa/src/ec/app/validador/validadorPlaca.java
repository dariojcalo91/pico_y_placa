package ec.app.validador;

import ec.app.interfaz.validar;

public class validadorPlaca implements validar	 {

	//variables
	private boolean control = true;
	
	//metodos
	public boolean validarPlaca(String placa) {
		System.out.println("validar placa: "+placa);
		//manejar la estructura de la placa
		if (placa.length() != 8) {
			//la longitud de las placas de ecuador son de 8 digitos entre letras, numeros y el simbolo '-'
			control = false;
		}
		//verificar si sigue el patron
		if(!validarEstructura(placa, validar.PATRON_PLACA)) {
			//controlar la estructura ABC-9999
			control = false;
		}
		System.out.println("retorno");
		return control;
	}
	
	// retorna true si el patron es el correcto
    public boolean validarEstructura(String s, String patron) {
    	return s.matches(patron);
    }
}
