import java.util.*;
import java.io.*;
 
public class Main {
    static final int MAX = 10005;
    static final int INF = (int)1e9 + 7;
    static int[] dist = new int[MAX];
    static ArrayList<String> cities = new ArrayList<>();
     
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
        Arrays.fill(dist, INF);
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
 
            for (Node neighbor : graph[u]) {
                if (w + neighbor.weight < dist[neighbor.id]) {
                    dist[neighbor.id] = w + neighbor.weight;
                    pq.add(new Node(neighbor.id, dist[neighbor.id]));
                }
            }
        }
    }
 
    public static void main(String[] args) {
        MyScanner in = new MyScanner();
        int T = in.nextInt();
 
        while (T-- > 0) {
            int N = in.nextInt();
             
            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<Node>();
            }
            cities.clear();
 
            for (int u = 1; u <= N; u++) {
                String name = in.next();
                cities.add(name);
                int neighbors = in.nextInt();
                 
                for (int i = 0; i < neighbors; i++) {
                    int v = in.nextInt();
                    int w = in.nextInt();
                    graph[u].add(new Node(v, w));
                }
            }
 
            int Q = in.nextInt();
            for (int i = 0; i < Q; i++) {
                String sCity = in.next();
                String fCity = in.next();
                int s = cities.indexOf(sCity) + 1;
                int f = cities.indexOf(fCity) + 1;
                Dijkstra(s, f);
                System.out.println(dist[f]);
            }
        }
    }
 
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;
 
        public MyScanner() {
                br = new BufferedReader(new InputStreamReader(System.in));
        }
        String next() {
                while (st == null || !st.hasMoreElements()) {
                        try {
                                st = new StringTokenizer(br.readLine());
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }
                return st.nextToken();
        }
        int nextInt() {
                return Integer.parseInt(next());
        }
        long nextLong() {
                return Long.parseLong(next());
        }
        double nextDouble() {
                return Double.parseDouble(next());
        }
        String nextLine() {
                String str = "";
                try {
                        str = br.readLine();
                } catch (IOException e) {
                        e.printStackTrace();
                }
                return str;
        }
    }
}
//O(s∗p∗E∗log(V))
