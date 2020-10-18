import java.util.Scanner;
import java.lang.Math;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bars = new int[n];

        for (int i = 0; i < n; i++) {
            bars[i] = sc.nextInt();
        }

        Arrays.sort(bars);
        int n_towers = 1, max_height = 1, cur_height = 1;

        for (int i = 1; i < n; i++) {
            if (bars[i] == bars[i - 1]) {
                cur_height++;
                max_height = Math.max(max_height, cur_height);
            }
            else {
                n_towers++;
                cur_height = 1;
            }
        }

        System.out.print(max_height + " " + n_towers);
    }
}
//O(NlogN)
