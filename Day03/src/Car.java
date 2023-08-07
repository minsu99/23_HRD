
public class Car {

	String color = "파랑";
	int speed = 10;

	//생성자
	public Car() { // 기 본 생성자
		// 기본 생성자 할일 1. 객체 생성시 호출
		// 2. 멤버변수의 초기화
		// 태어날때 가지고 나오는거 
		speed = 10;
		color = "파랑";

	}
	
	// 생성자 중복정의
	// 이름이 같고, 매개변수의 개수, 종류가 다르다
	            // 매개변수      // 매개변수 
	public Car(int speed, String color) {
		this.speed = speed;
		this.color = color;
	}
	
	
	
	
	public void run(int s) {  //s에 50이 누적 그래서 60
		speed += s;
		System.out.println(this.speed + "km로 달린다");
	}

	public void stop(int speed) {
		this.speed = speed;
		speed -= speed;
		if (speed == 0)
			speed = 10;
		System.out.println(speed + "km로 멈춘다");
	}
}
