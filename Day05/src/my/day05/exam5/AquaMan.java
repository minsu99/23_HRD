package my.day05.exam5;

public class AquaMan extends Human {
	int speed;
	
	@Override
	public String getInfo() {
		String str = super.getInfo();
		str += "\n속도: " + speed;
		return str;
	}
	
	// 메소드 오버로딩
	public String getInfo(int speed) {
		return super.getInfo() + "\n속도: " + speed;
	}
	
}
