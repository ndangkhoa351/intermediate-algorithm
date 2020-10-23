import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x, n = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            x = sc.nextInt();
            pq.add(-x);

            if (i < 2) {
                System.out.println(-1);
            }
            else {
                int first = -pq.poll();
                int second = -pq.poll();
                int third = -pq.poll();

                System.out.println(1L * first * second * third);

                pq.add(-first);
                pq.add(-second);
                pq.add(-third);
            }
        }
    }
}
//O(NlogN)
