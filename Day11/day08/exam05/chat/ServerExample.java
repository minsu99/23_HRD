package my.day08.exam05.chat;

import java.io.IOException; // 입출력 
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
    
    // 서버 
    private static ServerSocket server = null;
    
    // 포트 번호
    static final int PORT = 50001;

    public static void main(String[] args) {
        
        System.out.println("----------------------------------------------------------");
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter키를 입력하세요");
        System.out.println("----------------------------------------------------------");

        // TCP 서버 시작
        startServer(); 

        // 키보드 입력
        Scanner scan = new Scanner(System.in);
        while (true) {
            String key = scan.nextLine();
            if (key.toLowerCase().equals("q")) {
                break;
            }
        }

        scan.close();

        // TCP 서버 종료
        stopServer();
    }
    
    public static void startServer() {
        // 작업 스레드 정의 (*** 하나의 프로그램에서 또 다른 하나의 프로그램 ***)
        Thread thread = new Thread() { 
            @Override
            public void run() {  // 직접 호출 X 
                try {
                	// Server 생성 및 포트 바인딩
                    server = new ServerSocket(PORT);
                    System.out.println("서버 대기중 ");
                   

                    while(true) {
                        System.out.println("\n[서버] 연결 요청을 기다립니다\n");
                        Socket socket = server.accept(); // 기다린다-> 요청들어오면 수행 
                        // 연결 수락
                        
                        // 연결된 클라이언트 정보 얻기 
                        InetSocketAddress isa =              // 주소를 알려줘라 
                                (InetSocketAddress) socket.getRemoteSocketAddress();
                        System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함");
                        
                        // 연결 끊어 (서버 부하 줄이기 )
                        socket.close();
                        System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
                    }
                } catch (IOException e) { // 예외발생 메세지 
                    System.out.println("[서버]" + e.getMessage());
                }
            }
        };
        // 스레드 시작 
        thread.start(); // 메소드 호출 
    }
    
    public static void stopServer() {
        try {
        	// server을 닫고 포트 언바인딩 
            server.close();
            System.out.println("[서버] 종료됨");
        } catch (IOException e1) {
            //e1.printStackTrace();
        }
    }
}
