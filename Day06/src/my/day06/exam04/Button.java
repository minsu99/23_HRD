package my.day06.exam04;

public class Button {
	// 중첩 메소드
	static interface ClickListenter{
		
		// 추상 메소드 
		void onClick();
	}
	
	// 필드선언
	ClickListenter clickListenter;
	
	// 필드 초기화 
	public void setClickListenter(ClickListenter clickListenter) {
		this.clickListenter = clickListenter;
	}
	
//	// 메소드 오버라이딩
//	public void onClick() {
//		
//	}
	
	void click() {
		this.clickListenter.onClick();
	}
}
