import java.util.*;
import java.io.*;
 
public class Main {
    static final int MAX_V = 205;
    static final int MAX_E = 205 * 204;
    static class Edge {
        int source, target, weight;
 
        public Edge(int _source, int _target, int _weight) {
            this.source = _source;
            this.target = _target;
            this.weight = _weight;
        }
    }
 
    static int n, m;
    static int[] weight = new int[MAX_V];
    static int[] dist = new int[MAX_V];
    static Edge[] graph = new Edge[MAX_E];
 
    public static void BellmanFord(int s) {
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s] = 0;
 
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < m; j++) {
                int u = graph[j].source;
                int v = graph[j].target;
                int w = graph[j].weight;
 
                if (dist[u] != Integer.MAX_VALUE) {
                    dist[v] = Math.min(dist[v], dist[u] + w);
                }
            }
        }
    }
 
    public static void main(String[] agrs) {
        MyScanner in = new MyScanner();
        int T = in.nextInt();
 
        for (int t = 1; t <= T; t++) {
            n = in.nextInt();
            for (int i = 1; i <= n; i++) {
                weight[i] = in.nextInt();
            }
 
            m = in.nextInt();
            for (int i = 0; i < m; i++) {
                int u = in.nextInt();
                int v = in.nextInt();
                graph[i] = new Edge(u, v, (int)Math.pow(weight[v] - weight[u], 3));
            }
 
            BellmanFord(1);
            System.out.println("Case " + t + ":");
            int q = in.nextInt();
 
            for (int i = 0; i < q; i++) {
                int f = in.nextInt();
                System.out.println(dist[f] != Integer.MAX_VALUE && dist[f] >= 3 ? dist[f] : "?");
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
//O(T∗V∗E)
