import java.util.*;

public class Main {
    static final int MAX = 105;
    static int n, m;
    static class Edge {
        int source, target;

        public Edge(int _source, int _target) {
            this.source = _source;
            this.target = _target;
        }
    };

    static int[] energy = new int[MAX];
    static int[] dist = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static ArrayList<Edge> graph = new ArrayList<>();

    public static boolean hasPathBFS(int s, int f) {
        Arrays.fill(visited, false);
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;

        while (!q.isEmpty()) {
            int u = q.poll();

            for (Edge edge : graph) {
                if (edge.source == u) {
                    int v = edge.target;

                    if (!visited[v]) {
                        visited[v] = true;
                        q.add(v);
                    }

                    if (v == f) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean BellmanFord(int s, int f) {
        Arrays.fill(dist, Integer.MIN_VALUE);
        dist[1] = 100;

        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : graph) {
                int u = edge.source;
                int v = edge.target;
                if (dist[u] > 0) {
                    dist[v] = Math.max(dist[v], dist[u] + energy[v]);
                }
            }
        }

        for (Edge edge : graph) {
            int u = edge.source;
            int v = edge.target;
            if (dist[u] > 0 && dist[u] + energy[v] > dist[v] && hasPathBFS(u, f)) {
                return true;
            }
        }

        return dist[f] > 0;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            graph.clear();
            
            n = sc.nextInt();
            if (n == -1) {
                break;
            }

            for (int u = 1; u <= n; u++) {
                energy[u] = sc.nextInt();
                m = sc.nextInt();

                for (int i = 0; i < m; i++) {
                    int v = sc.nextInt();
                    graph.add(new Edge(u, v));
                }
            }

            boolean canGo = BellmanFord(1, n);
            System.out.println(canGo ? "winnable" : "hopeless");
        }
    }
}
//O(T∗E∗(E+V))
