package my.day08.exam01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class Movie {

	private long id; // 영화 대푯값
	private String title; // 영화 제목
	private String genre; // 영화 장르
	private static final File file = new File("movies.txt"); // movies.txt 파일 객체

	public Movie(long id, String title, String genre) {
		this.id = id;
		this.title = title;
		this.genre = genre;
	}

	public Movie(String title, String genre) {
		this.id = Instant.now().getEpochSecond(); // 타임스탬프
		this.title = title;
		this.genre = genre;
	}

	public String toFileString() {
		return String.format("%d,%s,%s", id, title, genre);
	}

	public String toString() {
		return String.format("[%d]: %s(%s)", id, title, genre);
	}

	// file에 데이터 쓰기(저장,출력)
	public void save() throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(this.toFileString() + "\n");
		fw.close();
	}

	// file에서 데이터 id와 일치하는 영화객체 반환 하기
	public static Movie findById(String mvIdStr) throws IOException {
		Movie movie = null;
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { // 행 단위 문자열 읽기, 동작 반복
			String[] temp = line.split(","); // 문자열을 쉼표로 나눔
			if (mvIdStr.equals(temp[0])) { // 영화의 대푯값을 찾으면, 객체 생성
				movie = new Movie(Long.parseLong(temp[0]), temp[1], temp[2]);
				break; // 반복문 탈출(더 이상 찾지 않음)
			}
		}
		br.close(); // 입력 흐름 해제
		return movie; // 영화 객체 반환

	}

	// file에서 데이터 조회(id기준으로) 하고 삭제하기
	public static void delete(String mvIdStr) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(file));
		String text = ""; // 파일 복사를 위한 빈 문자열
		String line = null;

		while ((line = br.readLine()) != null) { // 파일을 행 단위로 읽어옴(반복)
			String[] temp = line.split(","); // 쉼표 기준으로 문자열을 나눔
			if (mvIdStr.equals(temp[0])) { // 삭제 대상값을 찾으면
				continue; // 다음 반복으로 넘어감(복사되지 않게)
			}
			text += line + "\n"; // 읽은 문자열을 누적하여 복사
		}
		br.close(); // 입력 흐름 해제

		FileWriter fw = new FileWriter(file); // FileWriter 객체 생성(덮어쓰기 모드)
		fw.write(text); // 파일 출력
		fw.close(); // 출력 흐름 해제

	}

	public String getTitle() {
		return title;
	}

	public static ArrayList<Movie> findAll() throws IOException {
		ArrayList<Movie> movies = new ArrayList<Movie>();
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = null;

		while ((line = br.readLine()) != null) { // 파일을 한 행씩 읽어와 반복
			String[] temp = line.split(","); // 쉼표를 기준으로 문자열을 나눔
			Movie m = new Movie( // 영화 객체 생성
					Long.parseLong(temp[0]), // 영화 대푯값
					temp[1], // 영화 제목
					temp[2] // 영화 장르
			);
			movies.add(m); // 생성 영화 객체를 ArrayList에 추가
		}
		br.close(); // 파일 입력 흐름 해제
		return movies; // 영화 객체가 담긴 ArrayList 반환
	}

}
