package my.day05.exam5;

public class Superman extends Human{
	
	int power;
	
	@Override
	public String getInfo() {
		String str = super.getInfo(); // 부모꺼 그대로 사용하면서 조금 추가 
		// 오버라이딩하면 자식꺼 먼저 
		str += "\n능력: " + power; 
		return str;
		
	}

}
