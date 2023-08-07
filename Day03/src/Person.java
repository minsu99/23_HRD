
public class Person {
	
	String name, tel; 
	int age;
	
	char sex; 
	
	//생성자 메소드 
	//객체를 생성 시 호출
	//1. 반드시 public 접근자
	//2. 반환타입 없다 !!!!!!
	//3. 클래스 이름과 동일하게 
	
	public Person() { // 기본 생성자 
		
	}
	
	// 인자생성자     ---   inputPerson에 
	public Person(String name, int age, char sex, String tel) {
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.tel = tel;
	}
	// 자기 자신 호출  this == 나 자신 
	public Person(String name, char sex, String tel) {
		this(name,20 ,sex,tel); 
		
		//age = 20;
	}
	
	//반환타입이 문자열이고 반환타입이 없는 메소드 
	public String showProfile() {
		String info="---"+name+" 프로필-----";
			info += "\n나이 : " + age;
			info += "\n성별 : " + sex;
			info += "\n전화 : " + tel;
		return info; // 문자열 반환
	}
	
	
	public void wantJob(String job, int pay) {
		System.out.println("---"+name+" 님 ----");
		System.out.println("희망직종: " + job);
		System.out.println("희망연봉: " + pay);
	}
	
	public Person(int age, String name) {
		this.age = age;
		this.name = name;
	}
	
	
	
	
	// 동작을 메소드로 만든다
	public void eat() {
		System.out.println("eat");
	}
	
	public void smile() {
		System.out.println("smile");
	}
	
	
	
	
}
