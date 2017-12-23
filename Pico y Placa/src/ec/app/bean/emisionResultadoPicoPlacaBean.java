package ec.app.bean;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

public class emisionResultadoPicoPlacaBean {
	
	// formateadores
		private static DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT)
				.withLocale(Locale.GERMAN);
		
	// variables de tiempo para control de pico y placa
	private static LocalTime inicioDiaPP = LocalTime.parse("07:00", formatter);
	private static LocalTime finDiaPP = LocalTime.parse("09:30");
	private static LocalTime inicioTardePP = LocalTime.parse("16:00");
	private static LocalTime finTardePP = LocalTime.parse("19:30");
	
	
	// metodos
	public void emitirResultado(Integer varDia, Integer varPlaca, LocalTime tiempo) {
		System.out.println("Emitir resultado...");
		// definir los casos para el pico y placa
		// Desde las 7:00 a las 9:30 y desde las 16:00 hasta las 19:30 no podrán
		// circular los automotores
		// cuyo último dígito de la placa termine en:
		// Lunes: 1 y 2; Martes: 3 y 4; Miércoles: 5 y 6; Jueves: 7 y 8; Viernes: 9 y 0
		// vs la var varDia
		switch (varDia) {
		case 1: // domingo
			// no hay restriccion
			System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			break;
		case 2: // lunes
			if (varPlaca.equals(1) | varPlaca.equals(2)) {
				verificarRangoHora(tiempo);
			}  else {
				System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			}
			break;
		case 3: // martes
			if (varPlaca.equals(3) | varPlaca.equals(4)) {
				verificarRangoHora(tiempo);
			} else {
				System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			}
			break;
		case 4: // miercoles
			if (varPlaca.equals(5) | varPlaca.equals(6)) {
				verificarRangoHora(tiempo);
			} else {
				System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			}
			break;
		case 5: // jueves
			if (varPlaca.equals(7) | varPlaca.equals(8)) {
				verificarRangoHora(tiempo);
			} else {
				System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			}
			break;
		case 6: // viernes
			if (varPlaca.equals(9) | varPlaca.equals(0)) {
				verificarRangoHora(tiempo);
			} else {
				System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			}
			break;
		case 7: // sabado
			System.out.println("SIN RESTRICCION, PUEDE CIRCULAR");
			break;
		default:
			System.out.println("parametro invalido!");
			break;
		}
	}
	
	public void verificarRangoHora(LocalTime tiempo) {
		if (tiempo.isBefore(inicioDiaPP) & tiempo.isAfter(finDiaPP)
				| (tiempo.isBefore(inicioTardePP) & tiempo.isAfter(finTardePP))) {
			System.out.println("PUEDE CIRCULAR");
		} else {
			System.out.println("NO PUEDE CIRCULAR");
		}
	}

}
