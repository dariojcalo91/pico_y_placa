package ec.app.bean;

import java.util.Scanner;

import ec.app.objeto.Horario;
import ec.app.objeto.Placa;
import ec.app.validador.validadorHorario;
import ec.app.validador.validadorPlaca;

public class ingresoDatosPicoPlacaBean {

	// Invocar entidades necesarias
	private Placa placa = new Placa();
	private Horario horario = new Horario();
	private Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner para input
	
	//validadores
	private validadorPlaca validadorPlaca = new validadorPlaca();
	private validadorHorario validadorHorario = new validadorHorario();

	// ingreso de parametros para verificacion de placa en pico y placa
	public Placa ingresoDatosPlaca() {
		System.out.println("Ingreso de datos...");
		System.out.println("Pico y Placa");

		System.out.println("Por favor ingrese la placa: (ej. ABC-9999)");
		placa.setPlaca(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner, para asignar el valor
		if (validadorPlaca.validarPlaca(placa.getPlaca()) != 1) {
			System.out.println("el dato ingresado es incorrecto.");
			System.exit(0);
		}
		System.out.println("La placa ingresada es: \"" + placa.getPlaca() + "\"");
		return placa;
	}
	
	public Horario ingresoDatosHorario() {
		System.out.println("Por favor ingrese la fecha, separada por /: (ej. 25/12/2017)");
		horario.setFecha(entradaEscaner.nextLine());
		if (validadorHorario.validarHorarioFecha(horario.getFecha()) != 1) {
			System.out.println("el dato ingresado es incorrecto.");
			System.exit(0);
		}
		System.out.println("La fecha ingresada es: \"" + horario.getFecha() + "\"");

		System.out.println("Por favor ingrese la hora: (ej: 09:30)");
		System.out.println("Hora:");
		horario.setHora(entradaEscaner.nextLine());
		if(validadorHorario.validarHorarioHora(horario.getHora()) != 1) {
			System.out.println("el dato ingresado es incorrecto.");
			System.exit(0);
		}
		return horario;
	}
}
