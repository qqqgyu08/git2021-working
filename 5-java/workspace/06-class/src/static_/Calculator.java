package static_;

public class Calculator {
	// final Ű���带 �ָ� �����Ұ���
	// js: const
	// �� static�� �ִ°� �ƴ�, �ַ� static ������ ���
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
