package ec.app.main;

import ec.app.bean.emisionResultadoPicoPlacaBean;
import ec.app.bean.ingresoDatosPicoPlacaBean;
import ec.app.objeto.ext.ObjetoTemp;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ingresoDatosPicoPlacaBean ingresoDatos = new ingresoDatosPicoPlacaBean();
		emisionResultadoPicoPlacaBean emision = new emisionResultadoPicoPlacaBean();
		ObjetoTemp objTemp = new ObjetoTemp();
		
		ingresoDatos.ingresoDatos();
		objTemp = ingresoDatos.procesarDatos();
		emision.emitirResultado(objTemp.getVar1(), objTemp.getVar2(), objTemp.getVar3());
	}
}
