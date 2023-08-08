import java.util.ArrayList;

public class SchoolApp {

	public static void main(String[] args) {
		
		Student st = new Student(); // 이러면 안되는거
		st.set학과("정보통신공학과\n");
		st.set학번("20181432\n");
		st.set수강과목("JAVA");
		
		System.out.println("학생1의 학번: " + st.get학번());
		st.showInfo();
		
		// 배열에 넣어보자
		
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(st); // add하면서 객체
		list.add(new Student("컴퓨터공학과", "20220000", "파이썬"));
		
		System.out.println(list.size()); // 2개 들어갔다 
		
		for(Student s : list) {
			s.showInfo();
		}
		
		
		
		

	}

}
