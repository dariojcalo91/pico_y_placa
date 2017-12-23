package ec.app.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

import ec.app.objeto.Horario;
import ec.app.objeto.Placa;
import ec.app.objeto.ext.ObjetoTemp;
import ec.app.validador.validadorHorario;
import ec.app.validador.validadorPlaca;

public class ingresoDatosPicoPlacaBean {

	// Invocar entidades necesarias
	private Placa placa = new Placa();
	private Horario horario = new Horario();
	private Scanner entradaEscaner = new Scanner(System.in); // Creación de un objeto Scanner para input
	private ObjetoTemp obj = new ObjetoTemp();

	// variables
	private Integer varPlaca;
	private Date varFecha;
	private Integer varDia;

	// formateadores
	private static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	// variables de tiempo para control de pico y placa
	private static LocalTime tiempo;
	
	//validadores
	private validadorPlaca validadorPlaca = new validadorPlaca();
	private validadorHorario validadorHorario = new validadorHorario();

	// metodos
	// obtener el dia de la semana (int)
	public static int getDayOfTheWeek(Date d) {
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	// ingreso de parametros para verificacion de placa
	public void ingresoDatos() {
		System.out.println("Ingreso de datos...");
		System.out.println("Pico y Placa");

		System.out.println("Por favor ingrese la placa: (ej. ABC-9999)");
		placa.setPlaca(entradaEscaner.nextLine()); // Invocamos un método sobre un objeto Scanner, para asignar el valor
		if (validadorPlaca.validarPlaca(placa.getPlaca()) != 1) {
			System.out.println("el dato ingresado es incorrecto.");
			System.exit(0);
		}
		System.out.println("La placa ingresada es: \"" + placa.getPlaca() + "\"");

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

	}

	public ObjetoTemp procesarDatos() {
		System.out.println("Procesando placa...");
		
		// procesar la placa
		System.out.println("digito placa: " + placa.getPlaca().substring(placa.getPlaca().length() - 1));
		varPlaca = Integer.valueOf(placa.getPlaca().substring(placa.getPlaca().length() - 1)); // obtenemos el ultimo
																								// digito para analizar
																								// la placa segun el
																								// caso
		
		// procesar la fecha
		try {
			varFecha = format.parse(horario.getFecha());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// Los resultados van del 1 = Domingo, 2 = Lunes, 3 = Martes...
		varDia = getDayOfTheWeek(varFecha);
		System.out.println("var dia: " + varDia);
		
		// procesar la hora
		tiempo = LocalTime.parse(horario.getHora());
		
		//guardar los datos en el objeto temporal para que sean procesados
		obj.setVar1(varPlaca);
		obj.setVar2(varDia);
		obj.setVar3(tiempo);
		
		//regresar el objeto para que sea procesado
		return obj;
	}
}
