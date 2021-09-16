package static_;

public class Calculator {
	// final 키워드를 주면 수정불가함
	// js: const
	// 꼭 static에 넣는건 아님, 주로 static 변수에 사용
	final static double pi = 3.141592;
//	static double pi = 3.141592;

	static int plus(int a, int b) {
		return a + b;
	}

	static int minus(int a, int b) {
		return a - b;
	}

	static double getAreaCircle(int r) {
		return r * r * pi;
	}

}
