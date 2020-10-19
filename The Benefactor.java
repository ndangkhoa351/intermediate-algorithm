import java.util.*;

public class Main {
    static final int MAX = 50000 + 5;
    static int V, E, leaf;
    static long max_dist;
    static long[] dist = new long[MAX];
    
    static class Triad {
        int v, w;

        public Triad(int _v, int _w) {
            this.v = _v;
            this.w = _w;
        }
    };

    static ArrayList<Triad> graph[] = new ArrayList[MAX];

    public static void DFS(int src) {
        for (int i = 0; i <= V; i++) {
            dist[i] = -1;
        }

        Stack<Integer> s = new Stack<>();
        s.add(src);
        dist[src] = 0;

        while (!s.isEmpty()) {
            int u = s.pop();

            for (Triad neighbor : graph[u]) {
                int v = neighbor.v;
                int w = neighbor.w;

                if (dist[v] == -1) {
                    dist[v] = dist[u] + w;
                    s.add(v);

                    if (dist[v] > max_dist) {
                        max_dist = dist[v];
                        leaf = v;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            V = sc.nextInt();
            E = V - 1;

            for (int i = 0; i <= V; i++) {
                graph[i] = new ArrayList<Triad>();
            }

            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                graph[u].add(new Triad(v, w));
                graph[v].add(new Triad(u, w));
            }

            max_dist = 0;

            DFS(1);
            DFS(leaf);

            System.out.println(max_dist);
        }
    }
}
//O(T∗(V+E))
