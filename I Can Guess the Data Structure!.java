import java.util.*;
 
public class Main {
    static int isStack, isQueue, isPQ;
    static Stack<Integer> s = new Stack<>();
    static Queue<Integer> q = new LinkedList<>();
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
 
        while (sc.hasNext()) {
            int n = sc.nextInt();
            s.clear();
            q.clear();
            pq.clear();
            isStack = isQueue = isPQ = 1;
 
            for (int i = 0; i < n; i++) {
                int type = sc.nextInt();
                int x = sc.nextInt();
 
                if (type == 1) {
                    s.add(x);
                    q.add(x);
                    pq.add(-x);
                }
                else {
                    if (s.empty()) {
                        isStack = isQueue = isPQ = 0;
                        continue;
                    }
 
                    if (s.pop() != x) {
                        isStack = 0;
                    }
                    if (q.poll() != x) {
                        isQueue = 0;
                    }
                    if (pq.poll() != -x) {
                        isPQ = 0;
                    }
                }
            }
 
            if (isStack + isQueue + isPQ == 0) {
                System.out.println("impossible");
            }
            else if (isStack + isQueue + isPQ > 1) {
                System.out.println("not sure");
            }
            else if (isStack == 1) {
                System.out.println("stack");
            }
            else if (isQueue == 1) {
                System.out.println("queue");
            }
            else {
                System.out.println("priority queue");
            }
        }
    }
}
//O(NlogN)
