import java.util.*;

public class Main {
    static final int MAX = 10005;
    static int N, M;
    static int[] visited = new int[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static boolean DFS(int u) {
        visited[u] = 1;

        for (int v : graph[u]) {
            if (visited[v] == 1) {
                return true;
            }
            else if (visited[v] == 0) {
                if (DFS(v)) {
                    return true;
                }
            }
        }

        visited[u] = 2;
        return false;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            N = sc.nextInt();
            M = sc.nextInt();

            for (int i = 1; i <= N; i++) {
                graph[i] = new ArrayList<Integer>();
                visited[i] = 0;
            }

            for (int i = 0; i < M; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                graph[u].add(v);
            }

            boolean isCyclic = false;

            for (int i = 1; i <= N; i++) {
                if (visited[i] == 0) {
                    isCyclic = DFS(i);
                    if (isCyclic) {
                        break;
                    }
                }
            }

            System.out.println(isCyclic ? "YES" : "NO");
        }
    }
}
//O(V + E)O(V+E)
