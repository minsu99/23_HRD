package my.day05.exam7;

public class Car {
	// 필드 선언 
	public Tire tire;
	
	// 메소드 선언 
	public void run() {
		tire.roll();
		// 차는 달리지만 실은 타이어가 돌아간다
		// 클래스 안에 타이어를 가지고 있어야 함 
	}
}
