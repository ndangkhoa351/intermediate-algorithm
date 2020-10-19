import java.util.Scanner;
import java.util.Stack;
import java.lang.Character;
 
public class Main {
    public static int mass(char c) {
        return c == 'H' ? 1 : (c == 'C' ? 12 : 16);
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        String s;
        s = sc.next();
 
        Stack<Integer> atom = new Stack<>();
        int w, mol;
 
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                atom.add(mass(c));
            }
            else if (Character.isDigit(c)) {
                mol = atom.peek() * (c - '0');
                atom.pop();
                atom.add(mol);
            }
            else if (c == '(') {
                atom.add(-1);
            }
            else if (c == ')') {
                w = 0;
                while (atom.peek() != -1) {
                    w += atom.peek();
                    atom.pop();
                }
                atom.pop();
                atom.add(w);
            }
        }
 
        int sum = 0;
        while (!atom.isEmpty()) {
            sum += atom.peek();
            atom.pop();
        }
 
        System.out.print(sum);
    }
}
//O(N)
