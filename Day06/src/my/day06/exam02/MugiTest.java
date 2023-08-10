package my.day06.exam02;

public class MugiTest {

	public static void main(String[] args) {
		Mugi m = null;
		m = new Gun();
		m.play();
		
		m = new Arrow(); // 인터페이스
		m.play();
		
		m = new 칼();
		m.play();
		
		키친도구 k = null;
		k = new 칼();
		k.play();
		

	}

}
