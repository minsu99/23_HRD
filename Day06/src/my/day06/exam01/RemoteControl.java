package my.day06.exam01;

public interface RemoteControl {  // 사용설명서 
	
	 

	// 구성요소 
	
	// "상수"필드
	//static final double PI = 3.14;
	
	static final int MAX_VOLUME = 10;
	static final int MIN_VOLUME = 0;
	
	// "추상"메소드  ->  중괄호 없는거!!! 
	void turnOn();
	void turnOff();
	void setVolume(int volume);
	
	// 무음모드 
	default void setMute(boolean mute) {
		if(mute) {
			System.out.println("무음 모드 : ON");
			setVolume(MIN_VOLUME);
		}else {
			System.out.println("무음 모드 : OFF ");
			//setVolume(MAX_VOLUME);
		}
	}
	
	// 정적메소드 static (정적) 
	// 구현객체 없이 호출가능 
	static void ChangeBattery() {
		System.out.println(" ChangeBattery ");
	}
	
	
	
}
