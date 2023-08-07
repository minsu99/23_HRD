package ch01.sec09;

//import java.util.Scanner;

public class Test13 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int charCode = 'A';
		int charCode2 = 11;
		double charCode3 = 160;
		//Scanner scan = new Scanner(System.in);
		
		// charCode가 65이상 90이하 
		if ((65<=charCode) && (charCode <= 90))
			System.out.println("대문자");
		
		// 15세 이상 160이하 
		if ((15<=charCode2) && (charCode3 <= 160)) 
			System.out.println("놀이기구 탑승가능");
		else
			System.out.println("놀이기구 탑승불가능");
		
		if ((15<=charCode2) || (charCode3 <= 160))
			System.out.println("놀이기구 탑승가능");
		else
			System.out.println("놀이기구 탑승불가능");
		
		// 짝수, 홀수 구분
		if(charCode2 % 2 == 0) 
			System.out.println("짝수 입니다.");
		else
			System.out.println("홀수 입니다");
		
		// 삼항연산자
		boolean k;
		k = (charCode2 % 2) == 0;
		System.out.println(k ? "짝수" : "홀수");
	}

}
