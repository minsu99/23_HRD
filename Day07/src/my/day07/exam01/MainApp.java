package my.day07.exam01;

import java.util.ArrayList;

public class MainApp {
	static Movie movie;
	
public static void main(String[] args) throws Exception {
	System.out.println("프로그램 시작");
	
	// 모든 영화 정보 출력 
	ArrayList<Movie> list = Movie.findAll();
	for (Movie m : list) {
		System.out.println(m.toString());
	}
	
	
	System.out.println("프로그램 종료");
}
}
