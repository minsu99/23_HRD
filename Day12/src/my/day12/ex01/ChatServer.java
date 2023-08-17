package my.day12.ex01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONObject;

public class ChatServer {

	ServerSocket serverSocket = null;
	// 100개 스레드로 요청을 처리하는 스레드풀 생성
	protected ExecutorService executorService = Executors.newFixedThreadPool(100);

	// *** <key, value> socketclient를 관리하는 채팅방
	Map<String, SocketClient> chatRoom = Collections.synchronizedMap(new HashMap<>());
	// 동기화된 해시맵

	protected static final int PORT = 50001;

	public static void main(String[] args) throws Exception {
		try {

			ChatServer chatServer = new ChatServer();

			// TCP 서버 시작
			chatServer.startServer();

			System.out.println("----------------------------------------------------------");
			System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter키를 입력하세요");
			System.out.println("----------------------------------------------------------");

			Scanner scan = new Scanner(System.in);

			while (true) {
				String key = scan.nextLine();
				if (key.toLowerCase().equals("q")) {
					break;
				}

			}

			scan.close();

			chatServer.stopServer();
		} catch (IOException e) {
			System.out.println("[서버] " + e.getMessage());
		}
	}

	public void startServer() throws Exception {
		// serversocket 생성 및 포트 바인딩
		serverSocket = new ServerSocket(PORT);
		System.out.println("서버 대기중 ");

		// 작업 스레드 정의
		Thread thread = new Thread(() -> {

			try {
				while (true) {
					System.out.println("\n[서버] 연결 요청을 기다립니다\n");
					// 연결 수락
					Socket socket = serverSocket.accept(); // 대기중-> 요청들어오면 수행
					SocketClient sc = new SocketClient(this, socket);
				}
			} catch (IOException e) {
				// System.out.println("[서버]" + e.getMessage());
			}

		});
		// 스레드 시작
		thread.start(); // 메소드 호출
	}

	
	
	// SocketClient MAP에 추가 , 삭제 메소드
	// 메소드 : 클라이언트 연결 시 SocketClient 생성 및 추가
	public void addSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.put(key, socketClient);
		System.out.println("입장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");

	}//---------------------------------------------------------------------------
	
	
	// 메소드: 클라이언트 연결 종료 시 SocketClient 제거
	public void removeSocketClient(SocketClient socketClient) {
		String key = socketClient.chatName + "@" + socketClient.clientIp;
		chatRoom.remove(key);
		System.out.println("퇴장: " + key);
		System.out.println("현재 채팅자 수: " + chatRoom.size() + "\n");
	}//---------------------------------------------------------------------------

	
	
	// 메소드: 모든 클라이언트에게 메세지 보냄 
	public void sendToAll(SocketClient sender, String message) {
		JSONObject root = new JSONObject();
		root.put("ClientIp", sender.clientIp);
		root.put("chatName", sender.chatName);
		root.put("message", message);
		String json = root.toString();

		Collection<SocketClient> socketClients = chatRoom.values(); // 값을 꺼내
		
		for(SocketClient sc : socketClients) {
			if(sc == sender) continue; // 나한테는 무시하고 다른 사람에게 보내라 
			sc.send(json);
		}
	}//---------------------------------------------------------------------------
	
	
	

	public void stopServer() {
		try {
			serverSocket.close();
			executorService.shutdownNow(); // 스레드 풀 종료
			
			// 채팅방 소켓클라이언트 연결 해제 ***
			chatRoom.values().stream().forEach(sc -> sc.close()); 
			
			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {

		}
	}
}
