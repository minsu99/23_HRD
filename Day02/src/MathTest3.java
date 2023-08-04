
public class MathTest3 {

	public static void main(String[] args) {

		// 369 게임을 하는데 1~10까지 정수 출력하는데 3 6 9일때 박수 소리 출력
		// continue문을 사용해
		int i;

		for (i = 1; i <= 10; i++) {
			if ((i == 3) || (i == 6) || (i == 9)) {
				System.out.printf("짝 ");
				continue; // 만나면 증가값으로 가라 
			}
			System.out.printf("%d ", i);

		}
		// 그냥 if문으로 실행
		for (i = 1; i <= 10; i++) {
			if ((i == 3) || (i == 6) || (i == 9)) {
				System.out.printf("짝 ");
			}else {
			System.out.printf("%d ", i);
			}
		}

	}
}
