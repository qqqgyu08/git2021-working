package constructor;

public class StudentExample {

	public static void main(String[] args) {

		Student s1 = new Student();

		s1.name = "홍길동";
		s1.age = 20;
		s1.semester = 2;
		s1.major = "컴퓨터공학";
		System.out.println(s1.name + " " + s1.age);
		s1.JoinCourse();

		Student s2 = new Student("존스미스", 21);

		s2.name = "John Smith";
		s2.age = 21;
		s2.semester = 3;
		s2.major = "경영학";
		System.out.println(s2.name + " " + s2.age);
		s2.JoinCourse();

	}

}
