import java.util.*;

public class Main {
    static final int MAX = 10005;
    static int N, M;
    static ArrayList<Integer> graph[] = new ArrayList[MAX];

    public static int DFS(int src) {
        boolean[] visited = new boolean[N + 1];
        Stack<Integer> s = new Stack<>();
        visited[src] = true;
        s.add(src);

        int nbombs = 0;

        while (!s.isEmpty()) {
            int u = s.pop();
            nbombs++;

            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
                    s.add(v);
                }
            }
        }

        return nbombs;
    }

    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
        }

        int max_bombs = 0;

        for (int i = 1; i <= N; i++) {
            max_bombs = Math.max(max_bombs, DFS(i));
        }

        System.out.print(max_bombs);
    }
}
//O(V∗(V+E))
