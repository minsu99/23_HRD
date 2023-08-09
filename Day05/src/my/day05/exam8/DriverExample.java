package my.day05.exam8;

public class DriverExample {

	public static void main(String[] args) {
		
		Driver d = new Driver();
		
		// 매개값으로 bus 객체를 제공하고, driver() 메소드 호출 
		Bus b = new Bus();
		d.drive(b);
		
		// 매개값으로 taxi 객체를 제공하고, driver() 메소드 호출 
		Taxi t = new Taxi();
		d.drive(t);
		
		
		
	}

}
