import java.util.*;

public class Main {
    static final int MAX = 1000 + 5;
    static int V, E;
    static boolean[] visited = new boolean[MAX];
    static int[] dist = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static void DFS(int scr) {
        Stack<Integer> s = new Stack<>();
        visited[scr] = true;
        s.add(scr);

        while (!s.isEmpty()) {
            int u = s.pop();

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    s.add(v);
                }
            }
        }
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);;
        V = sc.nextInt();
        E = V - 1;

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }

        DFS(1);
        int ans = 0;
        int min_dist = MAX;
        int Q = sc.nextInt();

        for (int i = 0; i < Q; i++) {
            int u = sc.nextInt();

            if (dist[u] < min_dist || (dist[u] == min_dist && u < ans)) {
                min_dist = dist[u];
                ans = u;
            }
        }

        System.out.print(ans);
    }
}
//O(V+E+Q)
