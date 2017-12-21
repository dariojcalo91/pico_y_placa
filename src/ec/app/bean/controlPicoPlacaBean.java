package ec.app.bean;



import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.Scanner;

import ec.app.objeto.horario;
import ec.app.objeto.placa;

public class controlPicoPlacaBean {
	
	//definicion de clases necesarias
	private placa placa = new placa();
	private horario horario =  new horario();
	
	private String evaluar;
	
	DateTimeFormatter formatter =
	        DateTimeFormatter
	                .ofLocalizedTime(FormatStyle.SHORT)
	                .withLocale(Locale.GERMAN);

	LocalTime leetTime = LocalTime.parse("13:37",formatter);
	 
	
	LocalTime inicioDiaPP = LocalTime.parse("07:00",formatter);
	LocalTime finDiaPP = LocalTime.parse("09:30");
	LocalTime inicioTardePP = LocalTime.parse("16:00");
	LocalTime finTardePP = LocalTime.parse("19:30");

	//definicion de metodos
		//ingreso de parametros para verificacion de placa
	@SuppressWarnings("resource")
	public void ingresoDatos() {		
		Scanner entradaEscaner = new Scanner (System.in); //Creación de un objeto Scanner
		
		System.out.println ("Pico y Placa");
		
		System.out.println ("Por favor ingrese la placa:");
		placa.setPlaca(entradaEscaner.nextLine()); //Invocamos un método sobre un objeto Scanner, para asignar el valor
		System.out.println ("La placa ingresada es: \"" + placa.getPlaca() +"\"");
		
		System.out.println ("Por favor ingrese la fecha:");
		horario.setFecha(entradaEscaner.nextLine());
		System.out.println ("La fecha ingresada es: \"" + horario.getFecha() +"\"");
		
		System.out.println ("Por favor ingrese la hora:");
		System.out.println ("Hora:");
		horario.setHora(Integer.valueOf(entradaEscaner.nextLine()));
		System.out.println ("Minutos:");
		horario.setMinuto(Integer.valueOf(entradaEscaner.nextLine()));
		
		System.out.println ("Evaluar la placa?:");
		evaluar = entradaEscaner.nextLine();
		
		if (evaluar.toUpperCase().equals("S") | evaluar.toUpperCase().equals("SI")) {
			//invocar el metodo para proceso de placa
			procesarDatos();
		} else {
			//fin proceso
			System.out.println ("Fin evaluacion");
		}
	}
	
	public void procesarDatos() {
		//procesar la placa
		System.out.println(placa.getPlaca().length());
		System.out.println(placa.getPlaca().substring(placa.getPlaca().length(), -1));
		Integer var = Integer.valueOf(placa.getPlaca().substring(placa.getPlaca().length(), -1)); //obtenemos el ultimo digito para analizar la placa segun el caso
		//procesar la hora
		LocalTime tiempo = LocalTime.parse(horario.getHora().toString().concat(":").concat(horario.getMinuto().toString()));
		//definir los casos para el pico y placa
		//Desde las 7:00 a las 9:30 y desde las 16:00 hasta las 19:30 no podrán circular los automotores
		//cuyo último dígito de la placa termine en:
		//Lunes: 1 y 2; Martes: 3 y 4; Miércoles: 5 y 6; Jueves: 7 y 8; Viernes: 9 y 0
		if(var.equals(1) | var.equals(2)) {
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
		}
		if(var.equals(3) | var.equals(4)) {
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
		}
		if(var.equals(5) | var.equals(6)) {
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
		}
		if(var.equals(7) | var.equals(8)) {
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
		}
		if(var.equals(9) | var.equals(0)) {
			if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP) | (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
				System.out.println("PUEDE CIRCULAR");
			} else {
				System.out.println("NO PUEDE CIRCULAR");
			}
		}
	}
}
