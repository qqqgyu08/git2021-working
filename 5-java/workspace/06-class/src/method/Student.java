package method;

public class Student {

	String name;
	int age;
	int semester;
	String major;

	Student() {

	}

	Student(String name, int age, int semester, String major) {
//		Student(String _name){name = _name;} �� ������� �ʴ� ���
		this.name = name;
		this.age = age;
		this.semester = semester;
		this.major = major;
	}

	// void: ��ȯ������ ����
	// ��ȯ���� �޼����() {...}
	void printInfo() {
		System.out.println(this.name + " " + this.age);
	}

	// ���� ������ �����͸� �������� �޼���� get~~~ �̷������̴�!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	String getMajorInfo() {
		return this.major + ", �б�: " + this.semester;
	}
}
