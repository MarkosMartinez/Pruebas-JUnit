package prueba;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

class CalculadoraTest {
	private Calculadora calculadora;
	
	@BeforeEach /*@BeforeAll y @Before con static y public*/
	void SetUp() {
	calculadora = new Calculadora(6,3);
	System.out.println("Before each");
	}

	@Test
	@EnabledOnOs(OS.LINUX)
	@DisplayName("Comprobacion de la suma")
	void testSuma() {
		assertEquals(9, calculadora.suma());
	}
	
	@Test
	@DisplayName("Comprobacion de la resta")
	void testResta() {
		assertEquals(3, calculadora.resta());
	}
	
	@Test
	@DisplayName("Comprobacion de la division")
	void testDivision() {
		assertEquals(2, calculadora.divide());
	}
	
	@Test
	@DisplayName("Comprobacion de la multiplicacion")
	void testMultiplicacion() {
		assertEquals(18, calculadora.multiplica());
	}
	
	@Test
	@DisplayName("Comprobacion de todas nuestras operaciones")
	void testTotal() {
		assertAll("calculadora",
				()-> assertEquals(9,  calculadora.suma()),
				()-> assertEquals(3, calculadora.resta()),
				()-> assertEquals(2, calculadora.divide()),
				()-> assertEquals(18, calculadora.multiplica()));
	}

}
