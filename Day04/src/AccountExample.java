public class AccountExample {

	public static void main(String[] args) {
		Account ac = new Account();
		ac.setBalance(10000);
		System.out.println("현재 잔고: " + ac.getBalance());
		
		ac.setBalance(-100);
		System.out.println("현재 잔고: " + ac.getBalance());
		
		ac.setBalance(2000000);
		System.out.println("현재 잔고: " + ac.getBalance());
		
		ac.setBalance(300000);
		System.out.println("현재 잔고: " + ac.getBalance());

	}
}

class Account {
	// 0~1000000범위로 MIN_BALANCE와 MAX_BALANCE 상수 선언
	public static final int MIN_BALANCE = 0;
	public static final int MAX_BALANCE = 1000000;
	private int balance;
	private String ano; // 계좌번호
	private String owner; // 계좌 주 

	public Account() {

	}

	public Account(int balance, String ano, String owner) {

		this.balance = balance;
		this.ano = ano;
		this.owner = owner;
	}

	public void setBalance(int balance) {
		// 범위 초과 오류 메세지
		if ((balance < MIN_BALANCE) || (balance > MAX_BALANCE)) {
			//System.out.println("오류발생 범위 초과");
			return;
		}
		this.balance = balance;

	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public int getBalance() {
		return balance;
	}
}
