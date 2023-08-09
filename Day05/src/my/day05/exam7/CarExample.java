package my.day05.exam7;

public class CarExample {

	public static void main(String[] args) {
		
		Car c = new Car();
		
		c.tire = new Tire();
		c.run(); 
		// car가 돌아가는게 아니라 tire가 돌아간다. 
		
		// 타이어를 상속받고 어느 타이어를 장착할지 
		
		c.tire = new KumhoTire();      // 장착
		c.run();
		
		c.tire = new HankookTire();    // 장착
		c.run(); 
		

	}

}
