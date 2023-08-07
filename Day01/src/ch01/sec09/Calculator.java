package ch01.sec09;

public class Calculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 10;
		int y = 20;
		int result = x + y;
		System.out.println(result);
		
		float a = 15.3f;
		float b = 12.67f;
		float sum = a + b;
		System.out.println(sum);

		// 지역변수는 선언하고 초기화를 해줘야 한다. 
		float height = 175.3f;
		int weight = 68;
		int age = 23;
		
		System.out.print("height:\t" + height +"\t "+  "weight:" + weight +  " age:\t" + age + "\n");
		System.out.printf("height: %5.2f, weight: %d, age: %d\n", height, weight, age);
		
		boolean offset = true;		 // 논리형
		boolean offset1 = false;		 // 논리형
		char var1 = 'A';  // 자료형
		System.out.println(offset);
		System.out.println(offset1);
		System.out.println("\n"  + var1);
		
	}

}
