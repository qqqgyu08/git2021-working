package method;

public class Student {

	String name;
	int age;
	int semester;
	String major;

	Student() {

	}

	Student(String name, int age, int semester, String major) {
//		Student(String _name){name = _name;} 잘 사용하진 않는 방법
		this.name = name;
		this.age = age;
		this.semester = semester;
		this.major = major;
	}

	// void: 반환형식이 없음
	// 반환형식 메서드명() {...}
	void printInfo() {
		System.out.println(this.name + " " + this.age);
	}

	// 거의 무조건 데이터를 가져오는 메서드는 get~~~ 이런형태이다!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	String getMajorInfo() {
		return this.major + ", 학기: " + this.semester;
	}
}
