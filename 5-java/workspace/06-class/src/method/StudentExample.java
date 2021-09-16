package method;

public class StudentExample {

	public static void main(String[] args) {

		Student s1 = new Student();
		s1.name = "홍길동";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "컴퓨터공학";
		s1.printInfo();

		Student s2 = new Student("존스미스", 21, 3, "자바웹");
		s2.printInfo();
		System.out.println(s2.getMajorInfo());

	}

}
