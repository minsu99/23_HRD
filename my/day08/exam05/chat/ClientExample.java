package my.day08.exam05.chat;

import java.net.Socket;

public class ClientExample {
	
	// 소켓 
	static Socket socket;

	public static void main(String[] args) {
	
		
		try {
			socket = new Socket("10.10.108.171", 50001); // 서버와 주소, 포트 번호 
			System.out.println(" 클라이언트와의 접속 성공 ");
			socket.close();
			
			System.out.println(" 클라이언트와의 접속 해제 ");
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
