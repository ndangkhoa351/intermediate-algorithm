import java.util.*;

public class Main {
    static final int MAX_V = 1005;
    static final int MAX_E = 2005;
    static class Edge {
        int source, target, weight;

        public Edge(int _source, int _target, int _weight) {
            this.source = _source;
            this.target = _target;
            this.weight = _weight;
        }
    };

    static int n, m;
    static int dist[] = new int[MAX_V];
    static Edge graph[] = new Edge[MAX_E];

    public static boolean BellmanFord(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j].source;
                int v = graph[j].target;
                int w = graph[j].weight;

                if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int u = graph[i].source;
            int v = graph[i].target;
            int w = graph[i].weight;

            if (dist[u] != Integer.MAX_VALUE && dist[u] + w < dist[v]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();

            for (int i = 0; i < m; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                int t = sc.nextInt();
                graph[i] = new Edge(x, y, t);
            }

            System.out.println(!BellmanFord(0) ? "possible" : "not possible");
        }
    }
}
//O(T∗V∗E)
