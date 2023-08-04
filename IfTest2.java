public class IfTest2 {

	public static void main(String[] args) {
		
	//난수 생성 --->    0.0 <= Math.random() < 1.0
	int n = ((int)(Math.random() * 6) + 1);	
	
		System.out.println(n);
		
		switch(n) {
		case 1:
			System.out.println("1입니다");
			break;
		case 2:
			System.out.println("2입니다");
			break;
		case 3:
			System.out.println("3입니다");
			break;
		case 4:
			System.out.println("4입니다");
			break;
		case 5:
			System.out.println("5입니다");
			break;
		case 6:
			System.out.println("6입니다");
			break;
		default:
			System.out.println("인도 천재입니다.");
		}
		
		
		
	}
	
}
