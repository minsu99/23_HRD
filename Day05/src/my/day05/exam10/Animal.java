package my.day05.exam10;

public abstract class Animal { 
	// 추상 클래스 : 객체를 생성하지 못한다
	// new 사용 X 
	// 적어도 한 개의 "추상 메소드"를 포함해야한다
	
	String name;
	
	abstract void sound(); // 필수  
	
	public String getName() {
		return name;
	}
}
