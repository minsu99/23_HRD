package my.day06.exam03;

public class SmartTV extends Product{

	String resolution;
	
	public SmartTV(String pname, int price, String resolution) {
		this.pname = pname;
		this.price = price;
		this.resolution = resolution;
	}
	@Override
	public void printExtra() {
		System.out.println("해상도: " + resolution);
		
	}

	

}
