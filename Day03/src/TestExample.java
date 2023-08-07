import java.util.Scanner;

public class TestExample {

    public static void main(String[] args) {
    	
		// 수도 요금 계산 예제
		while (true) {
			Scanner scan = new Scanner(System.in);
			System.out.println("1. 가정용 Leter당 50원");
			System.out.println("2. 산업용 Leter당 40원");
			System.out.println("3. 공업용 Leter당 30원");
			System.out.print("선택> ");

			int i = scan.nextInt();
			int fare = 0; // 사용요금
			double tax = 0; // 세금

			if (i == 1) {
				System.out.println("1. 가정용 Leter 50원");
				tax = 50;
			} else if (i == 2) {
				System.out.println("2. 산업용 Leter 40원");
				tax = 45;
			} else {
				System.out.println("3. 공업용 Leter 30원");
				tax = 30;
			}

			System.out.print("사용량을 입력하세요 (Leter): ");
			int use = scan.nextInt(); // 사용량

			fare = (int) (use * tax); // 사용량 * 세금
			tax = fare * 0.05;
			double total = fare + tax; 
			//tax = fare * 0.05;
			System.out.println("총 TAX는: " + fare + "원");
			System.out.println("총 : " + total);
			System.out.println("=================================");
			System.out.println("=================================");
		}

	}

}
