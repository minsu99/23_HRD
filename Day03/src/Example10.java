import java.util.Scanner;

public class Example10 {

	public static void main(String[] args) {
		 boolean run = true;

		 int SNum = 0;
		 int array[]= null;
		Scanner scan = new Scanner(System.in);

		 while(run) {
		 System.out.println("--------------------------------------------------------------");
		 System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
		 System.out.println("--------------------------------------------------------------");
		 System.out.print("선택> ");

		 int num = scan.nextInt();

		 if(num == 1) {
		 System.out.print("학생수> ");
		 SNum = scan.nextInt();
		 array = new int[SNum];   // 배열의 크기가 "학생 수" 로 결정!!!!
		 } else if(num == 2) {
			 for(int i=0; i<array.length; i++) {
			 System.out.print("scores[" + i + "]> ");
			 array[i] = scan.nextInt(); // 학생 수 만큼 배열의 크기가 정해지고, 값을 입력받는다.
			 }
		 } else if(num == 3) {// 배열에 저장된 것들을 보여줌 
			 for(int i=0; i<array.length; i++) {
			 System.out.println("scores[" + i + "]: " + array[i]);
			 }  
		 } else if(num == 4) { // 최고 점수와 최대 점수를 알려줌 
			 int max = 0;
			 int sum = 0;
			 double avg = 0;
			 for(int i= 0; i<array.length; i++) {
			 max = (max<array[i])? array[i] : max;  
			 sum += array[i];
			 }
			 avg = (double) sum / SNum;
			 System.out.println("최고 점수: " + max);
			 System.out.println("평균 점수: " + avg);
		 } else if(num == 5) {
			 run = false;
		 }
		}

		 System.out.println("프로그램 종료");
		}
		

}