package string;

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "������";
		String name2 = "������";
//		System.out.println(name1 == name2); // �̷��� ���� ����
//		!! String�� ��� ��ġ ���ݿ� equal �Լ��� ���
		System.out.println(name1.equals(name2));

		String name3 = new String("������");
		String name4 = new String("������");
//		System.out.println(name3 == name4); // �̷��� ��������
//		!! String�� ��� ��ġ ���ݿ� equal �Լ��� ���
		System.out.println(name3.equals(name4));

//		�̷��� ���� ���� ��������
//		if(name3 == "������") {
//			
//		}

//		���� equals�Լ��� ���
		if (name3.equals("������")) {

		}

	}

}
