package prueba;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class CalculadoraExcepcionesDivideTest {
	
	static Calculadora c;

	@BeforeAll
	static void setUp() {
		c= new Calculadora(10, 0);
	}
	
	@Test
	void testExcepcion1() {
		try {
			c.divide();
			fail("Fallo, porque debería saltar la excepcion");
		} catch (Exception e) {

		}
	}
	
	/*@Test(excepted = java.lang.Exception.class) //Probablemente por la version 5 de JUnit
	void testExcepcion2() {
		int resultado = c.divide();
		
	}*/
	
	@Test
	void testExcepcion3() {
		Exception e= assertThrows(Exception.class, ()->c.divide());
		
	}

}
