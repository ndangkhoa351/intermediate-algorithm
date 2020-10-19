import java.util.*;
 
public class Main {
    static final int MAX = 100000 + 5;
    static final int MOD = 100000;
    static int N;
    static int[] dist = new int[MAX];
    static int[] a = new int[MAX];
 
    public static int BFS(int s, int f) {
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        dist[s] = 0;
 
        while (!q.isEmpty()) {
            int u = q.poll();
 
            for (int i = 0; i < N; i++) {
                Long temp = (1L * a[i] * u) % MOD;
                int v = temp.intValue();
 
                if (dist[v] == -1) {
                    dist[v] = dist[u] + 1;
                    q.add(v);
 
                    if (v == f) {
                        return dist[v];
                    }
                }
            }
        }
 
        return -1;
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int f = sc.nextInt();
        N = sc.nextInt();
 
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
        }
 
        System.out.print(BFS(s, f));
    }
}
//O(100.000∗N)
