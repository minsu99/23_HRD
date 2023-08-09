package my.day05.exam11;

import java.util.Scanner;

public abstract class Person {
	
	private String name;
	
	private String id;
	
	//추상 메소드 정의 
	public abstract String getId();
	public abstract void setId(String id);
	
	// 기본 생성자 
	public Person() {
		
	}
	// 인자 
	public Person(String name, String id) {
		this.name = name;
		this.id = id;
	}
	// 사람 정보 입력
	public void inputinfo() {
		System.out.println("이름을 입력");
		Scanner scan = new Scanner(System.in);	
		String nm = scan.next();
		name = nm;
	}
	// 사람 정보 문자열로 반환 
	public String personInfo() {
		String info = "이름: " + name;
		return info;
	}
	// 사람 정보 콘솔에 출력 
	public void printAll() {
		System.out.println(this.personInfo());
	}
	
	public String toString() {
		return name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
