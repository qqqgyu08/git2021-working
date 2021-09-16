package string;

public class StringExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name1 = "지선규";
		String name2 = "지선규";
//		System.out.println(name1 == name2); // 이렇게 쓰면 뒤짐
//		!! String인 경우 동치 비쵸에 equal 함수를 사용
		System.out.println(name1.equals(name2));

		String name3 = new String("지선규");
		String name4 = new String("지선규");
//		System.out.println(name3 == name4); // 이렇게 하지마라
//		!! String인 경우 동치 비쵸에 equal 함수를 사용
		System.out.println(name3.equals(name4));

//		이렇게 쓰면 ㅈㄴ 갈굴예정
//		if(name3 == "지선규") {
//			
//		}

//		오직 equals함수만 사용
		if (name3.equals("지선규")) {

		}

	}

}
