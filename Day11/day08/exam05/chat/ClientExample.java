package my.day08.exam05.chat;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientExample {

    // 소켓
    static Socket socket;

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 50001); // 서버와 주소, 포트 번호 
            System.out.println("클라이언트와의 접속 성공 ");
            socket.close();
            
            System.out.println("클라이언트와의 접속 해제 ");
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
