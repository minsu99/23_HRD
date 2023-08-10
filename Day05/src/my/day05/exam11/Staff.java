package my.day05.exam11;

import java.util.Scanner;

public class Staff extends Person {
	private String dept;
	private String sId; 
	
	public Staff() {
	
	}
	
	
	
	
	public String getDept() {
		return dept;
	}




	public void setDept(String dept) {
		this.dept = dept;
	}




	public String getsId() {
		return sId;
	}




	public void setsId(String sId) {
		this.sId = sId;
	}
	
	// personInfo 메서드 오버라이딩
		@Override
		public String personInfo() {
			String info = super.personInfo(); // 이름 리턴 
			info += "\n사번: " +sId + "\n과목: " + dept;
			return info;
		}




		// inputInfo() 메소드 오버라이딩
		public void inputInfo() {
	        super.inputinfo();
			
			System.out.println("부서 명: ");
			Scanner scan = new Scanner(System.in);
			String sid = scan.next();
			setDept(sid);
			System.out.println("직원 아이디: ");
			String cn = scan.next();
			setsId(cn);
		}




		@Override
		public String getId() {
			// TODO Auto-generated method stub
			return sId;
		}




		@Override
		public void setId(String id) {
			this.sId = id;
			
		}
}
