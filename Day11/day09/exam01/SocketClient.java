package my.day09.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

	// 필드 선언
	ChatServer chatserver;
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	String clientIp;
	String chatName;

	// 생성자
	public SocketClient(ChatServer ch, Socket socket) {
		try {
			this.chatserver = chatserver;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			InetSocketAddress isa = // 주소를 알려줘라
					(InetSocketAddress) socket.getRemoteSocketAddress();
			this.clientIp = isa.getHostName();
			recevie();

		} catch (Exception e) {
		}

	}// 생성자

	// 클라이언트가 보낸 jSON 메세지 읽기 메소드
	public void recevie() {
		chatserver.executorService.execute(() -> { // 접근관계 확인해라 protect로 전환함.
			try {
				while (true) {
					String receiveJson = dis.readUTF();

					JSONObject jsonobject = new JSONObject(receiveJson);
					String command = jsonobject.getString("command");

					switch (command) {
					case "incoming":
						this.chatName = jsonobject.getString("data");
						// chatServer.sendToAll(this, "들어오셨습니다");
						// chatServer.addSocketClient(this);
						break;
					case "message":
						String message = jsonobject.getString("data");
						// chatServer.sendToAll(this, message);
						break;
					}
				}
			} catch (Exception e) {
				// chatServer.sendToAll(this, "나가셨습니다");
				// chatServer.removeSocketClient(this);
			}

		});

	}
	
	public void send(String json) {
		
	}

	public static void main(String[] args) {

	}

}
