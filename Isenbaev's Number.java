import java.io.File;
import java.io.IOException;
import java.util.*;
 
public class IsenbaevNumber {
    public static void bfs(int s, ArrayList<Integer>[] adj, int[] dist, boolean[] visited) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {
            int f = q.poll();
            for (int e : adj[f])
                if (!visited[e]) {
                    visited[e] = true;
                    dist[e] = dist[f] + 1;
                    q.add(e);
                }
        }
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int p = 1;
        Map<String, Integer> mp = new TreeMap<>();
        ArrayList<Integer>[] adj = new ArrayList[301];
        for (int i = 0; i < 301; i++)
            adj[i] = new ArrayList<>();
        while (n-- > 0) {
            String f = sc.next();
            String s = sc.next();
            String t = sc.next();
            if (!mp.containsKey(f))
                mp.put(f, p++);
            if (!mp.containsKey(s))
                mp.put(s, p++);
            if (!mp.containsKey(t))
                mp.put(t, p++);
            adj[mp.get(f)].add(mp.get(s));
            adj[mp.get(f)].add(mp.get(t));
            adj[mp.get(s)].add(mp.get(f));
            adj[mp.get(s)].add(mp.get(t));
            adj[mp.get(t)].add(mp.get(f));
            adj[mp.get(t)].add(mp.get(s));
        }
        int[] dist = new int[301];
        boolean[] visited = new boolean[301];
        if (!mp.containsKey("Isenbaev"))
            mp.put("Isenbaev", 0); 
        bfs(mp.get("Isenbaev"), adj, dist, visited);
        for (String s : mp.keySet()) {
            if (mp.get(s) == 0)
                continue;
            if (!visited[mp.get(s)])
                System.out.println(s + " undefined");
            else
                System.out.println(s + " " + dist[mp.get(s)]);
        }
    }
}
//O(NlogN+N+M)
