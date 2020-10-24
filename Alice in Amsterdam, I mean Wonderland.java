import java.util.*;
import java.io.*;

public class Main {
   static final long INF = (1l << 30) * 100 + 7;
   static final int MAX = 105;

   static class Edge {
      int source, target;
      long weight;
      
      public Edge(int _source, int _target, long _weight) {
         this.source = _source;
         this.target = _target;
         this.weight = _weight;
      }
   };

   static int n, m;
   static long[][] dist = new long[MAX][MAX];
   static String[] monuments = new String[MAX];
   static Edge[] graph = new Edge[MAX * MAX];

   public static void BellmanFord(int s) {
      dist[s][s] = 0;

      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < m; j++) {
            int u = graph[j].source;
            int v = graph[j].target;
            long w = graph[j].weight;
            if (dist[s][u] != INF && dist[s][u] + w < dist[s][v]) {
               dist[s][v] = dist[s][u] + w;
            }
         }
      }

      for (int i = 0; i < n - 1; i++) {
         for (int j = 0; j < m; j++) {
            int u = graph[j].source;
            int v = graph[j].target;
            long w = graph[j].weight;
            if (dist[s][u] != INF && dist[s][u] + w < dist[s][v]) {
               dist[s][v] = -INF;
            }
         }
      }
   }

   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int tc = 1;

      while (true) {
         n = sc.nextInt();
         m = 0;
         if (n == 0) {
            break;
         }

         for (int i = 0; i < n; i++) {
            monuments[i] = sc.next();
            for (int j = 0; j < n; j++) {
               long w = sc.nextLong();
               dist[i][j] = INF;
               if (i != j && w == 0) {
                  continue;
               }
               if (i == j && w >= 0) {
                  w = 0;
               }
               graph[m++] = new Edge(i, j, w);
            }
         }

         for (int i = 0; i < n; i++) {
            BellmanFord(i);
         }

         int q = sc.nextInt();
         System.out.println("Case #" + tc++ + ":");

         while (q-- > 0) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            if (dist[u][v] <= -INF) {       // Be careful here
               System.out.println("NEGATIVE CYCLE");
            }
            else {
               System.out.print(monuments[u] + "-" + monuments[v] + " ");
               System.out.println(dist[u][v] != INF ? dist[u][v] : "NOT REACHABLE");
            }
         }
      }
   }
}
//O(T∗N^4)
