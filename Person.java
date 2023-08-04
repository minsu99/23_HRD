
public class Person {
	
	
	String name;  // = new String();          or           = "";
	int age;
	
	public void eat(String sr) {
		System.out.println(sr+"을 먹어");
		
	}
	public void showInfo() {
		System.out.println("이름 " + name);
		System.out.println("나이 " + age);
	}
	
	
	
	public static void main(String[] args) {
		
		Person per = new Person(); // new 로 할당을 받아야 함 아니면 "널 포인터 인셉션" 발생 
		per.age = 20;
		per.name = "홍길동";
		per.showInfo();
		per.eat(null);
		
		Person per2 = new Person();
		per2.age = 19;
		per2.name ="qkrwldnjs";
		per2.showInfo();
		per2.eat(null);
		
		
	}

}
