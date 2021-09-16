package static_;

public class Member {

	final static String SERVICE_NAME = "배달의 민족";
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
//		static변수에는 this 사용불가
//		System.out.println(this.serviceName);
		System.out.println(SERVICE_NAME);
	}
}