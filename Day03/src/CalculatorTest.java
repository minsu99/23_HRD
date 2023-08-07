
public class CalculatorTest {

	public static void main(String[] args) {
		
		Calculator cal = new Calculator();
		Calculator cal2 = new Calculator(200, 300);
		
		// 메소드 호출 (함수 사용)
		int cresult = cal.plus(40, 50); // 리턴 타입이 있으니까 
		System.out.println(cresult);
		
		// 빼기 메소드 호출 
		cal.minus(40, 50);
		
		// 곱하기 
		System.out.println(cal2.multi());  // 매개변수가 있는 cal2에 넣어
										   // 매개변수가 없는 곳에 넣으면 X
		
		// 메소드정보 출력
		cal.methodInfo();
	
 
	}

}
