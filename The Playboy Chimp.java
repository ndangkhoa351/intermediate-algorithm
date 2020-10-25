import java.io.*;
import java.util.*;
 
class Solution {
    
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n, q, x, pos;
        n = in.nextInt();
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        
        q = in.nextInt();
        String ans = "";
        int mid, l, r;
        while (q-- > 0) {
            x = in.nextInt();
            pos = -1;
            l = 0;
            r = n - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                if (a[mid] < x) {
                    pos = Math.max(pos, mid);
                    l = mid + 1;
                }
                else
                    r = mid - 1;
            }
            if (pos == -1)
                ans = "X";
            else
                ans = a[pos] + "";

            pos = n;
            l = 0;
            r = n - 1;
            while (l <= r) {
                mid = (l + r) / 2;
                if (a[mid] > x) {
                    pos = Math.min(pos, mid);
                    r = mid - 1;
                }
                else
                    l = mid + 1;
            }
            if (pos == n)
                ans += " X";
            else
                ans += " " + a[pos];

            System.out.println(ans);
        }
        return;
    }
}
//O(QlogN)
