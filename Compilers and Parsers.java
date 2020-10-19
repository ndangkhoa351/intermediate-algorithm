import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
 
        for (int k = 0; k < T; k++) {
            String s = sc.next();
            Stack<Character> expr = new Stack<>();
            int ans = 0;
 
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '<') {
                    expr.push(s.charAt(i));
                }
                else if (expr.empty()) {
                    break;
                }
                else {
                    expr.pop();
                    ans = (expr.empty() ? i + 1 : ans);
                }
            }
 
            System.out.println(ans);
        }
    }
}
//O(T∗N)
