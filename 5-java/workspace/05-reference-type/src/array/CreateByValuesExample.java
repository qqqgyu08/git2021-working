package array;

public class CreateByValuesExample {

	public static void main(String[] args) {
//		int�迭�̴� int�� ���� �ִ�
		int[] scores = { 83, 90, 87 };

//		Java�� �迭�� ó�� ������� ũ�Ⱑ ������
		scores[0] = 100;
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		scores[0] = 0; // null�� ó�� �Ұ���
	}

}
