package exercise;

public class MemberService {

	boolean login(Member member) {
		if (member.id == "hong" && member.pwd == "12345") {
			return true;
		}
		return false;
	}

	// 오버로딩
	boolean login(String id, String pwd) {
		if (id.equals("hong") && pwd.equals("12345")) {
			return true;
		} else {
			return false;
		}
	}

	void logout(String id) {
		System.out.println("Logged out!");
	}

}
