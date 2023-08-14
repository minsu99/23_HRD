package my.day08.HashMapexam;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class HashMapExample {

	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<>(); 
		
		// 객체 저장
		map.put("홍길동", 90);
		map.put("신용권", 84);
		map.put("동장순", 85);
		map.put("박상순", 95);
		map.put("박지원", 98);
		map.put("허윤진", 99);
		map.put("고윤정", 100);
		map.put("손흥민", 95);
		map.put("홍길동", 95); // 최근에 저장된 값이 저장

		System.out.println("총 Entry 수: " + map.size());
		System.out.println();
		
		// 키로 값 얻기 
		String key = "홍길동";
		int value = map.get("홍길동");
		System.out.println(key + ": "+value);
		System.out.println();
		
		// 키를 반복해서 키와 값을 모두 얻기 
		Set<String> keySet = map.keySet();
		
		Iterator<String> iterator = keySet.iterator();
		
		while(iterator.hasNext()) {
			String s = iterator.next();
			Integer v = map.get(s);
			System.out.println(s + ": " + v);
			
		}
		map.remove("홍길동");
		System.out.println("총 Entry 수: " + map.size());
	}

}
