package my.day05.exam2;

public class Phone {
	public String model;
	public String color;
	public String ver;
	
	//public Phone() {}

	public Phone(String model, String color,String ver) {
		
		this.model = model;
		this.color = color;
		this.ver = ver;
	}
	
	public void bell() {
		System.out.println("벨");
	}
	
	public void sendVoice(String message) {
		System.out.println("나: "+  message);
	}
	public void receiveVoice(String message) {
		System.out.println("상대방: "+  message);
	}
	
	public void hangUp() {
		System.out.println("전화를 끊는다");
	}
	
	
	
	
	
}
