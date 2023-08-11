package my.day07.exam01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;

public class Movie {
	private long id;
	private String title; // 제목
	private String genre; // 장르
	private static final File file = new File("movies.txt"); // 없으면 만들고
	
	public Movie() {}

	public Movie(long id, String title, String genre) {
		this.id = id;
		this.title = title;
		this.genre = genre;
	}

	public Movie(String title, String genre) {
		this.id = Instant.now().getEpochSecond();
		this.title = title;
		this.genre = genre;
	}

	public void save() throws IOException {
		FileWriter fw = new FileWriter(file, true);
		fw.write(this.toFileString() + "\n");
		fw.close();
	}

	private String toFileString() {
		return String.format("%d, %s,%s", id, title, genre);
	}

	public static ArrayList<Movie> findAll() throws IOException { // 한꺼번에 찾아서 리턴 // 예외처리 (파일에서 찾을거니깐)
		ArrayList<Movie> movies = new ArrayList<Movie>();
		BufferedReader br = new BufferedReader(new FileReader(file)); // 파일로 부터 데이터를 읽자
		String line = null;

		while ((line = br.readLine()) != null) { // 한 줄 단위로 읽어 널이 아니면
			String[] temp = line.split(","); // 문자열을 나눠라
			Movie m = new Movie( // 영화 객체 생성
					Long.parseLong(temp[0]), // 영화 대푯값
					temp[1], // 제목
					temp[2] // 장르
			);
			movies.add(m); // 생성 영화 객체를 ArrayList에 추가 

		}
		br.close();
		return movies;

	}

	public String toString() {
		return String.format("[%d]: %s(%s)", id, title, genre);
	}

}
