package my.day05.exam3;

public class Computer extends Calculator {

	@Override // 재정의 
	public double areaCircle(double r) {
		System.out.println("Computer 객체의 areaCircle() 실행");
		return Math.PI * r * r;  // 오버라이딩 수정 
	}

	
}
