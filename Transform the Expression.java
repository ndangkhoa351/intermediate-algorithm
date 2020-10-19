import java.util.Scanner;
import java.util.Stack;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        Stack<Character> s = new Stack<>();
 
        for (int i = 0; i < t; i++) {
            char[] expression = sc.next().toCharArray();
            for (Character symbol : expression) {
                if (Character.isLetter(symbol)) {
                    System.out.print(symbol);
                }
                else if (symbol.equals(')')) {
                    System.out.print(s.pop());
                }
                else if (!symbol.equals('(')) {
                    s.add(symbol);
                }
            }
            System.out.println();
        }
    }
}
//O(T∗len(expression))
