package my.day05;

public class Human {
	private String name;  
	private String addr;

	private int age;
	
	public Human() {
		
	}
	// 기본
	public Human(String name, String addr, int age) {
	
		this.name = name;
		this.addr = addr;
		this.age = age;
	}
	// 인자 
	public Human(String name, int age) { 
		this(name, "대전 동구 용운동", age);  
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Human [name=" + name + ", addr=" + addr + ", age=" + age + "]";
	}
}
