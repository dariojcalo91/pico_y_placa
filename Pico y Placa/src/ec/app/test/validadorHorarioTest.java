package ec.app.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ec.app.validador.validadorHorario;

public class validadorHorarioTest {

	//PRUEBAS FECHA - empleando JUnit
	//Caso correcto
	@Test
	public void testValidarHorarioFechaCorrecto() {
		boolean resultadoReal;
		boolean resultadoEsperado = true;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioFecha("26/12/2017");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	//Casos de error
	@Test
	public void testValidarHorarioFechaIncorrecto1() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioFecha("26122017");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	@Test
	public void testValidarHorarioFechaIncorrecto2() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioFecha("26/122017");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	@Test
	public void testValidarHorarioFechaIncorrecto3() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioFecha("26/1220/17");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	//PRUEBAS HORA
	//Caso correcto
	@Test
	public void testValidarHorarioHoraCorrecto() {
		boolean resultadoReal;
		boolean resultadoEsperado = true;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioHora("12:10");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	//Casos de error
	@Test
	public void testValidarHorarioHoraIncorrecto1() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioHora("1210");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	@Test
	public void testValidarHorarioHoraIncorrecto2() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioHora("12:1");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	@Test
	public void testValidarHorarioHoraIncorrecto3() {
		boolean resultadoReal;
		boolean resultadoEsperado = false;
		validadorHorario vh = new validadorHorario();
		resultadoReal = vh.validarHorarioHora("2:10");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
}
