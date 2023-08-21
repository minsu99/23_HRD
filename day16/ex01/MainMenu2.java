package my.day16.ex01;

public class MainMenu2 {
	 while (true) { // 무한루프로 메뉴를 계속 표시하도록 설정
	        System.out.println();
	        System.out.println("---------------------------------------------------");
	        System.out.println("메인메뉴: 1. Create | 2. Read | 3. Clear | 4. Logout | 5. Exit  ");
	        System.out.println();
	        System.out.println("메뉴 선택: ");
	        String menuNo = scan.nextLine();
	        System.out.println();

	        switch (menuNo) {
	            case "1" -> create();
	            case "2" -> read();
	            case "3" -> clear();
	            case "4" -> logout();
	            case "5" -> exit();
	        }
	    }
}
