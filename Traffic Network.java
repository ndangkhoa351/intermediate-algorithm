import java.util.*;
 
public class Main {
    static final int MAX = 10005;
    static final int INF = (int)1e9 + 7;
    static int n, m, k, s, t, u, v, d;
     
    static class Node implements Comparable<Node> {
        int id, weight;
         
        public Node(int _id, int _weight) {
            this.id = _id;
            this.weight = _weight;
        }
         
        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }
     
    static ArrayList<Node> graphS[] = new ArrayList[MAX], graphT[] = new ArrayList[MAX];
    static int[] distS = new int[MAX], distT = new int[MAX];
     
    public static void Dijkstra(int s, int[] dist, ArrayList<Node> graph[]) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
         
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.weight;
             
            if (w > dist[u]) {
                continue;
            }
             
            for (Node neighbor : graph[u]) {
                if (w + neighbor.weight < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.weight;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
     
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        while (T-- > 0) {
            n = sc.nextInt();
            m = sc.nextInt();
            k = sc.nextInt();
            s = sc.nextInt();
            t = sc.nextInt();
             
            for (int i = 1; i <= n; i++) {
                graphS[i] = new ArrayList<Node>();
                graphT[i] = new ArrayList<Node>();
                distS[i] = INF;
                distT[i] = INF;
            }
             
            for (int i = 0; i < m; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                d = sc.nextInt();
                graphS[u].add(new Node(v, d));
                graphT[v].add(new Node(u, d));
            }
             
            Dijkstra(s, distS, graphS);
            Dijkstra(t, distT, graphT);
            int res = distS[t];
             
            for (int i = 0; i < k; i++) {
                u = sc.nextInt();
                v = sc.nextInt();
                d = sc.nextInt();
                int a = distS[u] + d + distT[v];
                int b = distS[v] + d + distT[u];
                res = Math.min(res, Math.min(a, b));
            }
             
            System.out.println(res != INF ? res : -1);
        }
    }
}
//O(T∗E∗log(V))
