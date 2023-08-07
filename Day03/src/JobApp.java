import java.util.ArrayList;
import java.util.Scanner;

public class JobApp {
	
	// 속성 
	public JobApp() {
		
	}
	// 메소드  (반환타입과 매개변수가 모두 없는 메소드 타입)
	public void showMenu() {
		System.out.println("*******JOB v1.1*********");
		System.out.println("** 1. 구직 등록");
		System.out.println("** 2. 구인 등록");
		System.out.println("** 3. 구직자 정보 출력");
		System.out.println("** 4. 구인회사 정보 출력");
		System.out.println("** 5. 종료");
		System.out.println("*************************");
		System.out.println(" 메뉴 번호를 입력하세요> ");
		System.out.println("*************************");
		
	}
	// 사람의 정보를 입력받는 메소드 (반환타입은 문자열, 매개변수는 없는 메소드 타입)
	public void inputPerson() {
		
		Scanner scan = new Scanner(System.in);
		// 이름 나이 전화번호 성별 
		System.out.print("이름입력: ");
		String name = scan.next();
		System.out.print("나이입력: ");
		int age = scan.nextInt();
		System.out.println("-------메뉴------");
		System.out.println("1. 남자, 2. 여자 ");
		System.out.println("-----------------");
		//System.out.print("성별입력: ");
		int n = scan.nextInt();
		char sex; 
		if (n ==1) {
			sex = 'M';
					}else {
			sex = 'F';
			
		}

		System.out.print("전화번호입력: ");
		String tel = scan.next();
		
		Person per = new Person(name, age, sex, tel); // 사람을 완벽하게 만들기 
		
		// 사람을 만들고 배열에 넣어라
		// 크기를 알 수 없어 
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(per); // 사람이 만들어졌다.
		
		// 메소드 내에서 메소드 호출 
		String result = per.showProfile();
		System.out.println(result);
		
		
	}
	
	public static void main(String[] args) {
		JobApp jap = new JobApp();
		jap.showMenu();
		while (true) {
			Scanner scan = new Scanner(System.in);
			int num = scan.nextInt();

			if (num == 5) {
				System.out.println("EXIT");
				System.exit(0);
			} else if (num == 1) {
				jap.inputPerson();
				System.out.println("구직 등록> ");
			} else if (num == 2) {
				jap.inputPerson();
				System.out.println("구인 등록> ");
			} else if (num == 4) {
				jap.inputPerson();
				System.out.println("구인회사 정보 출력> ");
			} else if (num == 3) {
				jap.inputPerson();
				System.out.println("구직자 정보 출> ");
			} 
		}
	}

}
