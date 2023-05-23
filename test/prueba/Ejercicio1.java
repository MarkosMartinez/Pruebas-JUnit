package prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;


class Ejercicio1 {

private Calculadora calculadora;
	
	//FASE 1
	@BeforeEach
	void SetUp() {
	calculadora = new Calculadora(6,3);
	System.out.println("Despues de cada uno");
	}

	@Test
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
	
	
	
	//FASE 2
	@ParameterizedTest
	@DisplayName("ParameterizedTest Suma CSV SOURCE")
	@CsvSource({"2, 3, 5", "-1, 0, -1", "5, 4, 9" })
	void parameterizedSumaCsvSource(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.suma();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Resta CSV SOURCE")
	@CsvSource({"5, 3, 2", "-5, 2, -7", "0, 0, 0" })
	void parameterizedRestaCsvSource(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.resta();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Division CSV SOURCE")
	@CsvSource({"10, 2, 5", "-10, 2, -5", "5, 2, 2,5" })
	void parameterizedDivisionCsvSource(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.divide();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Multiplicacion CSV SOURCE")
	@CsvSource({"2, 3, 6", "33, 1, 33", "8, 0, 0" })
	void parameterizedMultiplicacionCsvSource(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.multiplica();
		assertEquals(resultado, esperado);
	}

	
	
	//FASE 3
	@ParameterizedTest
	@DisplayName("ParameterizedTest Suma CSV SOURCE FILE")
	@CsvFileSource(resources = "datosSuma.csv")
	void parameterizedSumaCsvSourceFile(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.suma();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Resta CSV SOURCE FILE")
	@CsvFileSource(resources = "datosResta.csv")
	void parameterizedRestaCsvSourceFile(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.resta();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Multiplicacion CSV SOURCE FILE")
	@CsvFileSource(resources = "datosMultiplicacion.csv")
	void parameterizedMultiplicacionCsvSourceFile(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.multiplica();
		assertEquals(resultado, esperado);
	}
	
	@ParameterizedTest
	@DisplayName("ParameterizedTest Division CSV SOURCE FILE")
	@CsvFileSource(resources = "datosDivision.csv")
	void parameterizedDivisionCsvSourceFile(int valor1, int valor2, int esperado) {
		Calculadora calc = new Calculadora(valor1, valor2);
		int resultado = calc.divide();
		assertEquals(resultado, esperado);
	}
	
	
	
	//FASE 4
	@SuppressWarnings("unused")
	@Test
	@DisplayName("Division cero ERROR")
	void testDivisionCero(){
		Calculadora calcError = new Calculadora(5, 0);
		IllegalArgumentException e = assertThrows(IllegalArgumentException.class, () -> {
			
			calcError.divide();
			
		});
	}
	
	
	
	//FASE 5
	@Test
	public void testTiempoEjecuccion() {
		assertTimeout(Duration.ofSeconds(4), () -> {
            Thread.sleep(3000); //Si el tiempo de ejecuccion es menor a 4 segundos, funcionara correctamente
        });
	}
}
