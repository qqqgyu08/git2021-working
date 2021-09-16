package constructor.sub;

public class Student {

	String name;
	int age;
	int semester;
	String major;

	public Student() {

	}

	Student(String name, int age) {
//		Student(String _name){name = _name;} 잘 사용하진 않는 방법
		this.name = name;
		this.age = age;
	}

	void JoinCourse() {

	}
}
