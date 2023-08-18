package my.day13.ex05;

public class User {

	// 필드
	private String userid;
	private String username;
	private String userpassword;
	private int userage;
	private String useremail;
	
	
	public User() {}
	
	// 생성자 
	public User(String userid, String username, String userpassword, int userage, String useremail) {
		
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.userage = userage;
		this.useremail = useremail;
	}
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpassword() {
		return userpassword;
	}
	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}
	public int getUserage() {
		return userage;
	}
	public void setUserage(int userage) {
		this.userage = userage;
	}
	public String getUseremail() {
		return useremail;
	}
	public void setUseremail(String useremail) {
		this.useremail = useremail;
	}
	
	
	

}
