import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        while (true) {
            int n = sc.nextInt();

            if (n == 0) {
                break;
            }

            for (int i = 0; i < n; i++) {
                int x = sc.nextInt();
                pq.add(x);
            }

            long ans = 0;

            while (pq.size() > 1) {
                int a = pq.poll();
                int b = pq.poll();
                ans += a + b;
                pq.add(a + b);
            }

            System.out.println(ans);
            pq.remove();
        }
    }
}
//O(NlogN)
