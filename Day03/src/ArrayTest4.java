import java.util.ArrayList;

public class ArrayTest4 {

	public static void main(String[] args) {
		
		// 배열 사이즈 변경 불가 해결
		// ArrayList 사용 ---> Class만 담을 수 있다
		// add , get을 알고있어야.
		
		ArrayList<String> list = new ArrayList<String>(); // <String> 자료형을 넣어줄 수 있고
		//Vector<String> list = new Vector<String>(); // <String> 자료형을 넣어줄 수 있고
		// 안쓰면 아직 안정해진것 
		
		list.add("자바");
		list.add("꿀잼");
		list.add("dlfRk");
		list.add("dksl");
		
		
		for(int i = 0; i < list.size(); i++) { // 리스트의 크기만큼 
			System.out.println(list.get(i)); // 꺼낼때는 get !!!!
		}   // add , get 기억해라 
		
		
		// 향상된 for문  ,  for each문 
//		for(String str : list) {
//			System.out.println(str); // str에서 꺼내
//		}
		
		
		
	}

}