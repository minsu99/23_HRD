package my.day08.exam01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class Reservation {
	private long id; // 발급번호
	private long movieId; // 영화 대푯값
	private String movieTitle; // 영화 제목
	private String seatName; // 좌석명
	private static final File file = new File("reservations.txt"); // 파일 객체

	public Reservation(long id, long movieId, String movieTitle, String seatName) {
		this.id = id;
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.seatName = seatName;
	}

	public static Reservation findById(String reservationId) throws IOException {
		Reservation r = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { // 행 단위 문자열 읽기, 동작 반복
			String[] temp = line.split(","); // 문자열을 쉼표로 나눔
			if (reservationId.equals(temp[0])) { // 발급번호를 찾으면
				r = new Reservation( // 객체 생성
						Long.parseLong(temp[0]), // 발급번호
						Long.parseLong(temp[1]), // 영화 대푯값
						temp[2], // 영화 제목
						temp[3] // 좌석명
				);
				break; // 반복 탈출
			}
		}
		br.close(); // 입력 흐름 해제
		return r;
	}

	public String toString() {
		return String.format("영화: %s, 좌석: %s", movieTitle, seatName);
	}

	public static Reservation cancel(String reservationId) throws IOException {
		Reservation canceled = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String text = "";
		String line = null;

		while ((line = br.readLine()) != null) { // 행 단위 문자열 읽기, 동작 반복
			String[] temp = line.split(","); // 문자열을 쉼표로 나눔
			if (reservationId.equals(temp[0])) { // 발급번호를 찾으면
				canceled = new Reservation( // 객체 생성
						Long.parseLong(temp[0]), // 발급번호
						Long.parseLong(temp[1]), // 영화 대푯값
						temp[2], // 영화 제목
						temp[3] // 좌석명
				);
				continue; // 다음 반복으로 넘어감(복사되지 않게)
			}
			text += line + "\n"; // 읽은 문자열을 누적하여 복사
		}
		br.close(); // 입력 흐름 해제

		FileWriter fw = new FileWriter(file); // FileWriter 객체 생성(덮어쓰기 모드)
		fw.write(text); // 파일 출력
		fw.close(); // 출력 흐름 해제
		return canceled; // 삭제된 예매를 객체로 반환
	}
                               // 제너릭형 // 구체화 하지 않고 일반화하겠다.
	public static ArrayList<Reservation> findByMovieId(String movieIdStr) throws IOException {
		ArrayList<Reservation> reservations = new ArrayList<Reservation>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { // 행 단위로 문자열을 읽음, 동작 반복
			String[] temp = line.split(","); // 문자열을 쉼표 기준으로 나눔
			if (movieIdStr.equals(temp[1])) { // 영화 대푯값을 찾았다면
				long id = Long.parseLong(temp[0]); // 예매 발급번호
				long movieId = Long.parseLong(temp[1]); // 예매 영화의 대푯값
				String movieTitle = temp[2]; // 예매 영화의 제목
				String seatName = temp[3]; // 예매 영화의 좌석명
				Reservation r = new Reservation(id, movieId, movieTitle, seatName);
				reservations.add(r); // 생성 객체를 ArrayList에 추가
			}
		}
		br.close(); // 입력 흐름 해제
		return reservations; // 예매 객체를 담은 ArrayList 반환
	}

	public Reservation(long movieId, String movieTitle, String seatName) {
		this.id = Instant.now().toEpochMilli(); // 밀리초 단위 타임스탬프 생성
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.seatName = seatName;
	}

	public String getSeatName() { // 게터 메소드
		return seatName;
	}

	public void save() throws IOException {
		FileWriter fw = new FileWriter(file, true); // 이어쓰기(append) 모드 설정(true)
		fw.write(this.toFileString() + "\n");
		fw.close();
	}

	private String toFileString() { // 객체 정보를 파일 저장 형식 문자열로 반환
		return String.format("%d,%d,%s,%s", id, movieId, movieTitle, seatName);
	}

	public long getId() { // 게터 메소드
		return id;
	}

}
