package my.day05.exam10;

public class AnimalTest {
	// ********* 매개변수의 다형성 ***********
	static void AnimalSound(Animal animal) {
		animal.sound();
		
	}

	public static void main(String[] args) {
		
		Animal a = new Dog();
		a.name = "강아지"; 
		a.sound();
		

		Cat c = new Cat();
		c.name = "야옹이";
		c.sound();
		
		//*******************
		AnimalSound(a);
		AnimalSound(c);
		//*******************
	}

}
