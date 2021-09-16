package exercise;

public class MemberServiceExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberService();

		Member member = new Member("ȫ�浿", "hong");
		member.pwd = "12345";

		boolean result = memberService.login(member);
		if (result) {
			System.out.println("login complete!");
			memberService.logout("hong");
		} else {
			System.out.println("Wrong id or passwored!");
		}

	}

}
