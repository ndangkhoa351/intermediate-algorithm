import java.util.*;

public class Main {
    static final int MAX = 48;
    static int[][] dist = new int[MAX + 1][MAX + 1];

    public static void FloydWarshall() {
        for (int k = 0; k <= MAX; k++) {
            for (int i = 0; i <= MAX; i++) {
                for (int j = 0; j <= MAX; j++) {
                    if (i <= k && k <= j) {
                        dist[i][j] = Math.max(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int N = sc.nextInt();
            for (int i = 0; i <= MAX; i++) {
                Arrays.fill(dist[i], 0);
            }
            
            for (int i = 0; i < N; i++) {
                int S = sc.nextInt();
                int E = sc.nextInt();
                int C = sc.nextInt();
                if (C > dist[S][E]) {
                    dist[S][E] = C;
                }
            }

            FloydWarshall();
            System.out.println(dist[0][MAX]);
        }
    }
}
//O(T∗N^3)
