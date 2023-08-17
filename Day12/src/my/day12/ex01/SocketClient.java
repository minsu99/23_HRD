package my.day12.ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

import org.json.JSONObject;

public class SocketClient {

    // 필드 선언
    ChatServer chatServer; // 수정: chatserver -> chatServer
    Socket socket;
    DataInputStream dis;
    DataOutputStream dos;

    String clientIp;
    String chatName;

    // 생성자
    public SocketClient(ChatServer chatServer, Socket socket) {
        try {
            this.chatServer = chatServer; // 수정: chatserver -> chatServer
            this.socket = socket;
            this.dis = new DataInputStream(socket.getInputStream());
            this.dos = new DataOutputStream(socket.getOutputStream());
            InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
            this.clientIp = isa.getHostName();
            receive(); // 수정: recevie -> receive

        } catch (Exception e) {
            // 오류 처리 코드 추가 필요
        }

    } // 생성자

    // 클라이언트가 보낸 JSON 메세지 읽기 메소드
    public void receive() {
        chatServer.executorService.execute(() -> {
            try {
                while (true) {
                    String receiveJson = dis.readUTF();

                    JSONObject jsonObject = new JSONObject(receiveJson);
                    String command = jsonObject.getString("command");
                    // {"command" : "incoming", "data": "message"}

                    switch (command) {
                        case "incoming":
                            this.chatName = jsonObject.getString("data");
                            chatServer.sendToAll(this, "들어오셨습니다");//전송하는 메소드  
                            chatServer.addSocketClient(this);	        // 관리하는 
                            // (this) - >  소켓 클라이언트 
                            break;

                        case "message":
                            String message = jsonObject.getString("data");
                            chatServer.sendToAll(this, message);
                            break;
                    }
                }
            } catch (Exception e) {
                chatServer.sendToAll(this, "나가셨습니다");
                chatServer.removeSocketClient(this);
            }

        });

    }

    public void send(String json) {
        try {
            dos.writeUTF(json);
            dos.flush();
        } catch (IOException e) {
            // 오류 처리 코드 추가 필요
        }
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception e) {
            // 오류 처리 코드 추가 필요
        }
    }

    public static void main(String[] args) {
        // 메인 메소드 내용 추가 필요
    }
}
