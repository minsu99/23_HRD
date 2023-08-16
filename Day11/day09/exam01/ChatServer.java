package my.day09.exam01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {

	private static ServerSocket server = null;
	protected static ExecutorService executorService = Executors.newFixedThreadPool(10);

	static final int PORT = 50001;

	public static void main(String[] args) {
		System.out.println("----------------------------------------------------------");
		System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter키를 입력하세요");
		System.out.println("----------------------------------------------------------");

		startServer();

		Scanner scan = new Scanner(System.in);
		while (true) {
			String key = scan.nextLine();
			if (key.toLowerCase().equals("q")) {
				break;
			}

		}

		scan.close();

		stopServer();
	}

	public static void startServer() {
		Thread thread = new Thread() {
			@Override
			public void run() { // 직접 호출 X
				try {
					server = new ServerSocket(PORT);
					System.out.println("서버 대기중 ");

					while (true) {
						System.out.println("\n[서버] 연결 요청을 기다립니다\n");
						// 연결 수락
						Socket socket = server.accept(); // 기다린다-> 요청들어오면 수행

						/////////////////////////////////////////////////////////////////////////////////////////////
						executorService.execute(() -> {
							try {
								// 연결된 클라이언트 정보 얻기
								InetSocketAddress isa = // 주소를 알려줘라
										(InetSocketAddress) socket.getRemoteSocketAddress();
								System.out.println("[서버]" + isa.getHostName() + "의 연결 요청을 수락함");

								// 데이터 받기 ***************************************************************
								DataInputStream dis = new DataInputStream(socket.getInputStream());

								String message;
								int data1;
								double data2;
								try {
									message = dis.readUTF();
									data1 = dis.readInt();
									data2 = dis.readDouble();
								} catch (IOException e) {

									return;
								}

								// 데이터 보내기

								DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

								dos.writeUTF(message); // 받은거 그래도 보내줘
								dos.writeInt(data1);
								dos.writeDouble(data2);
								dos.flush();
								System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
								System.out.println("[서버] 받은 데이터를 다시 보냄: " + data1);
								System.out.println("[서버] 받은 데이터를 다시 보냄: " + data2);

								// 연결 끊어 (서버 부하 줄이기)
								socket.close();
								System.out.println("[서버]" + isa.getHostName() + "의 연결을 끊음");
							} catch (IOException e) {

							}
						});
					}
				} catch (IOException e) {
					System.out.println("[서버]" + e.getMessage());
				}
			}
		};
		// 스레드 시작
		thread.start(); // 메소드 호출
	}

	public static void stopServer() {
		try {
			server.close();
			executorService.shutdownNow(); // 스레드 풀 종료

			System.out.println("[서버] 종료됨");
		} catch (IOException e1) {

		}
	}
}
