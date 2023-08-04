
public class WhileTest1 {

	public static void main(String[] args) {
		//1~10까지의 합  2. 리버스 합 
		//int i=1;
		int sum = 2;
		
//		while(i>=1) {
//			sum += i;
//			i--; // 증감식을 꼭 넣어줘라 아니면 무한 반복한다.
//			System.out.println(i);
//			
//		}
		
		
		int dan = 2;
		while(dan<10) {//9단 출력까지 
			int i = 1; 
			while(i<=9) { //2단 출력
				System.out.println(dan+" * "+ i+ " = " + (dan * i));
				i++;
			}
			System.out.println("~~~~~~~~~~");
			dan++;
		}
		
		

     }
}
