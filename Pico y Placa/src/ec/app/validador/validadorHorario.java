package ec.app.validador;

import ec.app.interfaz.validar;

public class validadorHorario implements validar {

	//variables
		private int control = 1;
		
		//metodos
		public int validarHorarioFecha(String fecha) {
			System.out.println("validar fecha: "+fecha);
			//manejar la estructura de la fecha
			if (fecha.length() != 10) {
				//la longitud de la fecha de aceurdo al patron son de 10 digitos entre  numeros y el simbolo '/'
				control = -1;
			}
			//verificar si sigue el patron
			if(!validarEstructura(fecha, validar.PATRON_FECHA)) {
				//controlar la estructura dd/MM/YYYY
				control = -1;
			}
			System.out.println("retorno");
			return control;
		}
		
		public int validarHorarioHora(String hora) {
			System.out.println("validar fecha: "+hora);
			//manejar la estructura de la fecha
			if (hora.length() != 5) {
				//la longitud de la fecha de aceurdo al patron son de 10 digitos entre  numeros y el simbolo '/'
				control = -1;
			}
			//verificar si sigue el patron
			if(!validarEstructura(hora, validar.PATRON_HORA)) {
				//controlar la estructura dd/MM/YYYY
				control = -1;
			}
			System.out.println("retorno");
			return control;
		}

	    // retorna true si el patron es el correcto
	    public boolean validarEstructura(String s, String patron){
	        return s.matches(patron);
	    }    
}
