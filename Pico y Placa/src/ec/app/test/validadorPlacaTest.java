package ec.app.test;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import ec.app.validador.validadorPlaca;

public class validadorPlacaTest {

	//PRUEBAS FECHA - empleando JUnit
	//Caso correcto
	@Test
	public void testValidarPlacaCorrecto() {
		int resultadoReal;
		int resultadoEsperado = 1;
		validadorPlaca vp = new validadorPlaca();
		resultadoReal = vp.validarPlaca("PIC-1512");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	
	//Casos de error
	@Test
	public void testValidarPlacaIncorrecto1() {
		int resultadoReal;
		int resultadoEsperado = -1;
		validadorPlaca vp = new validadorPlaca();
		resultadoReal = vp.validarPlaca("PIC");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	@Test
	public void testValidarPlacaIncorrecto2() {
		int resultadoReal;
		int resultadoEsperado = -1;
		validadorPlaca vp = new validadorPlaca();
		resultadoReal = vp.validarPlaca("PIC15112");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
	@Test
	public void testValidarPlacaIncorrecto3() {
		int resultadoReal;
		int resultadoEsperado = -1;
		validadorPlaca vp = new validadorPlaca();
		resultadoReal = vp.validarPlaca("-");
		assertEquals(resultadoEsperado, resultadoReal);
		System.out.println("FIN PRUEBA");
		//fail("Not yet implemented");
	}
}
