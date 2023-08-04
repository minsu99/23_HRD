import java.util.Scanner;

public class MathTest4 {

	public static void main(String[] args) {
		// 7번 
		Scanner scan = new Scanner(System.in);

		int i = 0, sum = 0, balance=0, cd= 0, rcd= 0;
		while (true) {

			System.out.println("------------------------------------------------------------");
			System.out.println("1. 예금 || 2. 출금 || 3. 잔고 || 4. 대출 || 5.상환 || 6. 종료");
			System.out.println("------------------------------------------------------------");

			System.out.print("선택> ");
			i = scan.nextInt();

			if (i == 1) {
				System.out.print("예금액> ");
				sum = scan.nextInt();
				balance += sum;
			} else if (i == 2) {
				System.out.print("출금액> ");
				sum = scan.nextInt();
				balance -= sum;
			} else if (i == 3) {
				System.out.print("잔고액> ");
				System.out.println(balance);
				System.out.println("대출액> " + cd);
				
				
			} else if (i == 4) {
				System.out.print("대출금> "  );
				cd = scan.nextInt();
				balance += cd;
				
				System.out.println(cd);
			} else if (i == 5) {
				System.out.print("상환금> " );
				balance -= rcd;
				cd -= rcd;
				rcd = scan.nextInt();
				
				System.out.println(cd);
			} else if (i == 6) {
				System.out.print("종료> "  );
				break;
			}

		}
	}
}
