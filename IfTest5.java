import java.util.Scanner;

public class IfTest5 {

    public static class Solution {
        public int solution(int num, int n) {
            int answer = 0;

            if (num % n == 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
            return answer;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        int n = scan.nextInt();

        Solution solution = new Solution();
        solution.solution(num, n);
    }
}
