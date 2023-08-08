

class Member {

    private String name;
    private String id;
    private int age;
    private String password;
    
    public Member(String name, String id) {
        this.name = name;
        this.id = id;
    }
    
    // 나이와 패스워드에 대한 생성자와 setter 메소드는 필요할 수 있습니다.
}

class MemberService {
    boolean login(String id, String password) {
        if (id.equals("hong") && password.equals("12345")) {
            return true;
        } else {
            return false;
        }
    }
    
    void logout(String id) {
        if (id.equals("hong")) {
            System.out.println("로그아웃");
        }else {
        	System.out.println("아이디를 확인하세요");
        }
    }
}

public class MemberServiceExample {
	
    public static void main(String[] args) {
        Member user1 = new Member("홍길동", "hong"); // 나이와 패스워드 정보는 이후에 설정할 수 있음
        MemberService memberService = new MemberService();
        
        boolean result = memberService.login("hong", "11345");
        if (result) {
            System.out.println("성공");
        } else {
            System.out.println("심각한 오류가 발생했습니다.");
        }
    }
}
