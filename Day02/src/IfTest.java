import java.util.Scanner;

public class IfTest {

	public static void main(String[] args) {
		
		int score;
		
		Scanner scan = new Scanner(System.in); // 동적프로그래밍 
		
		System.out.print("점수를 입력하세요: >> ");
		score  = scan.nextInt();
		
		if (score >= 90) {
			System.out.println("A");
		}else if(score >= 80){
			System.out.println("B");
		}else if(score >= 70) {
			System.out.println("C");
		}else if(score >= 60) {
			System.out.println("D");
		}else {
			System.out.println("F");
		}
	}
}
