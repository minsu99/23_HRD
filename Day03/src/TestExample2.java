public class TestExample2 {

	public static void main(String[] args) {
		// run as를 이용해 args의 배열을 이용 
		
		
		//		// 문자열 3개의 값을 저장하는 배열을 생성 
//		String name[] = {"감자바","홍길동", "박깅동"};
//		
////		String name2[] = new String[3]; // 크기 초기화 (수정 X)
//		String name2[] = null;
//		
//		name2 = new String[] {"와우","자바","재미있다"};
//		
////		name2[0] = "박자바";
////		name2[1] = "박자반";
////		name2[2] = "박자박";
		
		for (int i= 0; i<args.length; i++) {
			System.out.println(args[i]);
		}
		int num1 = Integer.parseInt(args[0]); // 문자를 숫자로 다시 문자로 출력  
		int num2 = Integer.parseInt(args[1]);
		
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		
		

	}

}