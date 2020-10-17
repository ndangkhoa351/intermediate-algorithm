import java.util.Scanner;
import java.util.ArrayList;
import java.lang.Math;
 
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<>();
 
        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }
 
        int t = 0;
        for (int i = 0; i < n; i++) {
            if (t + 15 < a.get(i)) {
                System.out.print(t + 15);
                return;
            }
            else {
                t = a.get(i);
            }
        }
 
        System.out.print(Math.min(t + 15, 90));
    }
}
//O(n)
