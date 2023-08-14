package my.list;

import java.util.List;
import java.util.Vector;

class Board {
	private String subject;
	private String content;
	private String writer;

	// 인자 생성자
	public Board(String subject, String content, String writer) {
		this.subject = subject;
		this.content = content;
		this.writer = writer;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
}

public class ArrayListExample {
	public static void main(String[] args) {

		// 제너릭 타입
		List<Board> list = new Vector();// vector의 add()는 동기화 메소드이므로 
										// 한번에 하나의 스레드만 실행할 수 있어 경합발생 X
		
		// 작업 스레드 객체 생성
		Thread thradA = new Thread() {
			public void run() {
				for(int i=1; i<=1000; i++) {
					list.add(new Board("제목" + i , "내용" + i ,"글쓴이" + i));
				}

			}
		};
		
		// 작업 스레드 객체 생성
		Thread thradB = new Thread() {
			public void run() {
				for(int i=1001; i<=2000; i++) {
					list.add(new Board("제목" + i , "내용" + i ,"글쓴이" + i));
				}
				
			}
		};
		// 작업 스레드 실행
		thradA.start();
		thradB.start();
		
		// 작업 스레드들이 모두 종료될 때까지 메인 스레드 기다리게 함 
		try {
			thradA.join();
			thradB.join();
		}catch (Exception e) {
			
		}
		
		

//		// 객체 생성
////		Board board1 = new Board("제목 1", "내용 1", "작성자 1");
////		list.add(board1);
//		list.add(new Board("제목 1", "내용 1", "작성자 1"));
//
////		Board board2 = new Board("제목 2", "내용 2", "작성자 2");
////		list.add(board2);
//		list.add(new Board("제목 2", "내용 2", "작성자 2"));
//
////		Board board3 = new Board("제목 3", "내용 3", "작성자 3");
////		list.add(board3);
//		list.add(new Board("제목 3", "내용 3", "작성자 3"));
//
////		Board board4 = new Board("제목 4", "내용 4", "작성자 4");
////		list.add(board4);
//		list.add(new Board("제목 4", "내용 4", "작성자 4"));
//
////		Board board5 = new Board("제목 5", "내용 5", "작성자 5");
////		list.add(board5);
//		list.add(new Board("제목 5", "내용 5", "작성자 5"));

//        // 리스트에 저장된 게시물 수 얻어오기
		int n = list.size();
		System.out.println("총 객체수: " + n);

		// 특정 인덱스의 객체 가져오기
		 Board board = list.get(0);
		//System.out.println(board.getSubject() + "\t" + board.getContent() + "\t" + board.getWriter());

		// 모든 객체를 하나씩 가져오기
//		for (int i = 0; i < list.size(); i++) {
//			Board b = list.get(i); // 특정한 인덱스면 따로 
//			System.out.println(b.getSubject() + "\t" + b.getContent() + "\t" + b.getWriter());
//
//		}
		System.out.println();
		// 객체 삭제
//		list.remove(2);
//		list.remove(2); // 3번에 있던데 2번으로 들어온다
		
		// 반복문 for-each 문 
//		for (Board B : list) {
//			System.out.println(B.getSubject() + "\t" + B.getContent() + "\t" + B.getWriter());
//		}
	}
}
