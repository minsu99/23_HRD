package my.day05.exam4;




public class SupersonicAirplaneExample {
	public static void main(String[] args) {

		SupersonicAirplane sa = new SupersonicAirplane();
		
		sa.takeOff();
		System.out.println("----------------");
		sa.fly();
		System.out.println("----------------");
		sa.flymode = SupersonicAirplane.SUPERSONICNOMAL;
		sa.fly();
		
		sa.flymode = SupersonicAirplane.NOMAL;
		System.out.println("----------------");
		sa.fly();
		System.out.println("----------------");
		sa.land();
	}

}
