package exercise;

import constructor.sub.Student;
// 클래스명이 같으면 import 불가함
// import constructor.Student;

public class MemberExample {

	public static void main(String[] args) {
		Member member1 = new Member("홍길동", "hong");
		Member member2 = new Member("강자바", "java");

		// 2. 클래스
		Student student = new Student();
		// 패키지명1.패키지명2....Student
//		constructor.sub.Student student = new constructor.sub.Student();

		System.out.println(member1.name + " " + member1.id);
		System.out.println(member2.name + " " + member2.id);
	}

}
