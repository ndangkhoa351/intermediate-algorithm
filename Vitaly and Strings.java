import java.util.Scanner;
import java.util.Arrays;
 
public class Main {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        char s[] = sc.next().toCharArray();
        char t[] = sc.next().toCharArray();
 
        for (int i = s.length - 1; i >= 0; i--) {
            if (s[i] == 'z') {
                s[i] = 'a';
            }
            else {
                s[i]++;
                break;
            }
        }
 
        System.out.print(Arrays.equals(s, t) ? "No such string".toCharArray() : s);
    }
}
//O(n)
