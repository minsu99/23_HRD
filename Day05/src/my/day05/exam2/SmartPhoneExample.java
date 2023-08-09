package my.day05.exam2;

public class SmartPhoneExample {

	public static void main(String[] args) {
		
		SmartPhone sp = new SmartPhone("아이폰12", "BLUE", "IOS16");
		
		System.out.println("모델: " + sp.model); 
		System.out.println("색상: " + sp.color); 
		System.out.println("버전: " + sp.ver); 
		System.out.println("-----------------");
		
		System.out.println("와이파이: " + sp.wifi);
		
		
		sp.bell();
		sp.sendVoice("여보세요");
		sp.receiveVoice("네 검찰입니다");
		sp.sendVoice("에?");
		sp.receiveVoice("검찰입니다");
		sp.hangUp();
		
		sp.setWifi(true);
		sp.internet();
		
		

	}

}
