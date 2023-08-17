package my.day12.ex01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONObject;

public class ChatClient {

    // 필드 
    Socket socket;
    DataOutputStream dos;
    DataInputStream dis;
    String chatName;
    
    // 서버연결 
    public void connect() throws IOException {
        socket = new Socket("localhost", 50001); // 서버와 주소, 포트 번호 
        dos = new DataOutputStream(socket.getOutputStream());
        dis = new DataInputStream(socket.getInputStream());
        System.out.println("클라이언트와의 접속 성공 ");
    }
    
    // 메소드: JSON받기
    public void receive() {
        Thread thread = new Thread(() -> {
            try {
                while (true) {
                    String json = dis.readUTF();

                    JSONObject root = new JSONObject(json);
                    String clientIp = root.getString("clientIp");
                    String chatName = root.getString("chatName");
                    String message = root.getString("message");
                    System.out.println("<" + chatName + "@" + clientIp + ">" + message);
                    // 작업 내용 추가
                }
            } catch (Exception e) {
                System.out.println("[클라이언트] 서버 연결 끊김");
                System.exit(0);
            }
        });

        thread.start();
    }
    
    // 메소드 : JSON 보내기 
    public void send(String json) throws IOException {
        
            dos.writeUTF(json);
            dos.flush();
        
        }
        
    // 메소드: 서버 연결 종료 (연결끊기)
    public void unconnect() throws IOException { // 메인에서 q가 눌리면 채팅이 종료하기 위해 호출 
    	socket.close();
    }
    
    

    public static void main(String[] args) {

        try {
            ChatClient chatClient = new ChatClient();
            chatClient.connect();

            Scanner scan = new Scanner(System.in);
            
            System.out.println("대화명 입력: ");
            chatClient.chatName = scan.nextLine();
            
            JSONObject jo = new JSONObject();
            jo.put("command", "incoming");
            jo.put("data", chatClient.chatName);
            
            String json = jo.toString();
            
            chatClient.send(json);
            
            System.out.println("------------------------------------");
            System.out.println("보낼 메세지를 입력하고 Enter");
            System.out.println("채팅을 종료하려면 q를 입력하고 Enter");
            System.out.println("------------------------------------");
            
            while(true) {
            	String message = scan.nextLine();
            	if(message.toLowerCase().equals("q")) {
            		break;
            	}else {
            		jo = new JSONObject();
            		jo.put("command", "message");
            		jo.put("data", message);
            		json = jo.toString();
            		chatClient.send(json);
            		
            	}
            }
            scan.close();
            chatClient.unconnect(); 
        } catch (IOException e) {
            System.out.println("[클라이언트] 서버 연결 안됨");
        }
    }
}

