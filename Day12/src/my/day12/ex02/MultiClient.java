package my.day12.ex02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MultiClient extends JFrame implements ActionListener, Runnable {

	// 필드
	JButton btn1, btn2;

	JTextArea jta; // 여러줄 입력 가능 객체

	JTextField jtf; // 한 줄 입력 가능 객체

	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;

	JPanel jp;

	// 생성자
	public MultiClient() {
		btn1 = new JButton("전송"); // 맴버변수 초기화
		btn2 = new JButton("취소");
		jta = new JTextArea(15, 30);
		jtf = new JTextField(25);
		jp = new JPanel();
		jp.setBackground(Color.BLUE);

		setLayout(new BorderLayout());

		jp.add(jtf);
		jp.add(btn1);
		add(jta, "Center");
		add(jp, "South");
		
		/////////////////////////////
		btn1.addActionListener(this);
        /////////////////////////////
		
		setTitle("멀티 채팅 프로그램_GUI버전");
		setSize(500, 500);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 닫히면서 프로그램 정상 종료시키자

		setVisible(true);
		
		//////////////////////////////////////////
		Thread thread = new Thread(this);
		thread.start();
		/////////////////////////////////////////
	}

	public static void main(String[] args) {
		new MultiClient();

	}

	@Override // 다형성
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		Object obj = e.getSource();
//		if(str.equals("전송")) {
//			String message = jtf.getText();
//			jta.append(message + "\n");
//			jtf.setText("");
//		}else if (str.equals("취소")) {
//			
//		}
		if (obj == btn1) {
		    // 내보내기
		    String result = jtf.getText().toString();
		    try {
		        dos.writeUTF(result);

		        jta.append("나: " + result + "\n"); // 새로운 내용을 추가

		        jtf.setText("");

		    } catch (Exception e1) {
		        e1.getMessage();
		    }
		}
	}

	@Override
	public void run() {
		try {
			socket = new Socket("localhost", 9999);
			System.out.println("서버 연결 성공");
			dis = new DataInputStream(socket.getInputStream());
			dos = new DataOutputStream(socket.getOutputStream());
			System.out.println("[클라이언트] 서버 연결 연결됨");
			
			while(true) {
				String msg = dis.readUTF().toString();
				jta.setText("상대방: " + msg + "\n" + jta.getText());
				System.out.println("message" + msg);
			}
		} catch (Exception e) {
			e.getMessage();
		}
	}

}
