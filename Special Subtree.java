import java.io.*;
import java.util.*;

class Pair implements Comparable<Pair> {
  public Integer id;
  public Integer dist;
  public Pair(Integer id, Integer dist) {
    this.id = id;
    this.dist = dist;
  }
  @Override
  public int compareTo(Pair other) {
    return this.dist.compareTo(other.dist);
  }
}

public class Main {

  private static int[] dist;
  private static int[] path;
  private static boolean[] visited;

  public static void Prim(int src, ArrayList<ArrayList<Pair>> graph) {
    PriorityQueue<Pair> pq = new PriorityQueue<Pair>();
    int n = graph.size();
    dist = new int[n];
    path = new int[n];
    visited = new boolean[n];
    Arrays.fill(dist, Integer.MAX_VALUE);
    Arrays.fill(path, -1);
    Arrays.fill(visited, false);

    pq.add(new Pair(src, 0));
    dist[src] = 0;

    while (!pq.isEmpty()) {
      Pair top = pq.poll();
      int u = top.id;
      visited[u] = true;
      for (int i = 0; i < graph.get(u).size(); i++) {
        Pair neighbor = graph.get(u).get(i);
        int v = neighbor.id;
        int w = neighbor.dist;
        if (!visited[v] && w < dist[v]) {
          dist[v] = w;
          pq.add(new Pair(v, w));
          path[v] = u;
        }
      }
    }
  }

  public static void main(String[] args) {

      Scanner sc = new Scanner(System.in);

      int n = sc.nextInt();
      int m = sc.nextInt();

      ArrayList<ArrayList<Pair>> graph = new ArrayList<ArrayList<Pair>>();

      for (int i = 0; i <= n; i++) {
        graph.add(new ArrayList<Pair>());
      }

      for (int i = 0; i < m; i++) {
        int u = sc.nextInt();
        int v = sc.nextInt();
        int w = sc.nextInt();
        graph.get(v).add(new Pair(u, w));
        graph.get(u).add(new Pair(v, w));
      }

      int start = sc.nextInt();

      Prim(start, graph);

      int result = 0;

      for (int i = 0; i <= n; i++)
        if (path[i] != -1)
          result += dist[i];

      System.out.println(result);

      sc.close();

  }

}
//O(MlogN)
