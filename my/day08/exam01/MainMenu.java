package my.day08.exam01;

import java.io.IOException;
import java.util.ArrayList;

public class MainMenu extends AbstractMenu{

	// 싱글톤 패턴 
	private static final MainMenu instance = new MainMenu(null);

	 private static final String MAIN_MENU_TEXT = // 기본 문구
	            		"1: 영화 예매하기\n" +
	                    "2: 예매 확인하기\n" +
	                    "3: 예매 취소하기\n" +
	                    "4: 관리자 메뉴로 이동\n" +
	                    "q: 종료\n\n" +
	                    "메뉴를 선택하세요: ";

		private MainMenu(Menu prevMenu) {
			super(MAIN_MENU_TEXT, prevMenu);

		}

		public static MainMenu getInstance() {
			return instance; // 메뉴 객체 반환
		}

		@Override
		public Menu next() {
			switch (scan.nextLine()) {
			case "1":
				reserve(); // 영화 예매를 진행
				return this; // 메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)
			case "2":
				checkReservation(); // 예매 확인
				return this; // 메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)
			case "3":
				cancelReservation(); // 예매 취소
				return this; // 메인 메뉴 객체 반환(다시 메인 메뉴가 나옴)
			case "4":
				if (!checkAdminPassword()) { // 관리자 비밀번호 확인
					System.out.println(">> 비밀번호가 틀렸습니다.");
					return this; // 실패한 경우 메인 메뉴 객체 반환
				}
				AdminMenu adminMenu = AdminMenu.getInstance();
				adminMenu.setPrevMenu(this); // 메인 메뉴를 이전 메뉴로 등록
				return adminMenu;
			case "q":
				return prevMenu; // q 입력 시, prevMenu를 반환
			default:
				return this; // 그 외 입력은 메인 메뉴(this)로 돌아감
			}
		}

		private boolean checkAdminPassword() {
			System.out.print("관리자 비밀번호를 입력하세요: ");
			return "admin1234".equals(scan.nextLine());
		}

		private void checkReservation() {
			System.out.print("발급번호를 입력하세요: ");
			try {
				Reservation r = Reservation.findById(scan.nextLine()); // 예매 확인
				if (r != null) {
					System.out.printf(">> [확인 완료] %s\n", r.toString());
				} else {
					System.out.println(">> 예매 내역이 없습니다.");
				}
			} catch (IOException e) {
				System.out.println(">> 파일 입출력에 문제가 생겼습니다.");
			}
		}

		private void reserve() {
			try {
				ArrayList<Movie> movies = Movie.findAll();
				for (int i = 0; i < movies.size(); i++) {
					System.out.printf("%s\n", movies.get(i).toString());
				}
				System.out.print("예매할 영화를 선택하세요: ");
				String movieIdStr = scan.nextLine();
				Movie m = Movie.findById(movieIdStr);
				ArrayList<Reservation> reservations = Reservation.findByMovieId(movieIdStr);
				Seats seats = new Seats(reservations);
				seats.show();
				System.out.print("좌석을 선택하세요(예: E-9): ");
				String seatName = scan.nextLine();
				seats.mark(seatName);
				Reservation r = new Reservation(Long.parseLong(movieIdStr), // 영화 대푯값
						m.getTitle(), // 영화 제목
						seatName // 좌석명
				);
				r.save();
				System.out.println(">> 예매가 완료되었습니다.");
				System.out.printf(">> 발급번호: %d\n", r.getId());
			} catch (IOException e) {
				System.out.println(">> 파일 입출력에 문제가 생겼습니다..");
			} catch (Exception e) {
				System.out.printf(">> 예매에 실패하였습니다: %s\n", e.getMessage());
			}
		}

		private void cancelReservation() {
			System.out.print("발급번호를 입력하세요: ");
			try {
				Reservation canceled = Reservation.cancel(scan.nextLine());
				if (canceled != null) {
					System.out.printf(">> [취소 완료] %s의 예매가 취소되었습니다.\n", canceled.toString());
				} else {
					System.out.println(">> 예매 내역이 없습니다.");
				}
			} catch (IOException e) {
				System.out.println(">> 파일 입출력에 문제가 생겼습니다.");
			}
		}

	}
