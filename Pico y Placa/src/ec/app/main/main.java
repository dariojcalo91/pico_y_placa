package ec.app.main;

import ec.app.bean.emisionResultadoPicoPlacaBean;
import ec.app.bean.ingresoDatosPicoPlacaBean;
import ec.app.bean.procesarDatosPicoPlacaBean;
import ec.app.objeto.Horario;
import ec.app.objeto.Placa;
import ec.app.objeto.ext.DatosProceso;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ingresoDatosPicoPlacaBean ingresoDatos = new ingresoDatosPicoPlacaBean();
		procesarDatosPicoPlacaBean procesoDatos = new procesarDatosPicoPlacaBean();
		emisionResultadoPicoPlacaBean emision = new emisionResultadoPicoPlacaBean();
		
		Placa placa = new Placa();
		Horario horario = new Horario();
		DatosProceso datosProceso = new DatosProceso();
		
		placa = ingresoDatos.ingresoDatosPlaca();
		horario = ingresoDatos.ingresoDatosHorario();
		
		datosProceso = procesoDatos.procesarDatos(placa, horario);
		emision.emitirResultado(datosProceso.getVarDia(), datosProceso.getVarPlaca(), datosProceso.getVarTiempo());
	}
}
