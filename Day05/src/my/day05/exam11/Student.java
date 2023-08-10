package my.day05.exam11;

import java.util.Scanner;

public class Student extends Person {
	private String sID;
	private String className;
	
	public Student() {

	}
	
	
	public String getsID() {
		return sID;
	}


	public void setsID(String sID) {
		this.sID = sID;
	}


	public String getClassName() {
		return className;
	}


	public void setClassName(String className) {
		this.className = className;
	}


	// personInfo 메서드 오버라이딩
	@Override
	public String personInfo() {
		String info = super.personInfo(); // 이름 리턴 
		info += "\n학번: " + sID + "\n수강과목: " + className;
		return info;
	}
	
	// inputInfo() 메소드 오버라이딩
	public void inputInfo() {
        super.inputinfo();
		
		System.out.println("학번 입력: ");
		Scanner scan = new Scanner(System.in);
		String sid = scan.next();
		setsID(sid);
		System.out.println("수강과목 입력: ");
		String cn = scan.next();
		setClassName(cn);
	}


	@Override
	public String getId() {
		// TODO Auto-generated method stub
		return sID;
	}


	@Override
	public void setId(String id) {
		sID = id;
		
	}
	
	

	
}
