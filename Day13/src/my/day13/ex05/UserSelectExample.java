package my.day13.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserSelectExample {

	// 필드
	static Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	// url, id, password
	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";
	String sql = "";
	// 생성자
	public UserSelectExample() {
		// 드라이버 로딩
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결 성공");
		} catch (Exception e) {
			e.getMessage();
			System.out.println("연결 실패");
		}
	}
	
	// 조회 메소드
	public List<User> selectAll() {  // 자료형 일치시켜라 
		
		sql = "SELECT * FROM users;";
		List<User> list = new ArrayList<>();
		
		try {
		pst = con.prepareStatement(sql);
		
		rs = pst.executeQuery();
		
		User user1;
		while(rs.next()) {
			String id = rs.getString(1);
			String name = rs.getString(2);
			String password = rs.getString(3);
			int age = rs.getInt(4);
			String email = rs.getString(5);
			
			user1 = new User(id,name,password,age, email);
			list.add(user1);
		}
		
		
		}catch (SQLException e) {
			e.getMessage();
		}
		
		
		return list;
	}
	
	// 저장 메소드
	public int userInsert(User user) {
		int n = 0;
		
		sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES (?,?,?,?,?);"; 
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, user.getUserid());
			pst.setString(2, user.getUsername());
			pst.setString(3, user.getUserpassword());
			pst.setInt(4, user.getUserage());
			pst.setString(5, user.getUseremail());
			
			n = pst.executeUpdate();
			System.out.println("저장 성공");
		}catch (SQLException e) {
			e.getMessage();
		}
		return n;
	}
	
	// 삭제
	public int userDelete(User user1) {
		int n = 0;
		
		sql = "DELETE FROM users WHERE userid = ?"; 
		try {
			
			pst = con.prepareStatement(sql);
			
			pst.setString(1, "winter");
			
			n = pst.executeUpdate();
			System.out.println("저장 성공");
		}catch (SQLException e) {
			e.getMessage();
		}
		return n;
	}
	
	// 수정
	
	public static void main(String[] args) {
		
		UserSelectExample use = new UserSelectExample();
		
		List<User> list = use.selectAll();
		
		for (User u : list) {
			System.out.println(u.getUserid());
			System.out.println(u.getUsername());
			System.out.println(u.getUserpassword());
			System.out.println(u.getUserage());
			System.out.println(u.getUseremail());
		}
		
		// 저장 
		User user = new User("summer", "여름", "1234", 25, "fdk.com");
		int result = use.userInsert(user);
		
		if (result == 1) {
			System.out.println("저장 성공");
		}else {
			System.out.println("실패");
		}
		
		
	}

}
