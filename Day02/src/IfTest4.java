import java.util.Scanner;

public class IfTest4 {

	public static void main(String[] args) {
	
	// 0부터 9까지 정수를 입력받아 짝/홀수 판단	
	Scanner scan = new Scanner(System.in);
	System.out.print("0부터 9까지 정수 입력: ");
	int n;
	n = scan.nextInt();
	if(n % 2 != 0) {
		System.out.println(" 홀수입니다");
	}else {
		System.out.println("짝수 입니다");
	}
		
		
		
		
	}
	
}
