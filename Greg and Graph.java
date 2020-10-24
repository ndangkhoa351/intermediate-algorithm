import java.util.*;

public class Main {
    static final int MAX = 505;
    static int n;
    static int[][] dist = new int[MAX][MAX];
    static long[] res = new long[MAX];
    static int[] middleV = new int[MAX];

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                dist[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            middleV[i] = sc.nextInt();
        }

        for (int index = n - 1; index >= 0; index--) {
            int k = middleV[index];
            
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }

            for (int i = index; i < n; i++) {
                int u = middleV[i];
                for (int j = index; j < n; j++) {
                    int v = middleV[j];
                    res[index] += dist[u][v];
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
//O(N^3)
