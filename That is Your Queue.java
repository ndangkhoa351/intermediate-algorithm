import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
 
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int P, C, n, x, temp, tc = 1;
        char cmd;
        Queue<Integer> q = new LinkedList<Integer>();
 
        while (true) {
            P = sc.nextInt();
            C = sc.nextInt(); 
             
            if (P == 0 && C == 0) {
                break;
            }
 
            for (int i = 1; i <= Math.min(P, C); i++) {
                q.add(i);
            }
 
            System.out.format("Case %d:\n", tc++);
             
            for (int i = 0; i < C; i++) {
                cmd = sc.next().charAt(0);
                 
                if (cmd == 'N') {
                    System.out.println(q.peek());
                    q.add(q.poll());
                }
                else {
                    x = sc.nextInt();
                    n = q.size();
                    q.add(x);
 
                    for (int j = 0; j < n; j++) {
                        temp = q.poll();
                        if (temp != x) {
                            q.add(temp);
                        }
                    }
                }
            }
 
            while (!q.isEmpty()) {
                q.remove();
            }
        }
    }
}
//O(T∗C∗(min(P,C)+C))
