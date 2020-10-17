import java.util.Scanner;
import java.lang.Math;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> a = new ArrayList<Integer>();

        for (int i = 0; i < n; i++) {
            a.add(sc.nextInt());
        }

        int count = 0, j = n - 1, last_kill_pos = 0;

        for (int i = n - 1; i >= 0; i--) {
            j = Math.min(j, i);
            last_kill_pos = Math.max(0, i - a.get(i));

            if (j > last_kill_pos) {
                count += (j - last_kill_pos);
                j = last_kill_pos;
            }
        }

        System.out.print(n - count);
    }
}
//O(n)
