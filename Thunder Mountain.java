import java.util.*;

public class Main {
    static final int INF = 2049;
    static final int MAX = 105;
    static int n;
    static int[] x = new int[MAX], y = new int[MAX];
    static double[][] dist = new double[MAX][MAX];

    public static double getDistance(int i, int j) {
        return Math.sqrt(Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2));
    }

    public static void FloydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int t = 1; t <= N; t++) {
            n = sc.nextInt();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    dist[i][j] = (i == j ? 0 : INF);
                }
            }

            for (int i = 0; i < n; i++) {
                x[i] = sc.nextInt();
                y[i] = sc.nextInt();
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double d = getDistance(i, j);
                    if (d <= 10) {
                        dist[i][j] = d;
                    }
                }
            }

            FloydWarshall();

            double res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dist[i][j]);
                }
            }

            System.out.println("Case #" + t + ":");
            if (res != INF) {
                System.out.printf("%.4f\n", res);
            }
            else {
                System.out.println("Send Kurdy");
            }
            System.out.println();
        }
    }
}
//O(T∗N^3)
