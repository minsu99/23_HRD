
package my.day06.exam03;

import java.util.ArrayList;
import java.util.Scanner;

public class MyShop implements IShop {

	User[] users = new User[2];
	Product[] products = new Product[4];
	ArrayList<Product> cart = new ArrayList<Product>();
	Scanner scan = new Scanner(System.in); // 변수명 수정: san -> scan

	int selUser;
	String title;

	// IShop 인터페이스의 메소드 오버라이딩

	@Override
	public void SetTitle(String title) {
		this.title = title; // 입력받은 title을 클래스 변수에 저장
		System.out.println(title);
	}

	@Override
	public void genUser() {
		User user = new User("홍길동", PayType.CARD); // User 생성자에 매개변수 추가하여 생성
		users[0] = user;

		user = new User("블로거", PayType.CASH); // User 생성자에 매개변수 추가하여 생성
		users[1] = user;
	}

	@Override
	public void genProduct() {
		CellPhone cp = new CellPhone("갤럭시 노트5", 1000000, "SKT");
		products[0] = cp;
		cp = new CellPhone("아이폰15", 1500000, "4K");
		products[1] = cp;
		SmartTV smartTV = new SmartTV("삼성 3D Smart TV", 5000000, "4K");
		products[2] = smartTV;
		smartTV = new SmartTV("LG Smart TV", 2500000, "Full HD");
		products[3] = smartTV;
	}

	@Override
	public void start() {
		System.out.println(title + ": 메인화면 - 계정 선택");
		System.out.println("==============================");
		int i = 0;

		for (User u : users) {
			System.out.printf("[%d]%s(%s)\n", i++, u.getName(), u.getPayType());
		}

		System.out.println("[x]종료");
		System.out.print("선택: ");
		String sel = scan.next();
		System.out.println("## " + sel + " 선택 ##");
		// 선택된 값에 따라 처리하는 로직 추가

		switch (sel) {
		case "x":
			System.out.println("## 종료합니다. ##");
			break;
		default:
			selUser = Integer.parseInt(sel);
			productList();

		}
	}
	
	public void productList() {
		System.out.println(title + ": 상품 목록 - 상품 선택");
		System.out.println("==============================");
		int i = 0;
		
		for (Product p : products) {
			System.out.println("[" + i + "]");
			p.printDetail();
			i++;
		}
		System.out.println("[h]메인화면");
		System.out.println("[c]체크아웃");
		System.out.println("선택  : ");
		String sel = scan.next();
		System.out.println("## " + sel + "선택 ##");

		switch (sel) {
		case "h":
			start();
			break;
		case "c":
			checkOut();
			break;
		// System.out.println("## 종료합니다. ##");
		// break;
		default:
			int psel = Integer.parseInt(sel);
			cart.add(products[psel]);
			productList();
		}
	}

	public void checkOut() {
		System.out.println(title + ": 체크아웃");
		System.out.println("==============================");
		int total = 0;
		int i = 0;

		for (Product p : cart) {
			System.out.printf("[%d]%s(%s)\n", i++, p.pname, p.price);
			total += p.price;

		}
		System.out.println("=================================");
		System.out.println("결제방법: " + users[selUser].getPayType());

		System.out.println("합계: " + total + " 원 입니다 ");
		System.out.println("[p]이전, [q]결제 완료");
		System.out.println("선택 : ");
		String sel = scan.next();

		switch (sel) {
		case "q":
			System.out.println("## 결제가 완료 되었습니다. 종료합니다 ##");
			System.exit(0);
			break;
		case "p":
			productList();
			break;
		// System.out.println("## 종료합니다. ##");
		// break;
		default:
			checkOut();

		}
	}
}
