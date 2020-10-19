import java.util.*;
 
public class Main {
    static final int MAX = 1000 + 5;
    static int V, E;
    static boolean[] visited = new boolean[MAX];
    static int[] dist = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];
 
    public static void BFS(int s) {
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
 
        while (!q.isEmpty()) {
            int u = q.poll();
 
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    dist[v] = dist[u] + 1;
                    q.add(v);
                }
            }
        }
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int Q = sc.nextInt();
         
        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }
 
        while (Q-- > 0) {
            V = sc.nextInt();
            E = sc.nextInt();
 
            for (int i = 0; i < MAX; i++) {
                graph[i].clear();
                visited[i] = false;
                dist[i] = 0;
            }
 
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
                graph[v].add(u);
            }
 
            int s = sc.nextInt();
            BFS(s);
 
            for (int i = 1; i <= V; i++) {
                if (i == s) {
                    continue;
                }
 
                System.out.print((visited[i] ? dist[i] * 6 : -1) + " ");
            }
 
            System.out.println();
        }
    }
}
//O(T∗(V+E))
