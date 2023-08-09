package my.day05.exam4;

public class SupersonicAirplane extends Airplane {
	public static final int NOMAL = 1;
	public static final int SUPERSONICNOMAL = 2;
	
	public int flymode = NOMAL;
	
	@Override
	public void fly() {
		if (flymode == SUPERSONICNOMAL) {
			System.out.println("초음속 모드");
		}else {
		super.fly();
		}
	}
	
}
