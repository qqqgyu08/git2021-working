package method;

public class StudentExample {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.name = "ȫ�浿";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "��ǻ�Ͱ���";
		s1.printInfo();

		Student s2 = new Student("�����̽�", 21, 3, "�ڹ���");
		s2.printInfo();
		System.out.println(s2.getMajorInfo());

	}

}
