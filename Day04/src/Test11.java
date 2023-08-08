import java.util.Scanner;

public class Test11 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String str = a; // 입력 받은 문자열을 str에 저장
        System.out.println(str);

        // 대소문자 변경
        String changedStr = changeCase(str);
        System.out.println(changedStr);
    }

    // 대소문자 변경 메서드
    public static String changeCase(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (Character.isUpperCase(c)) {
                chars[i] = Character.toLowerCase(c);
            } else if (Character.isLowerCase(c)) {
                chars[i] = Character.toUpperCase(c);
            }
        }
        return new String(chars);
    }
}
