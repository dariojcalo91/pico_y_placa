package ec.app.validador;

public class validadorPlaca {

	//variables
	private int control = 1;
	
	//metodos
	public int validarPlaca(String placa) {
		System.out.println("validar placa: "+placa);
		//manejar la estructura de la placa
		if (placa.length() != 8) {
			//la longitud de las placas de ecuador son de 8 digitos entre letras, numeros y el simbolo '-'
			control = -1;
		}
		//verificar si sigue el patron
		if(!patron(placa)) {
			//controlar la estructura ABC-9999
			control = -1;
		}
		System.out.println("retorno");
		return control;
	}
	
	// retorna true si el patron es el correcto
    public boolean patron(String s){
        return s.matches("[a-zA-Z]{3}[-][0-9]{4}");
    }
}
