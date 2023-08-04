import java.util.Scanner;

public class Game {

	public static void main(String[] args) {
		int i;
		// 가위바위보 게임 반복 
		for(i=0; i < 10; i++) {
		
			
		System.out.println(i + "===========GAME MEUN==========="+i);
		System.out.println("1. 가위\t2. 바위\t3. 보\t9. 종료");
		System.out.println("================================");
		System.out.println("===========입력하세요===========");
		
		Scanner scan = new Scanner(System.in);
		
		int user = scan.nextInt();
		if (user >= 5) {
			System.out.println("게임을 종료합니다...");
			break;
		}
		
		//컴퓨터가 만든 난수 값
		int com = (int)(Math.random()*3)+1;
		
		// 승패 판단하기 
		System.out.println("user:" + user);
		System.out.println("com:" + com);
		
		
			
		// 비길경우 
		if (user ==  com) {
			System.out.println("비겼습니다");
		}else if((user == 1 && com == 3) || (user == 2 && com == 1 ) || (user == 3 && com == 2)) {
			System.out.println("이겼습니다");
		}else if(user == 4) {
			System.out.println("무적입니다.");
		}else {
			System.out.println("졌습니다");
		}
		
	  }
		

	}

}
