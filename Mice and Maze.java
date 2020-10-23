import java.util.*;
 
public class Main {
    static final int MAX = 105;
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
        int E = sc.nextInt();
        int T = sc.nextInt();
        int M = sc.nextInt();
 
        for (int i = 0; i <= N; i++) {
            dist[i] = INF;
            graph[i] = new ArrayList<Node>();
        }
 
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[v].add(new Node(u, w));
        }
 
        Dijsktra(E);
         
        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= T) {
                count++;
            }
        }
 
        System.out.print(count);
    }
}
//O(V∗E∗log(V))
