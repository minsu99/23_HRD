
public class MathTest2 {

	public static void main(String[] args) {

		// 1부터 100까지 3의 배수의 총합
//		int i = 1;
//		int sum = 0;
//		for (i = 1; i <= 100; i++) {
//			if (i % 3 == 0) {
//				sum = sum + i;
//			}
//		}
//		System.out.println("sum: " + sum);

		// *찍기
//		int a , b;
//		for (a = 1; a <= 5; a++) { // 2
//			for (b = 1; b <= a; b++) { // 2
//
//				System.out.print("*");
//
//			}
//			System.out.println();
//
//		}
		
		// *을 피라미드 형식으로 
		int a, b, c;
		for (a = 1; a <= 5; a++) {
		    for (b = 1; b <= 5 - a; b++) {
		        System.out.print(" ");
		    }
		    for (c = 1; c < 2 * a; c++) {
		        System.out.print("*");
		    }
		    System.out.println();
		}


	}
}
