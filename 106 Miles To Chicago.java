import java.util.*;

public class Main {
    static final int MAX_N = 100 + 5;
    static final int MAX_M = 100 * 50 + 5;
    static class Edge {
        int source, target;
        double weight;

        public Edge(int _source, int _target, double _weight) {
            this.source = _source;
            this.target = _target;
            this.weight = _weight;
        }
    }

    static int n, m;
    static double[] prob = new double[MAX_N];
    static Edge[] graph = new Edge[MAX_M];

    public static void BellmanFord() {
        Arrays.fill(prob, -1.0);
        prob[1] = 1.0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j].source;
                int v = graph[j].target;
                double w = graph[j].weight;

                prob[u] = Math.max(prob[u], prob[v] * w);
                prob[v] = Math.max(prob[v], prob[u] * w);
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            n = sc.nextInt();
            if (n == 0) {
                break;
            }

            m = sc.nextInt();
            
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                double w = sc.nextInt();
                graph[i] = new Edge(u, v, w / 100.0);
            }

            BellmanFord();
            System.out.printf("%.6f percent\n", prob[n] * 100.0);
        }
    }
}
//O(T∗V∗E)
