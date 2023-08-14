package my.day08.exam01;

public class MainApp {
	static Movie movie;

	public static void main(String[] args) throws Exception {
		System.out.println("프로그램 시작");

		// 모든 영화 정보 출력
//		ArrayList<Movie> list = Movie.findAll();
//		for (Movie m : list) {
//			System.out.println(m.toString());
//		}
//
		Menu menu = MainMenu.getInstance(); // "메인 메뉴"를 가져옴
		while (menu != null) { // 메뉴가 있으면 계속 반복
			menu.print(); // 현재 메뉴 출력
			menu = menu.next(); // 사용자 입력 후, 다음 메뉴로 갱신
		}
		System.out.println("프로그램 종료");

	}
}

interface Menu {
	public void print();

	public Menu next();

}
