package my.day05.exam5;

public class ExampleHumanTest {

	public static void main(String[] args) {
		
		//Superman sp = new Superman(); 
		
		Human sp = new Superman(); // 자동 형변환 (업캐스팅)
		
		// 타입만 부모지 객체 자체는 자식이라서 
		// 그치만 타입은 부모라서 부모는 power를 가지고 있지 않아서
		// 접근X 
		
		// 슈퍼맨, 아쿠아맨 모두 휴먼의 자식들 하나의 부모만 섬긴다 
		// 하나의 타입으로 모을 수 있다/.
		
		sp.name = "슈퍼맨";
		sp.height = 170;
//		sp.power = 900; // 부모에는 power가 없어 접근 불가능하다고 
		
		// 강제로 타입변환 (다운캐스팅)
		((Superman)sp).power = 900;
		
		String result = sp.getInfo();
		// 오버라이딩하면 자식 꺼 먼저 
		System.out.println("슈퍼맨 info");
		System.out.println(result);
		
		System.out.println("===============");
		
		Human am = new AquaMan();
		
		am.name = "아쿠아맨";
		am.height = 200;
		// 형 변화 다운캐스팅
		((AquaMan)am).speed = 999;
		String result2 = am.getInfo();
		System.out.println("아쿠아맨 info");
		System.out.println(result2);
	}

}
