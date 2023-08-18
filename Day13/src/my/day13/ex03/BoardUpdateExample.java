package my.day13.ex03;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class BoardUpdateExample {

	
	
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
			
			
			
			// 2. boards 테이에 bno = 3인 게시물 정보 수정하기 
			String sql2 = "UPDATE boards SET btitle = ? ,bcontect = ?,   bfilename = ? , bfiledate = ?  WHERE bno = ?"; 
			
			// 2.2 삭제하기 
			String sql3 = "DELETE boards WHERE btitle = ?";
				
			
			// 3. 전송객체 
			pst = con.prepareStatement(sql2);
			pst.setString(1,"눈사람");
			pst.setString(2,"눈으로 만든 사람");
			pst.setString(3,"b.txt");
			pst.setBlob(4,new FileInputStream("b.txt"));
			pst.setInt(5,3); // 파일 저장 경로 

			
			
			// 4. 데이터 전송 
			int n = pst.executeUpdate();
			
			if (n == 1) { // 정상적인면 1이다!
				System.out.println("成功");
				
				
				
				
				
				
				
			}else {
				System.out.println("해당 번호는 존재하지 않습니다: 수정 실패");
			}
			
			
		}catch (Exception e) {
			System.out.println("연결실패");
			e.getMessage();
		}finally {
			if (con != null || pst != null) {
				
					con.close();
					pst.close();
					System.out.println("연결끊기");
				} 
				
			}
		}
		
		
		

	}


