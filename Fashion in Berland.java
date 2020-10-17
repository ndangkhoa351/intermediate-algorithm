import java.util.ArrayList;
import java.util.Scanner;
 
public class Main {
    private static boolean checkJacket(ArrayList<Integer> v, int n) {
        if (n == 1) {
            if (v.get(0) == 1)
                return true;
            else
                return false;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (v.get(i) == 0) {
                count++;
            }
        }
        if (count == 1)
            return true;
        else
            return false;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int value;
        ArrayList<Integer> v = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            value = sc.nextInt();
            v.add(value);
        }
 
        boolean result = checkJacket(v, n);
        if (result == true)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
//O(n)
