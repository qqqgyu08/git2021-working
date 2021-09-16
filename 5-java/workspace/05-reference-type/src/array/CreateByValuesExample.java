package array;

public class CreateByValuesExample {

	public static void main(String[] args) {
//		int배열이니 int만 들어갈수 있다
		int[] scores = { 83, 90, 87 };

//		Java의 배열은 처음 만들어진 크기가 고정됨
		scores[0] = 100;
		System.out.println(scores[0]);
		System.out.println(scores[1]);
		System.out.println(scores[2]);
		scores[0] = 0; // null값 처리 불가능
	}

}
