package exercise;

import java.util.Date;

public class Printer {

	public void println(int i) {
		// TODO Auto-generated method stub
		System.out.println(i);
	}

	void println(boolean b) {
		// TODO Auto-generated method stub
		System.out.println(b);
	}

	void println(double d) {
		// TODO Auto-generated method stub
		System.out.println(d);
	}

	void println(String string) {
		// TODO Auto-generated method stub
		System.out.println(new Date().toLocaleString() + ": " + string);
	}

	void println(String string, int i) {
		// TODO Auto-generated method stub
		System.out.println(i + " " + string);

	}

	void println(String string, int i, String postfix) {
		// TODO Auto-generated method stub
		System.out.println(i + " " + string + " " + postfix);
	}

	// 출력할 때 앞에 데코레이터를 추가해서 출력
	// println("홍길동", 1)
	// 1 홍길동

	// 출력할 때 앞/뒤에 데코레이터를 추가해서 출력
	// println("홍길동", 1, "--");
	// 1 홍길동 --
}
