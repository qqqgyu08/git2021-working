package constructor;

public class Student {

	String name;
	int age;
	int semester;
	String major;

	Student() {

	}

	Student(String name, int age) {
//		Student(String _name){name = _name;} �� ������� �ʴ� ���
		this.name = name;
		this.age = age;
	}

	void JoinCourse() {

	}
}
