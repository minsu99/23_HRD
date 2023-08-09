package my.day05.exam2;

public class SmartPhone extends Phone {
	
	public boolean wifi;
	
//	public SmartPhone() {
//		
//	}
	//   !!!!!!!!부모가 인자생성자를 가지고 있으면 부모에게 넘긴다 super로 전달 !!!!!!!!!!!!!
	public SmartPhone(String model, String color, String ver) {
		super(model,color,ver); // 부모가 인자생성자를 가지고 있으면 부모에게 넘긴다 super로 전달 
		// 반드시 작성해야한다.
//		this.model = model;
//		this.color = color;
//		this.ver = ver;
	}
	
	public void setWifi(boolean wifi) {
		super.bell(); // 부모의 메소드를 사용 
		this.wifi = wifi;
		System.out.println("와이파이 상태 변경");
	}
	public void internet() {
		System.out.println("인터넷 연결");
	}
}
