package my.day11.ex1;

public class User2Thread extends Thread {
	private Calculator cal;

	public User2Thread() {
		setName("User2Thread: ");
	}

	public void setCalculator(Calculator cal) {
		this.cal = cal;
	}

	@Override
	public void run() {
		cal.setMemory2(50);
	}

}
