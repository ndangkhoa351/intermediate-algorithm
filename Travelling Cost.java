import java.util.*;
 
public class Main {
    static final int MAX = 505;
    static final int INF = (int)1e9 + 7;
    static final int[] dist = new int[MAX];
 
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
 
    public static void Dijsktra(int s) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(s, 0));
        dist[s] = 0;
 
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            int w = top.weight;
 
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
        int N = sc.nextInt();
 
        for (int i = 0; i < MAX; i++) {
            dist[i] = INF;
            graph[i] = new ArrayList<Node>();
        }
 
        for (int i = 0; i < N; i++) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int W = sc.nextInt();
            graph[A].add(new Node(B, W));
            graph[B].add(new Node(A, W));
        }
 
        int S = sc.nextInt();
        Dijsktra(S);
        int Q = sc.nextInt();
         
        for (int i = 0; i < Q; i++) {
            int V = sc.nextInt();
            System.out.println(dist[V] != INF ? dist[V] : "NO PATH");
        }
    }
}
//O(E∗log(V))
