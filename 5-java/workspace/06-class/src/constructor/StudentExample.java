package constructor;

public class StudentExample {

	public static void main(String[] args) {

		Student s1 = new Student();

		s1.name = "ȫ�浿";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "��ǻ�Ͱ���";
		System.out.println(s1.name + " " + s1.age);
		s1.JoinCourse();

		Student s2 = new Student("�����̽�", 21);

		s2.name = "John Smith";
		s2.age = 21;
		s2.semester = 3;
		s2.major = "�濵��";
		System.out.println(s2.name + " " + s2.age);
		s2.JoinCourse();

	}

}
