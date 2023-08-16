package my.thread;

import my.day11.ex1.Calculator;
import my.day11.ex1.User1Thread;
import my.day11.ex1.User2Thread;

public class SynchronizedExample {

	public static void main(String[] args) {

		Calculator cal = new Calculator();

		User1Thread ut1 = new User1Thread();
		ut1.setCalculator(cal);
		ut1.start();

		User2Thread ut2 = new User2Thread();
		ut2.setCalculator(cal);
		ut2.start();

	}

}
