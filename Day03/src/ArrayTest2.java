public class ArrayTest2 {

	public static void main(String[] args) {
		//배열을 이용해 10개 정수 저장, 평균값을 구하는 문제 
		
		// 1. 배열 선언 
		int scores []; // 메인 함수의 스택에 저장 
		
		// 2. 배열 초기화
		scores = new int[10]; // 힙 메모리의 주소값 
		
		// 3. 명시적 초기화
		scores[0] = 83;
		scores[1] = 90;
		
		// 4. 동시에 배열 선언과 초기화
		int scores1[] = {83,90,70,60,50,70,90,100,99,70};
		
		// 5. 값을 꺼내서 합산 후 배열 개수로 나눈다.
		int sum = 0;
		for(int i = 0; i < 10; i++) {
			sum += scores1[i];
		}
		System.out.println("AVG: "+ sum / scores1.length);
		
		scores1[4] = 90;  // 수정
		for(int i =0; i<10; i++) {
			System.out.println(scores1[i]);
		}
		
		for(int i = 0; i <10; i++) {
			sum += scores1[i];
		}
		System.out.println("AVG: "+ sum / scores1.length);

	}

}