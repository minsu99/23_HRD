package my.day05.exam11;

import java.util.Scanner;

public class Teacher extends Person {

	private String tId;
	private String subject;
	
	// 생성자
	public Teacher() {

	}
	
	@Override
	public String getId() {
		return tId;
	}

	@Override
	public void setId(String id) {
		this.tId = id;
	}
	
	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	// toString 메서드 재정의
	@Override
	public String personInfo() {
		String info = super.personInfo() + "\n교번 : " + tId + "\n과목 : " + subject;
		return info;
		 
	}
	
	// inputInfo() 메소드 오버라이딩
	public void inputInfo() {
		super.inputinfo();
		
		System.out.print("강사 아이디: ");
		Scanner scan = new Scanner(System.in);
		String sid = scan.next();
		setId(sid);
		
		System.out.print("강의 과목 : ");
		String cn = scan.next();
		setSubject(cn);
	}

}
