
public class AiCarTest {

	public static void main(String[] args) {
		
		Person kang = new Person(); // Person 생성자 호출 
		Car srt = new Car(); // Car생성자 호출 
		Car sedan = new Car(1000, "BLACK");
		
		kang.age = 25;
		kang.name = "강민수";
		
//		srt.run(50);
//		sedan.run(5000);
		
		
		System.out.println(sedan.speed);
		System.out.println(srt.speed);
		System.out.println(" ");
		System.out.println(srt.color);
		System.out.println(sedan.color);
		System.out.println(" ");
		System.out.println(kang.age);
		System.out.println(kang.name);
		System.out.println(" ");
		
		
		
		kang.eat();
		kang.smile();
		

	}

}
