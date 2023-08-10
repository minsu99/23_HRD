package my.day06.exam01;

public class Televison implements RemoteControl {
	
	// 무조건 인터페이스 강제적으로
	
	private int volume;  

	@Override
	public void turnOn() {
		System.out.println("TV 전원 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("TV 전원 OFF");
		
	}

	@Override
	public void setVolume(int volume) {
		if (volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else if(volume >  RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
			System.out.println("TV VOLUME 기준점 " + "< "+ Math.abs((MAX_VOLUME - volume))+" >" + " 초과함");
		}else {
			this.volume = volume;
		}
		System.out.println("TV volume: " + this.volume);
	
		
	}
	
}
