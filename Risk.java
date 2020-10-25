import java.util.*;

public class Main {
    static final int INF = (int)1e9 + 7;
    static final int N = 20;
    static int[][] dist = new int[N + 1][N + 1];

    public static void FloydWarshall() {
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
    
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (sc.hasNext()) {
            for (int i = 1; i <= N; i++) {
                Arrays.fill(dist[i], INF);
            }

            for (int i = 1; i < N; i++) {
                int X = sc.nextInt();

                while (X-- > 0) {
                    int j = sc.nextInt();
                    dist[i][j] = dist[j][i] = 1;
                }
            }

            FloydWarshall();
            System.out.println("Test Set #" + t++);

            int Q = sc.nextInt();
            for (int i = 0; i < Q; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                System.out.format("%2d to %2d: %d\n", u, v, dist[u][v]);
            }
            System.out.println();
        }
    }
}
//O(T∗N^3)
