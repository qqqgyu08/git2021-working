package exercise;

import java.util.Scanner;

public class ScannerExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("--�Է°��� �Է��ϼ���.--");
		System.out.println(">");
		
		String input ="";
		input = scanner.next();
		
		System.out.println(input);
		
		int num = 0;
//		int amount = 0;
		
		System.out.println("--�Է°��� �Է��ϼ���.--");
		num = scanner.nextInt();
		
		System.out.println(num);
	}

}
