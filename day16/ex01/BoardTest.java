package my.day16.ex01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class BoardTest {
	// 필드
	static Connection con = null;
	PreparedStatement pst = null;

	String url = "jdbc:mysql://localhost:3306/mydb";
	String id = "root";
	String pwd = "1234";

	ResultSet rs = null;
	String sql = "";
	String loginOk = "";

	Scanner scan = new Scanner(System.in);

	// 생성자
	public BoardTest() {
		//connect();
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url, id, pwd);

			System.out.println("연결 성공 ");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	// DB 접속
	public void connect() {
		

	}


	// 게시물 전체 조회  ******************************************************************************
	public void list() {
		// connect();
		System.out.println();
		System.out.println("[게시물 목록]");
		System.out.println("---------------------------------------------------------------------");
		System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		System.out.println("---------------------------------------------------------------------");

		// ******* boards 테이블에서 게시물 정보를 가져와 출력 ************
		try {

			sql = "SELECT bno,btitle, bcontect,bwriter,bdate FROM boards ORDER BY bno DESC";

			pst = con.prepareStatement(sql);

			rs = pst.executeQuery();

			while (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBcontect(rs.getString("bcontect"));
				board.setBdate(rs.getDate("bdate"));
				board.setBtitle(rs.getString("btitle"));

				System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(),
						board.getBtitle());
			}
			rs.close();
			pst.close();

		} catch (Exception e) {
			e.getMessage();
			//exit();
		}

		mainMenu();
	}
	//**********************************************************************************************
	public void mainMenu() {
		System.out.println();
		System.out.println("---------------------------------------------------");
		System.out.println("메인메뉴: 1. Create | 2. Read | 3. Clear   | 4. Join ");
		System.out.println("          5. Login  | 6. Exit | 9. account | 10. RUN  ");
		System.out.println();
		System.out.println("메뉴 선택: ");
		String menuNo = scan.nextLine();
		System.out.println();

		switch (menuNo) {
		case "1" -> create();
		case "2" -> read();
		case "3" -> clear();
		case "4" -> join();
		case "5" -> login();
		case "6" -> exit();
		case "9" -> account();
		}
	}
	
	// 두 번째 메인 메뉴 *************************************************
	public void mainMenu2 () {
		 while (true) { // 무한루프로 메뉴를 계속 표시하도록 설정
			 User user = new User();
		        System.out.println("게시물 목록 " + loginOk);
		        System.out.println("---------------------------------------------------------------------");
		        System.out.printf("%-6s%-12s%-16s%-40s\n", "no", "writer", "date", "title");
		        System.out.println("---------------------------------------------------------------------");
		        try {

					sql = "SELECT bno,btitle, bcontect,bwriter,bdate FROM boards ORDER BY bno DESC";

					pst = con.prepareStatement(sql);

					rs = pst.executeQuery();

					while (rs.next()) {
						Board board = new Board();
						board.setBno(rs.getInt("bno"));
						board.setBwriter(rs.getString("bwriter"));
						board.setBcontect(rs.getString("bcontect"));
						board.setBdate(rs.getDate("bdate"));
						board.setBtitle(rs.getString("btitle"));

						System.out.printf("%-6s%-12s%-16s%-40s\n", board.getBno(), board.getBwriter(), board.getBdate(),
								board.getBtitle());
					}
					rs.close();
					pst.close();

				} catch (Exception e) {
					e.getMessage();
					//exit();
				}

				
		        System.out.println();
		        System.out.println("메인메뉴: 1. Create | 2. Read | 3. Clear | 4. Logout | 5. Exit  ");
		        System.out.println();
		        System.out.println("메뉴 선택: ");
		        String menuNo = scan.nextLine();
		        System.out.println();

		        switch (menuNo) {
		            case "1" -> create();
		            case "2" -> read();
		            case "3" -> clear();
		            case "4" -> logout();
		            case "5" -> exit();
		            
		        }
		    }
	}
	//******************************************************************************
	
	
	// account ****************************************************************************
	public void account() {
		Account acc = new Account();
		System.out.println("계좌번호: ");
		acc.setAno(scan.nextLine());
		System.out.println("소유자 이름: ");
		acc.setOwner(scan.nextLine());
		System.out.println("잔액: ");
		acc.setBalance(scan.nextInt());
		scan.nextLine();
		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		
	if (menuNo.equals("1")) {
			
			try { 
				sql = "INSERT INTO accounts (ano, owner, balance) VALUES (?, ?, ?)";

				pst = con.prepareStatement(sql);

				pst.setString(1, acc.getAno()); 
				pst.setString(2, acc.getOwner());
				pst.setInt(3, acc.getBalance());
				
				pst.executeUpdate(); // 쿼리 실행

				pst.close();
				System.out.println("추가되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				//exit();
			}
		}
		list(); // Display the updated list after adding the new post
	}
		
	

	// 4. join************************************************************************
	public void join() {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.println("아이디: ");
		user.setUserId(scan.nextLine());
		System.out.println("이름: "); 
		user.setUserName(scan.nextLine());
		System.out.println("비밀번호: "); 
		user.setUserPassword(scan.nextLine());
		System.out.println("나이: "); 
		user.setUserAge(scan.nextInt());
		scan.nextLine();
		System.out.println("이메일: ");
		user.setUserEmail(scan.nextLine());
		
		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		
		if (menuNo.equals("1")) {
			
			try { 
				sql = "INSERT INTO users (userid, username, userpassword, userage, useremail) VALUES (?, ?, ?, ?, ?)";

				pst = con.prepareStatement(sql);

				pst.setString(1, user.getUserId()); 
				pst.setString(2, user.getUserName());
				pst.setString(3, user.getUserPassword());
				pst.setInt(4, user.getUserAge());
				pst.setString(5, user.getUserEmail());

				pst.executeUpdate(); // 쿼리 실행

				pst.close();
				System.out.println("게시물이 추가되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				//exit();
			}
		}
		list(); // Display the updated list after adding the new post
	}
	
	
	
	// 5. login**************************************************************************
	public void login() {
	    User user = new User();
	    System.out.println("[로그인]");
	    System.out.println("아이디: ");
	    user.setUserId(scan.nextLine());
	    System.out.println("비밀번호: ");
	    user.setUserPassword(scan.nextLine());

	    System.out.println("----------------------------------------------------");
	    System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
	    System.out.print("메뉴 선택: ");
	    String menuNo = scan.nextLine();

	    if (menuNo.equals("1")) {
	        try {
	            sql = "SELECT userid, userpassword FROM users WHERE userid = ?";
	            pst = con.prepareStatement(sql);
	            pst.setString(1, user.getUserId());
	            rs = pst.executeQuery();

	            if (rs.next()) {
	                String up = rs.getString("userpassword");
	                if (up.equals(user.getUserPassword())) {
	                	loginOk = user.getUserId();
	                    System.out.println("로그인 성공");
	                    mainMenu2();
	                } else {
	                    System.out.println("비밀번호가 틀렸습니다.");
	                    login();
	                }
	            } else {
	                System.out.println("아이디가 틀렸습니다.");
	                login();
	            }

	            rs.close();
	            pst.close();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    
	}
	
	public void logout() {
		loginOk = null;
		System.out.println("로그아웃");
		list();
	}


		
	
	// 생성********************************************************************************************
	public void create() {
		System.out.println("---> create() 메소드를 실행");
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.println("제목: "); 
		board.setBtitle(scan.nextLine());
		System.out.println("내용: "); 
		board.setBcontect(scan.nextLine());
		System.out.println("작성자: "); 
		board.setBwriter(scan.nextLine());

		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();

		if (menuNo.equals("1")) {
			// 게시물 정보 저장
			try { 
				sql = "INSERT INTO boards (btitle, bcontect, bwriter, bdate) VALUES (?, ?, ?, now())";

				pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle()); 
				pst.setString(2, board.getBcontect());
				pst.setString(3, board.getBwriter());

				pst.executeUpdate(); // 쿼리 실행

				pst.close();
				System.out.println("게시물이 추가되었습니다.");
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				//exit();
			}
		}
		list(); // Display the updated list after adding the new post
	}

	// 읽기 ***************************************************************************************
	public void read() {
		System.out.println("---> read() 메소드를 실행");
		System.out.println("[게시물 정보 읽기]");
		System.out.println("bno: ");
		int bno = Integer.parseInt(scan.nextLine());

		// 해당 게시물을 가져와 출력
		try {
			sql = "SELECT bno, btitle, bcontect, bwriter, bdate FROM boards WHERE bno = ?";
			pst = con.prepareStatement(sql);
			pst.setInt(1, bno);
			rs = pst.executeQuery();
			
			if (rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontect(rs.getString("bcontect"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("##########################################");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontect());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				// 보조메뉴 
				System.out.println("---------------------");
				System.out.println("보조 메뉴: 1. Update | 2. Delete | 3. List");
				System.out.println("메뉴 선택: ");
				String menuNo = scan.nextLine();
				System.out.println();
				
				
				
				if (menuNo.equals("1")) {
						update(board);
				}else if (menuNo.equals("2")) {
						delete(board);
			}
			rs.close();
			pst.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
			//exit();
		}
		list();
		
    // read에서 내용 수정 Update**************************************************************************
	}
	public void update(Board board) {
		System.out.println("[수정 내용 입력]");
		System.out.println("제목: "); 
		board.setBtitle(scan.nextLine());
		System.out.println("내용: "); 
		board.setBcontect(scan.nextLine());
		System.out.println("작성자: "); 
		board.setBwriter(scan.nextLine());
		
		// 보조 메뉴 출력 
		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if (menuNo.equals("1")) {
			
			try { 
				sql = "UPDATE boards SET btitle= ?, bcontect = ?, bwriter = ? WHERE bno = ?";

				pst = con.prepareStatement(sql);

				pst.setString(1, board.getBtitle()); 
				pst.setString(2, board.getBcontect());
				pst.setString(3, board.getBwriter());
				pst.setInt(4, board.getBno());
				

				pst.executeUpdate(); // 쿼리 실행

				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				//exit();
			}
		}
		list();
		
	}
	// read에서 내용 삭제 *************************************************************************************
	public void delete(Board board) {
		try {
			sql = "DELETE FROM boards WHERE bno = ?";
			pst = con.prepareStatement(sql);
			
			pst.setInt(1, board.getBno());
			pst.executeUpdate();
			pst.close();
		}catch (Exception e) {
			e.printStackTrace();
			//exit();
		}
		list();
		
	}
    // 전체 삭제 **************************************************************************************************
	public void clear() {
		System.out.println("---> clear() 메소드를 실행");
		System.out.println("[게시물 전체 삭제]");
		System.out.println("----------------------------------------------------");
		System.out.println("보조 메뉴: 1. Ok | 2. Cancel");
		System.out.print("메뉴 선택: "); 
		String menuNo = scan.nextLine();
		
		
		
		if (menuNo.equals("1")) {
			// boards 테이블에 게시물 정보 삭제
			try { 
				sql = "TRUNCATE TABLE boards"; // DELETE FROM boards 
				pst = con.prepareStatement(sql);
				pst.executeUpdate(); 

				pst.close();
				
			} catch (Exception e) {
				e.printStackTrace();
				e.getMessage();
				//exit();
			}
		}
		list();

		
	}
		
	
    // 강제 종료 ******************************************************
	public void exit() {
		
		if(con != null) {
			try {
				con.close();
				
			}catch (SQLException e) {
				
			}
		}
		System.out.println("게시판 종료");
		System.exit(0); // 정상종료 = 0
	}

	
	public static void main(String[] args) {
		BoardTest boardTest = new BoardTest();
		boardTest.list();
		//boardTest2.create();

	}
}
