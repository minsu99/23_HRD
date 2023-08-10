package my.day06.exam03;

public abstract class Product {

	// 상품명과 가격 변수 
	String pname;
	int price;
	
	// 상품명과 가격을 출력하는 기본정보를 출력 메소드 
	public void printDetail() {
		System.out.println("상품명: " + pname + " , ");
		System.out.println("가격: " + price + " , ");
		printExtra();
	}
	
	public abstract void printExtra();
		
	
	
}
