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

	// ����� �� �տ� ���ڷ����͸� �߰��ؼ� ���
	// println("ȫ�浿", 1)
	// 1 ȫ�浿

	// ����� �� ��/�ڿ� ���ڷ����͸� �߰��ؼ� ���
	// println("ȫ�浿", 1, "--");
	// 1 ȫ�浿 --
}
