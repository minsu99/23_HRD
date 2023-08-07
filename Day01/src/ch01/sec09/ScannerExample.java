package ch01.sec09;

import java.util.Scanner; // ctrl + shift + O  유틸안에 있다. 

public class ScannerExample {//읽어오는

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		String name, dept, sex;
		int age;
		double height;
		
		
		//입력객체생성
		Scanner scan = new Scanner(System.in); //파라미터 입력객체를 전달해줌
		
		//데이터 읽어오기 
		System.out.print("이름을 입력하세요: >>");
		
		name = scan.next();
		
		System.out.print("나이를 입력하세요: >>");
		
		age = scan.nextInt(); // 숫자를 INT로 읽어 
		
		System.out.print("키를 입력하세요: >>");
		
		height = scan.nextDouble(); // double형 
		
		System.out.print("전공을 입력하세요: >>");
		
		dept = scan.next();
		
		System.out.print("성별을 입력하세요: >>");
		
		sex = scan.next();
		
		System.out.printf("이름: %s, 나이: %d, 키: %5.1f, 전공: %s, 성별: %s\n", name, age, height, dept, sex);
		System.out.print("이름: "+ name +"나이: "+ age + "키: " + height + "전공: " + dept);
		*/
		Scanner scan = new Scanner(System.in);
		
		int midscore, finalscore;
		
		System.out.print("중간고사 점수: ");
		midscore = scan.nextInt();
		
		System.out.print("기말고사 점수: ");
		finalscore = scan.nextInt();
		
		System.out.printf("중간고사: %d, 기말고사: %d", midscore, finalscore);
		
	}

}
