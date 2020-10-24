import java.util.*;

public class Main {
    static final int INF = (int)1e9 + 7;
    static final int MAX = 85;
    static int C, R;
    static int[] f = new int[MAX];
    static int[][] dist = new int[MAX][MAX];
    static int[][] maxCost = new int[MAX][MAX];

    public static void FloydWarshall() {
        int times = 2;

        while (times-- > 0) {
            for (int k = 1; k <= C; k++) {
                for (int i = 1; i <= C; i++) {
                    for (int j = 1; j <= C; j++) {
                        int maxFeast = Math.max(maxCost[i][k], maxCost[k][j]);
                        if (dist[i][j] + maxCost[i][j] > dist[i][k] + dist[k][j] + maxFeast) {
                            dist[i][j] = dist[i][k] + dist[k][j];
                            maxCost[i][j] = maxFeast;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = 1;

        while (true) {
            C = sc.nextInt();
            R = sc.nextInt();
            int Q = sc.nextInt();

            if (C == 0) {
                break;
            }

            for (int i = 1; i <= C; i++) {
                f[i] = sc.nextInt();
            }

            for (int i = 1; i <= C; i++) {
                for (int j = 1; j <= C; j++) {
                    dist[i][j] = INF;
                    maxCost[i][j] = Math.max(f[i], f[j]);
                }
            }

            for (int i = 0; i < R; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                dist[u][v] = dist[v][u] = w;
            }

            FloydWarshall();

            if (t > 1) {
                System.out.println();
            }
            System.out.println("Case #" + t++);

            for (int i = 0; i < Q; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                System.out.println(dist[u][v] == INF ? -1 : dist[u][v] + maxCost[u][v]);
            }
        }
    }
}
//O(T∗C^3)
