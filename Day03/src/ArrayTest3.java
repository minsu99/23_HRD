public class ArrayTest3 {

	public static void main(String[] args) {
		// 2차원 배열
		// 행, 열 구조 (표 구조)
		// 2 X 3 행렬 구조

		int arr[][] = new int[2][3];
		/*
		 * [0][0] [0][1] [0][2] [1][0] [1][1] [1][2]
		 * 
		 */

		arr[0][0] = 20;
		arr[0][1] = 30;
		arr[0][2] = 40;
		arr[1][0] = 50;
		arr[1][1] = 60;
		arr[1][2] = 70;

		for (int i = 0; i < arr.length; i++) {  // 2행
			for (int j = 0; j < arr[i].length; j++) { // 3열 
				System.out.println("arr[" + i + "]" + "[" + j +  "]" +" = " + arr[i][j] + " ");
				// 전체배열의 크기를 알 수 있는 것은 .length
			}
		}
	}

}