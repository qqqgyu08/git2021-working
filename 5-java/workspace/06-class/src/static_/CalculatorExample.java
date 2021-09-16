package static_;

public class CalculatorExample {
	public static void main(String[] args) {
		System.out.println(Calculator.pi);
		System.out.println(Calculator.plus(10, 5));

		System.out.println(Calculator.getAreaCircle(5));

		// static 변수 값은 수정 가능함
//		final 키워드 때매 수정불가 됨
//		Calculator.pi = 3.14;

		// Calculator calc = new Caculator();
	}

}
