package exercise;

public class PrinterExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Printer printer = new Printer();
		printer.println(10);
		printer.println(true);
		printer.println(5.7);
		printer.println("ȫ�浿");

		printer.println("�޽����Դϴ�", 1);
		printer.println("�˸��޽����Դϴ�", 1, "!!");
	}

}
