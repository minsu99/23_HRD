package my.day06.exam02;

public class 칼 implements Mugi, 키친도구 {  // 두 개의 동작법 // 
	// 다중상속 , 다중 인터페이스 구현 

	@Override
	public void play() {
		System.out.println("칼이 동작");
		
	}

	@Override
	public void cook() {
		System.out.println("요리조리");
		
	}

}
