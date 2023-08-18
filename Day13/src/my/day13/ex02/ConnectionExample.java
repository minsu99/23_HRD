package my.day13.ex02;


import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class ConnectionExample {

	
	
	public static void main(String[] args)  throws SQLException {
		
		// 1. DB연결
		Connection con = null;
		PreparedStatement pst = null;
		String url = "jdbc:mysql://localhost:3306/mydb";
		String id = "root";
		String pwd = "1234";
		
		try {
			// 드라이버 로딩
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);
			System.out.println("연결성공");
			
			// 2. users 테이블의 사용자 정보 데이터 저장 
//			String sql = "INSERT INTO boards (userid, username, userpassword, userage, useremail)" 
//					+ "VALUES (?,?,?,?,?)";
			
			// 2.2 boards 테이에 새로운 게시물 정보 저장하기 
			String sql2 = "INSERT INTO boards (btitle, bcontect, bwriter, bdate, bfilename, bfiledate)" 
					+ "VALUES (?,?,?,now(),?,?)";
			
			// 2.3 accounts 테이에 새로운 게시물 정보 저장하기 
//			String sql3 = "INSERT INTO accounts (owner, balance)" 
//					+ "VALUES (?,?)";
			
			// 3. 전송객체
//			pst = con.prepareStatement(sql);
//			pst.setString(1,"Spring");
//			pst.setString(2,"봄");
//			pst.setString(3,"1234");
//			pst.setInt(4,25);
//			pst.setString(5,"ggg.com");
			
			pst = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
			pst.setString(1,"눈 오는 날");
			pst.setString(2,"함박눈이 내려요");
			pst.setString(3,"winter");
			pst.setString(4,"a.txt");
			pst.setBlob(5,new FileInputStream("a.txt")); // 파일 저장 경로 
//			
			
			
//			pst = con.prepareStatement(sql3);
//			pst.setString(1,"");
//			pst.setString(2,"함박눈이 내려요");
			
			
			// 4. 데이터 전송 
			int n = pst.executeUpdate();
			
			if (n == 1) {
				System.out.println("성공");
				
				ResultSet rs = pst.getGeneratedKeys();
				
				if(rs.next()) {
					
				int no = rs.getInt(1); // 꺼내고 싶은 필드의 이름을 적어도 가능?
				System.out.println("저장된 bno: " + no);
				
				}
				rs.close();
			
			}else {
				System.out.println("실패");
			}
			
			
		}catch (Exception e) {
			System.out.println("연결실패");
			e.getMessage();
		}finally {
			if (con != null/* || pst != null*/) {
				
					con.close();
					//pst.close();
					System.out.println("연결끊기");
				} 
				
			}
		}
		
		
		

	}


