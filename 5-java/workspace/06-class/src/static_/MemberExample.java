package static_;

public class MemberExample {

	public static void main(String[] args) {

//		static 메서드에 접근하는 방법은 클래스명, 메서드명(...)
		Member.printServiceName();

		Member member1 = new Member("홍길동", "hong");
		Member member2 = new Member("강자바", "java");

		System.out.println(Member.SERVICE_NAME + ", 이름: " + member1.name + ", 아이디: " + member1.id);
		System.out.println(Member.SERVICE_NAME + ", 이름: " + member2.name + ", 아이디: " + member2.id);

		System.out.println("회원수: " + Member.memberCount);
	}

}
