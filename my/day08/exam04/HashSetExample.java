package my.day08.exam04;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class HashSetExample {

	public static void main(String[] args) {

		// hashSet 컬렉션 생성
		Set<Member> set = new HashSet<Member>();
		Set<String> set1 = new HashSet<String>();

		// Member 객체 저장
		set.add(new Member("홍길동", 30));
		set.add(new Member("홍길동", 30)); // 중복 1개만 저장
		set.add(new Member("강민수", 23));
		set.add(new Member("성정현", 23));
		set.add(new Member("강민수", 30));
		
		// 객체 추가
		set1.add("Java");
		set1.add("JDBC");
		set1.add("JSP");
		set1.add("String");
		
		// 객체를 하나씩 가져와서 처리 
		Iterator<String> iterator = set1.iterator();
		while(iterator.hasNext()) {
			// 객체를 하나 가져오기
			String element = iterator.next();
			System.out.println(element);
			if(element.equals("JSP")) {
				// 가져온 객체를 컬렉션에서 제거 
				iterator.remove();
			}
		}
		System.out.println();
		
		// 객체 제거 
		set1.remove("JDBC");
		
		// 객체를 하나씩 가져와서 처리 
		for (String element : set1) {
			System.out.println(element);
		}
		

		// 저장된 객체 수 출력
		System.out.println("총 객체 수: " + set.size());

	}

}
