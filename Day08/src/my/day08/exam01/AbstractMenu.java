package my.day08.exam01;

import java.util.Scanner;

public abstract class AbstractMenu implements Menu {
	protected String menuText; // 기본 문구
	protected Menu prevMenu; // 이전 메뉴

	protected static final Scanner scan = new Scanner(System.in);

	public AbstractMenu(String menuText, Menu prevMenu) { // 생성자
		this.menuText = menuText;
		this.prevMenu = prevMenu;
	}

	public void setPrevMenu(Menu prevMenu) {
		this.prevMenu = prevMenu;
	}

	public void print() {
		System.out.print("\n" + menuText); // 메뉴 출력
	}

}