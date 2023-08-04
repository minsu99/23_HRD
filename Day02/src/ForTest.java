
public class ForTest {

	public static void main(String[] args) {
		
		// 1부터 10까지의 합을 출력, 출력 결과만 출력하기 
		//int i,a;
		//int sum = 0;
		
//		for (i =1; i <=10; i++) {
//			sum += i;
//			
//		}
//		System.out.println("1부터 10까지 합: " + sum);
//	}
	
//	 구구단의 2단을 출력하기 
//	 dan을 기준으로 2단부터 1씩 증가시켜서 dan이 10보다 작을때 까지 수행 

//	for (int sum = 2; sum < 10 ; sum++) {
//		
//	for (i = 1; i <= 9; i++) {
//		//sum = 2 * i;
//		System.out.println(sum+" * "+ i+ " = " + sum);
//	}
//	System.out.println("==========");
//	
//	}}}
	
		
		
		
		
//	//while문으로 바꾸기 
	int dan = 2;
	while(dan<10) {
		int i = 1;
		while(i<=9) {
			System.out.println(dan+" * "+ i+ " = " + (dan * i));
			i++;
		}
		System.out.println("~~~~~~~");
		dan++;
		
	}
  }
}



















