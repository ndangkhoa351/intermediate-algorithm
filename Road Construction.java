import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeMap;
import java.util.Scanner;

class Node implements Comparable<Node> {
    public Integer id;
    public Integer dist;
    
    public Node(Integer id, Integer dist) {
        this.id = id;
        this.dist = dist;
    }
    
    @Override
    public int compareTo(Node other) {
        return this.dist.compareTo(other.dist);
    }
}

public class Main {
    private static int[] dist;
    private static int[] path;
    private static boolean[] visited;
    
    public static int prim(ArrayList<ArrayList<Node>> graph) {
        PriorityQueue<Node> pq = new PriorityQueue<Node>();
        int n = graph.size();
        dist = new int[n];
        path = new int[n];
        visited = new boolean[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        Arrays.fill(path, -1);
        Arrays.fill(visited, false);
        pq.add(new Node(1, 0));
        dist[1] = 0;
        while (!pq.isEmpty()) {
            Node top = pq.poll();
            int u = top.id;
            visited[u] = true;
            for (int i = 0; i < graph.get(u).size(); i++) {
                Node neighbor = graph.get(u).get(i);
                int v = neighbor.id, w = neighbor.dist;
                if (!visited[v] && w < dist[v]) {
                    dist[v] = w;
                    pq.add(new Node(v, w));
                    path[v] = u;
                }
            }
        }
        
        int mst = 0;
        for (int i = 1; i < n; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }
            mst += dist[i];
        }
        return mst;
    }
    
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int cs = 1; cs <= t; cs++) {
            TreeMap<String, Integer> my_map = new TreeMap<String, Integer>();
            ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
            int m = sc.nextInt();
            int n = 0;
            int u, v, w;
            String s1, s2;
            
            // graph index from 1
            // add temporary graph[0]
            graph.add(new ArrayList<Node>());
            for (int i = 0; i < m; i++) {
                s1 = sc.next();
                s2 = sc.next();
                w = sc.nextInt();
                
                if (my_map.containsKey(s1) == false){
                    my_map.put(s1, ++n);
                    graph.add(new ArrayList<Node>());
                }
                if (my_map.containsKey(s2) == false) {
                    my_map.put(s2, ++n);
                    graph.add(new ArrayList<Node>());
                }
                u = my_map.get(s1);
                v = my_map.get(s2);
                graph.get(u).add(new Node(v, w));
                graph.get(v).add(new Node(u, w));
            }
            int mst = prim(graph);
            System.out.print("Case " + cs + ": ");
            if (mst == -1) {
                System.out.println("Impossible");
            }
            else {
                System.out.println(mst);
            }
        }
        return;
    }
}
//O(t∗(mlogn+nlogn))
