package prueba;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.runners.Parameterized.Parameters;

class CalculadoraParametrosTest {

	@Parameters
	public static ArrayList<Object> getData(){
		ArrayList<Object> obj = new ArrayList<>();
		obj.add(new Object[] {1, 3, 4});
		obj.add(new Object[] {2, 3, 5});
		obj.add(new Object[] {4, 4, 8});
		return obj;
	}
	private int a, b, esperado;
	
	public CalculadoraParametrosTest(int a, int b, int esperado) {
		this.a = a;
		this.b = b;
		this.esperado = esperado;
	}
	
	@Test
	public void testSuma() {
		Calculadora c = new Calculadora(a, b);
		int resultado = c.suma();
		assertEquals(esperado, resultado);
	}

}
