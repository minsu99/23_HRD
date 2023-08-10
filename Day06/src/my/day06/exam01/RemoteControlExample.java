package my.day06.exam01;

public class RemoteControlExample {

	public static void main(String[] args) {
		/////////////////////////////
		RemoteControl rc = null;
		rc = new Televison();
		/////////////////////////////
		
		rc.turnOn();
		rc.setVolume(5);
		rc.turnOff();
		System.out.println("");
		rc.turnOn();
		rc.setVolume(15);
		rc.turnOff();
		System.out.println("");
		
		RemoteControl ad;
		ad = new Audio();
		
		ad.turnOn();
		ad.setVolume(5);
		ad.turnOff();
		System.out.println("");
		
		ad.turnOn();
		ad.setVolume(15);
		ad.turnOff();
		
		System.out.println("");
		rc.setMute(true);
		rc.setMute(false);
		rc.setVolume(10);
		rc.setMute(true);
		System.out.println("");
		
		// 정적메소드 호출 
		RemoteControl.ChangeBattery();
		
		
		
		
		

	}

}
