import java.util.ArrayList;
import java.util.Scanner;

public class BankApplication {
	private static ArrayList<Account> arraylist = new ArrayList<Account>();
	private static Scanner scan = new Scanner(System.in);

	private static void createAccount() {
		System.out.println("-----------");
		System.out.println("계좌생성");
		System.out.println("-----------");

		System.out.print("계좌번호: ");
		String ano = scan.next();
		System.out.print("계좌주: ");
		String owner = scan.next();
		System.out.print("초기 입금액: ");
		int balance = scan.nextInt();

		Account newAccount = new Account(balance, ano, owner);
		arraylist.add(newAccount); // for문으로 할 필요없이 add로 계좌 추가
		System.out.println("결과: 계좌가 생성되었습니다.");
	}

	private static void accountList() {
		// 계좌목록 출력
		System.out.println("--------");
		System.out.println("계좌목록");
		System.out.println("---------");
		
		if (arraylist.size() == 0) {
			System.out.println("결과: 계좌가 없습니다");
			return;
		}


		for (Account ac : arraylist) {
			System.out.println("계좌번호: " + ac.getAno() + ", 예금주: " + ac.getOwner() + ", 잔액: " + ac.getBalance());
		}
	}

	private static void deposit() {
		System.out.println("----");
		System.out.println("예금 ");
		System.out.println("----");
		System.out.print("계좌번호: ");
		String ano = scan.next();
		Account account = findAccount(ano);

		if (account == null) {
			System.out.println("결과: 계좌가 없습니다");
			return;
		}

		if (account != null) {
			System.out.print("예금액: ");
			int money = scan.nextInt();
			account.setBalance(account.getBalance() + money);
			System.out.println("결과: 예금이 성공되었습니다.");
		}
	}

	private static Account findAccount(String ano) {
		Account account = null;
		for (Account ac : arraylist) {
			if (ac.getAno().equals(ano)) {
				return ac;
			}
		}
		return null;
	}

	private static void withdraw() {
		System.out.println("-----");
		System.out.println("출금");
		System.out.println("-----");
		System.out.print("계좌번호: ");
		String ano = scan.next();

		Account account = findAccount(ano);

		if (account == null) {
			System.out.println("해당 계좌가 없습니다 ");
			return;
		}
		System.out.print("출금액: ");
		int money = scan.nextInt();
		account.setBalance(account.getBalance() - money);
		System.out.println("결과: 출금이 성공되었습니다");

	}

	public static void main(String[] args) {
		while (true) {
			System.out.println("------------------------------------------------------------");
			System.out.println("1. 계좌생성 || 2. 계좌목록 || 3. 예금 || 4. 출금 || 5.종료 ");
			System.out.println("------------------------------------------------------------");

			System.out.print("선택> ");
			int i = scan.nextInt();

			if (i == 1) {
				createAccount();
			} else if (i == 2) {
				accountList();
			} else if (i == 3) {
				deposit();
			} else if (i == 4) {
				withdraw();
			} else if (i == 5) {
				System.out.println("종료합니다.");
				break;
			}
		}
	}
}
