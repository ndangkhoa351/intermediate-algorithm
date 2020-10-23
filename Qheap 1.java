import java.util.Scanner;
import java.util.PriorityQueue;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
        PriorityQueue<Integer> pq = new PriorityQueue<>(), pqRemove = new PriorityQueue<>();

        int type, value;

        for (int k = 0; k < Q; k++) {
            type = sc.nextInt();

            if (type == 1) {
                value = sc.nextInt();
                pq.add(value);
            }
            else if (type == 2) {
                value = sc.nextInt();
                pqRemove.add(value);
            }
            else {
                while (!pqRemove.isEmpty() && (int)pq.peek() == (int)pqRemove.peek()) {
                    pq.remove();
                    pqRemove.remove();
                }

                System.out.println(pq.peek());
            }
        }
    }
}
//O(QlogN)
