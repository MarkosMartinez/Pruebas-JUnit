package prueba;

public class Calculadora {
	private int a,b;
	
	public Calculadora(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	public int suma (){
		return a+b;
	}
	
	public int resta (){
		return a-b;
	}
	
	public int divide (){
			return a/b;
		}
	
	public int multiplica (){
		return a*b;
	}
	
	/*public static void main(String[] args) {
		Calculadora calculadora1 = new Calculadora(2, 3);
		int resultado = calculadora1.suma();
		if(resultado != 5) {
			System.out.println("Metodo suma no funciona");
		}
	}*/
	
	public static void main(String[] args) {
	Calculadora calculadora1 = new Calculadora(2, 3);
	int resultado = calculadora1.suma();
	if(resultado != 5) {
		System.out.println("Metodo suma no funciona");
	}
}

}
