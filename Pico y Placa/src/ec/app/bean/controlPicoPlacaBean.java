package ec.app.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.Scanner;

import ec.app.objeto.horario;
import ec.app.objeto.placa;

public class controlPicoPlacaBean {
	
	//definicion de clases necesarias
	private placa placa = new placa();
	private horario horario =  new horario();
	
	//variables
	private Integer varPlaca;
	private Date date;
	private Integer varDia;
	
	//formateadores
	private DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(Locale.GERMAN);
	
	//variables de tiempo para control de pico y placa
	private LocalTime inicioDiaPP = LocalTime.parse("07:00",formatter);
	private LocalTime finDiaPP = LocalTime.parse("09:30");
	private LocalTime inicioTardePP = LocalTime.parse("16:00");
	private LocalTime finTardePP = LocalTime.parse("19:30");
	private LocalTime tiempo;

	//definicion de metodos
	//obtener el dia de la semana (int)
	public static int getDayOfTheWeek(Date d){
		System.out.println("date: "+d);
		GregorianCalendar cal = new GregorianCalendar();
		cal.setTime(d);
		System.out.println("out date: "+cal.get(Calendar.DAY_OF_WEEK));
		return cal.get(Calendar.DAY_OF_WEEK);		
	}
	
	//ingreso de parametros para verificacion de placa
	@SuppressWarnings("resource")
	public void ingresoDatos() {		
		System.out.println("Ingreso de datos...");
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		
		System.out.println ("Pico y Placa");
		
		System.out.println ("Por favor ingrese la placa: (ej. ABC-9999)");
		placa.setPlaca(entradaEscaner.nextLine()); //Invocamos un método sobre un objeto Scanner, para asignar el valor
		System.out.println ("La placa ingresada es: \"" + placa.getPlaca() +"\"");
		
		System.out.println ("Por favor ingrese la fecha, separada por /: (ej. 01/12/1999)");
		horario.setFecha(entradaEscaner.nextLine());
		System.out.println ("La fecha ingresada es: \"" + horario.getFecha() +"\"");
		
		System.out.println ("Por favor ingrese la hora: (ej: 20:30)");
		System.out.println ("Hora:");
		horario.setHora(entradaEscaner.nextLine());
		
	}
	
	public void procesarDatos() {
		System.out.println("Procesando placa...");
		
		//procesar la placa
		System.out.println("digito placa: "+placa.getPlaca().substring(placa.getPlaca().length()-1));
		varPlaca = Integer.valueOf(placa.getPlaca().substring(placa.getPlaca().length() -1)); //obtenemos el ultimo digito para analizar la placa segun el caso
		
		//procesar la fecha
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		try {
			date = format.parse(horario.getFecha());
			System.out.println("formateo: "+date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Los resultados van del 1 = Domingo, 2 = Lunes, 3 = Martes...
		varDia = getDayOfTheWeek(date);
		System.out.println("var dia: "+varDia);
		
		//procesar la hora
		tiempo = LocalTime.parse(horario.getHora());
		
	}
	
	public void emitirResultado() {
		System.out.println("Emitir resultado...");
		//definir los casos para el pico y placa
		//Desde las 7:00 a las 9:30 y desde las 16:00 hasta las 19:30 no podrán circular los automotores
		//cuyo último dígito de la placa termine en:
		//Lunes: 1 y 2; Martes: 3 y 4; Miércoles: 5 y 6; Jueves: 7 y 8; Viernes: 9 y 0 vs la var varDia
		
		if((varPlaca.equals(1) | varPlaca.equals(2)) & varDia == 2) { 
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
			System.out.println("placa de lunes");
		} else {
			if((varPlaca.equals(3) | varPlaca.equals(4))  & varDia == 3) {
				if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
					System.out.println("PUEDE CIRCULAR");
				} else {
					System.out.println("NO PUEDE CIRCULAR");
				}
				System.out.println("placa de martes");
			} else {
				if((varPlaca.equals(5) | varPlaca.equals(6))  & varDia == 4) {
					if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
						System.out.println("PUEDE CIRCULAR");
					} else {
						System.out.println("NO PUEDE CIRCULAR");
					}
					System.out.println("placa de miercoles");
				} else {
					if((varPlaca.equals(7) | varPlaca.equals(8))  & varDia == 5) {
						if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
							System.out.println("PUEDE CIRCULAR");
						} else {
							System.out.println("NO PUEDE CIRCULAR");
						}
						System.out.println("placa de jueves");
					} else {
						if((varPlaca.equals(9) | varPlaca.equals(0))  & varDia == 6) {
							if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
								System.out.println("PUEDE CIRCULAR");
							} else {
								System.out.println("NO PUEDE CIRCULAR");
							}
							System.out.println("placa de viernes");
						} else {
							System.out.println("PUEDE CIRCULAR");
						}
					}
				}
			}
		} 
	}
}
