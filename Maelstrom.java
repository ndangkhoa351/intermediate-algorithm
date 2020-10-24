import java.util.*;
 
public class Main {
    static final int INF = (int)1e9 + 7;
    static class Edge {
        int source, target, weight;
 
        public Edge(int _source, int _target, int _weight) {
            this.source = _source;
            this.target = _target;
            this.weight = _weight;
        }
    }
 
    public static void BellmanFord(int s, int n, int[] dist, ArrayList<Edge> graph) {
        dist[s] = 0;
 
        for (int i = 0; i < n - 1; i++) {
            for (Edge edge : graph) {
                int u = edge.source;
                int v = edge.target;
                int w = edge.weight;
                dist[v] = Math.min(dist[v], dist[u] + w);
            }
        }
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        ArrayList<Edge> graph = new ArrayList<>();
 
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                String temp = sc.next();
 
                if (!temp.equals("x")) {
                    int w = Integer.parseInt(temp);
                    graph.add(new Edge(i, j, w));
                    graph.add(new Edge(j, i, w));
                }
            }
        }
 
        BellmanFord(1, n, dist, graph);
         
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dist[i]);
        }
        System.out.print(res);
    }
}
//O(n×m) 
