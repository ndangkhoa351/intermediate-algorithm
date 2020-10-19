import java.util.*;
 
public class Main {
    static final int MAX = 100000 + 5;
    static int n, m;
    static int[] a = new int[MAX];
    static int[] cat = new int[MAX];
    static boolean[] visited = new boolean[MAX];
    static ArrayList<Integer> graph[] = new ArrayList[MAX];
 
    public static int BFS(int s) {
        int nrestaurants = 0;
        Queue<Integer> q = new LinkedList<>();
        visited[s] = true;
        q.add(s);
 
        cat[s] = (a[s] == 1 ? 1 : 0);
 
        while (!q.isEmpty()) {
            int u = q.poll();
 
            for (int v : graph[u]) {
                if (!visited[v]) {
                    visited[v] = true;
 
                    if (a[v] == 1) {
                        cat[v] = cat[u] + 1;
                    }
     
                    if (cat[v] <= m) {
                        if (graph[v].size() == 1) {
                            nrestaurants++;
                        }
                        else {
                            q.add(v);
                        }
                    }
                }                
            }
        }
 
        return nrestaurants;
    }
 
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
 
        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            graph[i] = new ArrayList<>();
        }
 
        for (int i = 1; i < n; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
 
        System.out.print(BFS(1));
    }   
}
//O(V+E)
