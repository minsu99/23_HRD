
public class MethodTest2 {

	static final double PI = 3.14192; // 상수선언 final 대문자로 써야 함

	// 1. 7단 출력 메소드
	public static void gugudan1() {
		int dan = 7;
		for (int i = 1; i < 10; i++) {
			System.out.printf("%d X %d = %d\n", dan, i, (dan * i));
		}
	}

	// 2. 구구단 원하는 단을 출력해주는 메서드를 만들어주세요.(매개변수)
	// gugudan1 오버로딩
	public static void gugudan1(int dan) {
		for (int i = 1; i < 10; i++) {
			System.out.println(dan + " X " + i + " = " + (dan * i));
		}
	}

	public static void gugudan1(int dan, int limit) {
		//dan = dan;
			for (int j = 1; j <= limit; j++) {
				System.out.println(dan + " X " + j + " = " + (dan * j));
			}
		
	}

	// 3. 구구단 원하는 단을 출력해주는 메서드를 만들어주세요.(매개변수)
	// gugudan1 오버로딩 X
	public static void gugudan2(int limit) { // 원하는 단의 -1까지 계산해서
		for (int i = 1; i < limit; i++) {
			System.out.printf("%d X %d = %d\n", limit, i, (limit * i));
		}
	}

	// ## 1부터 ~ 원하는 단까지 출력하기
	public static void gugudan4(int limit) {
		for (int dan = 1; dan <= limit; dan++) { // 1부터 입력받은 단 까지
			for (int i = 1; i < 10; i++) {
				System.out.println(dan + " x " + i + " = " + dan * i);
			}
		}
	}

	// 4. 원하는 이름을 출력
	void printName(String name) {
		System.out.println(name);
	}

	// 5. 자신의 이름을 리턴하는 메소드 만들기
	public String getName() {
		return "강민수";
	}

	// 6.
	static int square(int num) {
		return num * num;
	}

	static double area(double radius) {

		return radius * radius * PI;
	}

	// 객체지향 하면서 알아야할 부분들
	// 너무 많이 부여하지 않도록
	// 단일책임만 받도록 (단일책임의 원칙) LSP

	public static void main(String[] args) {
		MethodTest2 mt = new MethodTest2(); // 메소드들 호출
		mt.gugudan1();
		System.out.println("--1---");
		mt.gugudan1(3);
		System.out.println("--2---");
		mt.gugudan1(3, 5);
		System.out.println("--3---");
		mt.gugudan2(3);
		System.out.println("-----");
		mt.gugudan4(3);
		System.out.println("-----");

		int num1 = MethodTest2.square(10); // 정적메소드
		System.out.println(num1);
		System.out.println("======");
		mt.printName("홍길동");
		String n = mt.getName();
		System.out.println("나의 이름은 " + n);
		System.out.println("======");
		// 이름을 my_name 에 저장
		String my_name = mt.getName();
		System.out.println(my_name);
		MethodTest2.area(6.0);
		System.out.println(MethodTest2.area(6.0));

	}

}
