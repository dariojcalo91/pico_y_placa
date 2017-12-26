package ec.app.bean;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import ec.app.objeto.Horario;
import ec.app.objeto.Placa;
import ec.app.objeto.ext.DatosProceso;

public class procesarDatosPicoPlacaBean {
	
	private DatosProceso datos = new DatosProceso();

	// variables
	private Integer varPlaca;
	private Date varFecha;
	private Integer varDia;

	// formateadores
	private static DateFormat format = new SimpleDateFormat("dd/MM/yyyy");

	// variables de tiempo para control de pico y placa
	private static LocalTime tiempo;
	
	public DatosProceso procesarDatos(Placa placa, Horario horario) {
		System.out.println("Procesando placa...");
		
		// metodos
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
		datos.setVarPlaca(varPlaca);
		datos.setVarDia(varDia);
		datos.setVarTiempo(tiempo);
		
		//regresar el objeto para que sea procesado
		return datos;
	}

	// obtener el dia de la semana (int)
		public static int getDayOfTheWeek(Date d) {
			GregorianCalendar cal = new GregorianCalendar();
			cal.setTime(d);
			return cal.get(Calendar.DAY_OF_WEEK);
		}
}
