package my.day13.ex05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class UserInsertExample {

	// 필드
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		// url, id, password
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pwd = "1234";
		String sql = "";
		// 생성자
		public UserInsertExample() {
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
		
		// 입력 메소드
		public List<User> insertAll() {
			
			sql = "INSERT INTO users * VALUES (?,?,?,now(),?,?)";
			List<User> list = new ArrayList<>();
			
			pst = con.prepareStatement(sql);
			pst.setString(1,"Spring");
			pst.setString(2,"봄");
			pst.setString(3,"1234");
			pst.setInt(4,25);
			pst.setString(5,"ggg.com");
			
			
		}
	
	
	
	public static void main(String[] args) {
		

	}

}
