package ch01.sec09;

//import java.util.Scanner;

public class Test14 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		int x = 10;
		int y = 20;
		int z = (++x) + (y--);
		
		System.out.println(z);
		System.out.println(y);
		System.out.println(x);
	   
		
		int p = 534;
		int s = 30;
		
		int pencilsPerStudent = (p/s);
		System.out.println(pencilsPerStudent);
		
		int pencilsLeft=(p%s);
		System.out.println(pencilsLeft);
		*/
		/*
		int value = 356;
		System.out.println(value-56); //300으로 표현해라 
		
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
		double area = ((double)((lengthTop+lengthBottom)*height/ 2));
		System.out.println(area);
		
		
		int x = 10;
		int y = 5;
		
		System.out.println((x>7) && (y<=5));
		System.out.println((x%3 == 2) || (y%2 != 1));
		*/
		
		double x = 5.0;
		double y = 0.0;
		double z = 5 % y;
		
		if(Double.isNaN(z)) // 이건 뭐야 ㅅㅂ
		System.out.println("0.0을 나눌 수 없습니다");
		
		else { // 두 줄이 출력될 경우 복합문이면 중괄호로 묶는다 
			double result = z + 10;
			System.out.println("결과: "+ result);
		}
		
		
		
		
	}

}
