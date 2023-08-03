package ch01.sec09;

public class Test12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a= 10, b= 20;
		System.out.println(a > b); //논리가 출력된다.
		
		String c= "홍길동", d= "박길동";
		System.out.println(c == d); // 사실 이건 안되는거
		
		System.out.println(c.equals(d)); //문자열 비교는 equals
		
		System.out.println(c != d);
		System.out.println(! c.equals(d)); // 문자열 비교 같지 않다.
	}

}
