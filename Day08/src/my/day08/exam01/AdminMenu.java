package my.day08.exam01;

import java.io.IOException;
import java.util.ArrayList;

public class AdminMenu extends AbstractMenu {
	// 싱글톤 패턴
	private static final AdminMenu instance = new AdminMenu(null);

	// 기본 문구 상수 필드
	private static final String ADMIN_MENU_TEXT = "1: 영화 등록하기\n" + "2: 영화 목록 보기\n" + "3: 영화 삭제하기\n"
			+ "b: 메인 메뉴로 이동 \n\n" + "메뉴를 선택하세요: ";

	// 생성자
	private AdminMenu(Menu prevMenu) {
		super(ADMIN_MENU_TEXT, prevMenu); // 부모 생성자 호출
	}

	public static AdminMenu getInstance() {
		return instance; // 메뉴 객체를 반환
	}

	public Menu next() {
		switch (scan.nextLine()) {
		case "1":
			createMovie(); // 영화 등록 진행
			return this; // 관리자 메뉴 객체 반환
		case "2": // 2번 메뉴 선택 시
			printAllMovies(); // 영화 목록 출력
			return this; // 관리자 메뉴 객체 반환
		case "3":
			deleteMovie(); // 영화 삭제 진행
			return this; // 관리자 메뉴 객체 반환(다시 관리자 메뉴가 나옴
		case "b":
			return prevMenu;
		default:
			return this;
		}
	}

	private void createMovie() {
		System.out.print("제목: ");
		String title = scan.nextLine(); // 제목 입력
		System.out.print("장르: ");
		String genre = scan.nextLine(); // 장르 입력
		Movie movie = new Movie(title, genre); // 영화 객체 생성
		try {
			movie.save();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // 영화 객체를 저장
		System.out.println(">> 등록되었습니다.");
	}

	private void printAllMovies() {
		try {
			ArrayList<Movie> movies = Movie.findAll(); // 모든 영화를 가져옴
			System.out.println();
			for (int i = 0; i < movies.size(); i++) {
				System.out.printf("%s\n", movies.get(i).toString()); // 출력
			}
		} catch (IOException e) {
			System.out.println("데이터 접근에 실패하였습니다."); // 예외 처리
		}
	}

	private void deleteMovie() {
		printAllMovies(); // 모든 영화를 출력
		System.out.print("삭제할 영화를 선택하세요: ");
		try {
			Movie.delete(scan.nextLine()); // 사용자 입력값 기준으로 삭제 요청
			System.out.println(">> 삭제되었습니다.");
		} catch (IOException e) {
			System.out.println(">> 삭제에 실패하였습니다.");
		}
	}

}