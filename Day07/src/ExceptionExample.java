
public class ExceptionExample {

	//
	static void printLength(String data) throws Exception  {
//		try { // 문자 개수 확인 시도
//				// 문제 없으면 finally 실행
			int result = data.length();
			System.out.println("문자 수: " + result);

			Class.forName("java.lang.String2");
			System.out.println("Java.lang.String 클래스가 존재");
//		} catch (NullPointerException e) {
			
			// e.printStackTrace(); // 문제를 확인할 수 있다.
			//System.out.println(e.getMessage());
			
			// System.out.println("Null 문자가 전달됨 ");
//		} catch (ClassNotFoundException f) {
			
			//f.printStackTrace();
//		} catch(Exception a){
			
			//a.printStackTrace();
//		}finally { // ******무조건 실행!!!!!!!!!!!!!!
//			
			System.out.println("마무리 실행\n");
//		}

	}

	public static void main(String[] args) throws Exception {
		printLength("This is JAVA!!");
		printLength(null);
		System.out.println("프로그램 종료 ");
	}
}
