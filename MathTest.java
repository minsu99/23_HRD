
public class MathTest {

	public static void main(String[] args) {
		
		// 최대값 구하기
		int mx = Math.max(-5, -8);
		System.out.println("최대값 " + mx);
		
		int mn = Math.min(-5, -8);
		System.out.println("최솟값 "+ mn);
		
		double mx2 = Math.max(1.23, 3.45);
		System.out.println("최대값 "  + mx2);
		System.out.println("천정값(올림값) "  + Math.ceil(5.67));
		System.out.println("미루값(내림값) "  + Math.floor(5.67));
		
		// 3의 7승 d
		double pw = Math.pow(3, 7);
		System.out.println("" + pw);
		
		// 64.0의 제곱근
		double sq = Math.sqrt(64.0);
		System.out.println("" + sq);
		
		// 반지름이 5인 원의 면적과 둘레를 구하기
		int rad = 5;
		double area = rad * rad * Math.PI;
		System.out.println("면적은 " + area);
		
		double area2 = 2 * rad * Math.PI;
		System.out.println("둘레는 " + area2);
		
		
		
		
		
		
		
	}

}
