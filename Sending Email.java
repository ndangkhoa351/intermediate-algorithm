import java.util.*;
 
public class Main {
    static final int MAX = 20005;
    static final int INF = (int)1e9 + 7;
    static int Q;
    static int[] dist = new int[MAX];
     
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
     
    static ArrayList<Node> graph[] = new ArrayList[MAX];
     
    public static void Dijkstra(int s, int f) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
         
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.weight;
             
            if (u == f) {
                break;
            }
             
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
     
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Q = sc.nextInt();
         
        for (int t = 1; t <= Q; t++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int S = sc.nextInt();
            int T = sc.nextInt();
             
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<Node>();
                dist[i] = INF;
            }
             
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int w = sc.nextInt();
                graph[u].add(new Node(v, w));
                graph[v].add(new Node(u, w));
            }
             
            Dijkstra(S, T);
             
            System.out.print("Case #" + t + ": ");
            System.out.println(dist[T] != INF ? dist[T] : "unreachable");
        }
    }
}
//O(Q∗E∗log(V))
