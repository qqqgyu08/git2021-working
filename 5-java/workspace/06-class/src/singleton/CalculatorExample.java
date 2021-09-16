package singleton;

public class CalculatorExample {
	public static void main(String[] args) {
		System.out.println(Calculator.pi);
		System.out.println(Calculator.plus(10, 5));

		System.out.println(Calculator.getAreaCircle(5));

//		Calculator calc = new Caculator();
	}

}
