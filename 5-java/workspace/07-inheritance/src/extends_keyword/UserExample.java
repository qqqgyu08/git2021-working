package extends_keyword;

public class UserExample {
	public static void main(String[] args) {

		User user = new User();
		user.setId("hong");
		user.setName("È«±æµ¿");
		user.setPhone("01012345678");

		Admin admin = new Admin();
		admin.setId("john");
		admin.setName("John Smith");
		admin.setPhone("0212345678");

		admin.setDeptNo("10001");

		Member member = new Member();
		member.setId("Koo");
		member.setName("ÄíÆÎ¸Ç");
		member.setPhone("01098765432");
		member.printUserInfo();

		member.setPoint(100000);
	}

}
