package array;

public class CreateByNewExample {
	public static void main(String[] args) {
		int[] arrInt = new int[3]; 			// 크기가 3인 int배열 생성
		System.out.println(arrInt[0]);		// 0 초기화 되어있음
		System.out.println(arrInt[1]); 		// 0 초기화 되어있음
		System.out.println(arrInt[2]); 		// 0 초기화 되어있음
		
		for (int i=0; i<3; i++) {
			System.out.println(arrInt[i]);
		}

		String[] arrStr = new String[3];	// 크기가 3인 String배열 생성
		System.out.println(arrStr[0]);		// null 초기화 되어있음
		System.out.println(arrStr[1]);  	// null 초기화 되어있음
		System.out.println(arrStr[2]);  	// null 초기화 되어있음
		
//		향상된 for-문(enhanced(advanced) for loop)
//		for of문 유사
//		for(요소변수타입 요소변수 : 배열변수명) {	
//		}
		for (String str : arrStr) {
			str = "test";
			System.out.println(str);
		}
	}

}
