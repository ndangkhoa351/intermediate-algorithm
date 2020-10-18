import java.util.Scanner;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n], sorted_a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
            sorted_a[i] = a[i];
        }

        Arrays.sort(sorted_a);
        int l = 0, r = 0;

        for (int i = 0; i < n; i++) {
            if (a[i] != sorted_a[i]) {
                l = i;
                break;
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            if (a[i] != sorted_a[i]) {
                r = i;
                break;
            }
        }

        for (int i = l, j = r; i < j; i++, j--) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }

        if (!Arrays.equals(a, sorted_a)) {
            System.out.print("no");
            return;
        }

        System.out.println("yes");
        System.out.print((l + 1) + " " + (r + 1));
    }
}
//O(nlogn)
