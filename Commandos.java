import java.util.*;
 
public class Main {
    static final int MAX = 105;
    static final int INF = (int)1e9 + 7;
    static int N, R;
     
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
     
    public static int[] Dijkstra(int s) {
        int[] dist = new int[N];
        Arrays.fill(dist, INF);
         
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
         
        return dist;
    }
     
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
         
        for (int t = 1; t <= T; t++) {
            N = sc.nextInt();
            R = sc.nextInt();
             
            for (int i = 0; i < N; i++) {
                graph[i] = new ArrayList<Node>();
            }
             
            for (int i = 0; i < R; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(new Node(v, 1));
                graph[v].add(new Node(u, 1));
            }
             
            int s = sc.nextInt();
            int d = sc.nextInt();
             
            int[] distS = Dijkstra(s);
            int[] distD = Dijkstra(d);
            int res = 0;
             
            for (int i = 0; i < N; i++) {
                res = Math.max(res, distS[i] + distD[i]);
            }
             
            System.out.println("Case " + t + ": " + res);
        }
    }
}
//O(T∗E∗log(V))
