package my.day06.exam01;

public class Audio implements RemoteControl {
	
	private int volume;

	@Override
	public void turnOn() {
		System.out.println("AUDIO 전원 ON");
		
	}

	@Override
	public void turnOff() {
		System.out.println("AUDIO 전원 OFF");
		
	}

	@Override
	public void setVolume(int volume) {
		if(volume < RemoteControl.MIN_VOLUME) {
			this.volume = RemoteControl.MIN_VOLUME;
		}else if (volume > RemoteControl.MAX_VOLUME) {
			this.volume = RemoteControl.MAX_VOLUME;
			System.out.println("AUDIO VOLUME 기준점 " + "< "+ Math.abs((MAX_VOLUME - volume))+" >" + " 초과함");
		}else {
			this.volume = volume;
		}
		System.out.println("AUDIO volume: " + this.volume);
	}

}
