package static_;

public class Member {

	final static String SERVICE_NAME = "����� ����";
	static int memberCount = 0;

	String name;
	String id;
	String pwd;
	int age;

	Member(String name, String id) {
		this.name = name;
		this.id = id;
		memberCount++;
	}

	static void printServiceName() {
//		static�������� this ���Ұ�
//		System.out.println(this.serviceName);
		System.out.println(SERVICE_NAME);
	}
}