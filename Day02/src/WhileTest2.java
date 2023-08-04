public class WhileTest2 {

	public static void main(String[] args) throws Exception { 
		
		//문제2 while문의 무한반복 
//		String str = "";
//		Scanner scan = new Scanner(System.in);
//		
//		while(true) {
//			str = scan.next();
//			if (str.equals("x")  || str.equals("X"))
//				break;
//			
//		}
		
		// while 루프를 이용해 난수 문제 
		// 누진 합계가 20이면 루르 종료
		boolean bool = false;
		double sum = 0.0;
		while(true) {
			double no = Math.random();
			sum += no;
			Thread.sleep(100); // 재우는거 
			System.out.println("sum: " + sum);
			if(sum>20) break;
		}
		System.out.print("END");
		System.out.println("무한루프 종료");
		
		
		
		
		
		
		
     }
}
