package my.day09.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ChatClient {

    // 소켓
    static Socket socket;

    public static void main(String[] args) {

        try {
            socket = new Socket("localhost", 50001); // 서버와 주소, 포트 번호 
            System.out.println("클라이언트와의 접속 성공 ");
            
            // 데이터 보내기 
            String smessage = "자바가 재밌어..";
            int data1 = 20;
            double data2 = 15.25;
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            
            dos.writeUTF(smessage); //받은거 그래도 보내줘 
            dos.writeInt(data1);
            dos.writeDouble(data2);
             
            dos.flush();
            System.out.println("[클라이언트] 데이터 보냄: " + smessage + ", " + data1 + ", " + data2);
            
            // 데이터 받기 
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            String rem = dis.readUTF(); 
            int remd2 = dis.readInt();
            double remd1 = dis.readDouble();
            System.out.println("[클라이언트] 데이터 받음: " + rem); 
            System.out.println("[클라이언트] 데이터 받음: " + remd1); 
            System.out.println("[클라이언트] 데이터 받음: " + remd2); 
            //socket.close();
            
            
            System.out.println("클라이언트와의 접속 해제 ");
            
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
